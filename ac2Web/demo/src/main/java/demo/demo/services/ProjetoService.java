package demo.demo.services;

import demo.demo.dtos.ProjetoDTO;
import demo.demo.dtos.DadosProjetoDTO;

public interface ProjetoService {
    void adicionar(ProjetoDTO projetoDTO);
    DadosProjetoDTO buscarProjetoPorId(Integer id);
    void vincularFuncionario(Integer idProjeto, Integer idFuncionario);
}