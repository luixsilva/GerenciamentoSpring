package demo.demo.services;

import demo.demo.dtos.ProjetoDTO;
import demo.demo.dtos.DadosProjetoDTO;
import demo.demo.models.Funcionario;
import demo.demo.models.Projeto;
import demo.demo.repositories.ProjetoRepository;
import demo.demo.repositories.FuncionarioRepository;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoServiceImpl implements ProjetoService {
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public void adicionar(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto();
        projeto.setDescricao(projetoDTO.getDescricao());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFim(projetoDTO.getDataFim());
        projetoRepository.save(projeto);
    }

    @Override
    public DadosProjetoDTO buscarProjetoPorId(Integer id) {
        Projeto projeto = projetoRepository.findById(id).orElse(null);
        if (projeto != null) {
            return DadosProjetoDTO.builder()
                    .projetoDTO(ProjetoDTO.builder()
                            .descricao(projeto.getDescricao())
                            .dataInicio(projeto.getDataInicio())
                            .dataFim(projeto.getDataFim())
                            .build())
                    .funcionarios(projeto.getFuncionarios().stream()
                            .map(func -> func.getNome())
                            .collect(Collectors.toList()))
                    .build();
        }
        return null;
    }

    @Override
    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto).orElse(null);
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElse(null);
        if (projeto != null && funcionario != null) {
            projeto.addFuncionario(funcionario);}
        }
    }