package demo.demo.services;

import demo.demo.dtos.FuncionarioDTO;
import demo.demo.dtos.ProjetoDTO;
import demo.demo.dtos.DadosProjetoDTO;
import demo.demo.models.Funcionario;
import demo.demo.models.Projeto;
import demo.demo.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public void adicionar(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionarioRepository.save(funcionario);
    }

    @Override
    public List<DadosProjetoDTO> buscarProjetos(Integer idFuncionario) {
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).orElse(null);
        if (funcionario != null) {
            return funcionario.getProjetos().stream()
                    .map((Projeto projeto) -> DadosProjetoDTO.builder() 
                            .projetoDTO(ProjetoDTO.builder()
                                    .descricao(projeto.getDescricao())
                                    .dataInicio(projeto.getDataInicio())
                                    .dataFim(projeto.getDataFim())
                                    .build())
                            .funcionarios(projeto.getFuncionarios().stream()
                                    .map(func -> func.getNome())
                                    .collect(Collectors.toList()))
                            .build())
                    .collect(Collectors.toList());
        }
        return null;
    }
}