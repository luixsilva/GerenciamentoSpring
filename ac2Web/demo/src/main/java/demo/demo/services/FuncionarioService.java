package demo.demo.services;

import demo.demo.dtos.FuncionarioDTO;
import demo.demo.dtos.DadosProjetoDTO;

import java.util.List;

public interface FuncionarioService {
    void adicionar(FuncionarioDTO funcionarioDTO);
    List<DadosProjetoDTO> buscarProjetos(Integer idFuncionario);
}