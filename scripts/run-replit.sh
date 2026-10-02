#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/.."

db_dir="$PWD/.local/mysql-dev"
db_socket="$PWD/.local/mysql-dev.sock"
db_pid="$PWD/.local/mysql-dev.pid"
db_log="$PWD/.local/mysql-dev.log"

mkdir -p "$PWD/.local"
if [ ! -d "$db_dir/mysql" ]; then
  mariadb-install-db --no-defaults --datadir="$db_dir" \
    --auth-root-authentication-method=normal --skip-test-db
fi

mariadbd --no-defaults --datadir="$db_dir" --socket="$db_socket" \
  --pid-file="$db_pid" --log-error="$db_log" \
  --bind-address=127.0.0.1 --port=3306 &
db_process=$!
trap 'kill "$db_process" 2>/dev/null || true; wait "$db_process" 2>/dev/null || true' EXIT

for attempt in $(seq 1 60); do
  if mariadb --no-defaults --user=root --protocol=socket --socket="$db_socket" -e 'SELECT 1' >/dev/null 2>&1; then
    break
  fi
  if ! kill -0 "$db_process" 2>/dev/null; then
    cat "$db_log" >&2
    exit 1
  fi
  if [ "$attempt" -eq 60 ]; then
    cat "$db_log" >&2
    echo "MariaDB did not start in time" >&2
    exit 1
  fi
  sleep 1
done

mariadb --no-defaults --user=root --protocol=socket --socket="$db_socket" <<'SQL'
CREATE DATABASE IF NOT EXISTS pcars CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER IF NOT EXISTS 'pcars_dev'@'127.0.0.1' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON pcars.* TO 'pcars_dev'@'127.0.0.1';
SQL

mvn spring-boot:run -Dspring-boot.run.profiles=replit