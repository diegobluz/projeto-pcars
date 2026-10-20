package com.projectcars.main.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/*
 * @author Diego Luz
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Veiculo")
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String modelo;
    private String placa;
    private String marca;
    private String valor;
    private String disponibilidade;
}
