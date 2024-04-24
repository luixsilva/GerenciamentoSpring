package demo.demo.services;

import demo.demo.dtos.SetorDTO;
import demo.demo.dtos.DadosSetorDTO;
import demo.demo.models.Setor;
import demo.demo.repositories.SetorRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SetorServiceImpl implements SetorService {
    @Autowired
    private SetorRepository setorRepository;

    @Override
    @Transactional
    public void adicionar(SetorDTO setorDTO) {
        Setor setor = new Setor();
        setor.setNome(setorDTO.getNome());
        setorRepository.save(setor);
    }

    @Override
    @Transactional
    public DadosSetorDTO buscarSetorPorId(Integer idSetor) {
        Setor setor = setorRepository.findById(idSetor).orElse(null);
        if (setor != null) {
            List<String> funcionarios = setor.getFuncionarios().stream()
                    .map(funcionario -> funcionario.getNome())
                    .collect(Collectors.toList());
            return DadosSetorDTO.builder()
                    .setorDTO(SetorDTO.builder().nome(setor.getNome()).build())
                    .funcionarios(funcionarios)
                    .build();
        }
        return null;
    }
}