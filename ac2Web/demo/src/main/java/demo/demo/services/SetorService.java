package demo.demo.services;

import demo.demo.dtos.SetorDTO;
import demo.demo.dtos.DadosSetorDTO;

public interface SetorService {
    void adicionar(SetorDTO setorDTO);
    DadosSetorDTO buscarSetorPorId(Integer idSetor);
}