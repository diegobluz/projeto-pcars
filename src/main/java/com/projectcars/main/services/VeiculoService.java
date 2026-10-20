package com.projectcars.main.services;

import com.projectcars.main.models.Veiculo;
import com.projectcars.main.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo salvarVeiculo(Veiculo veiculo) {
        veiculo.setId(null);
        veiculoRepository.save(veiculo);
        return veiculo;
    }

    public List<Veiculo> listarVeiculos() {
        return veiculoRepository.findAll();
    }

    public Veiculo obterVeiculoPorId(Integer id) {
        return veiculoRepository.findById(id).orElseThrow();
    }

    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculo) {
        Veiculo veiculoExistente = obterVeiculoPorId(id);
        veiculoExistente.setModelo(veiculo.getModelo());
        veiculoExistente.setPlaca(veiculo.getPlaca());
        veiculoExistente.setMarca(veiculo.getMarca());
        veiculoExistente.setValor(veiculo.getValor());

veiculoExistente.setDisponibilidade(veiculo.getDisponibilidade());
        veiculoRepository.save(veiculoExistente);
        return veiculoExistente;
    }

    public void deletarVeiculo(Integer id) {
        Veiculo veiculoEncontrado = obterVeiculoPorId(id);
        veiculoRepository.deleteById(veiculoEncontrado.getId());
    }
}

