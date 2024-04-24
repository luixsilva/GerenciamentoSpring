package demo.demo.controllers;

import demo.demo.dtos.SetorDTO;
import demo.demo.dtos.DadosSetorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import demo.demo.services.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {
    @Autowired
    private SetorService setorService;

    @PostMapping("/adicionar")
    public void adicionar(@RequestBody SetorDTO setorDTO) {
        setorService.adicionar(setorDTO);
    }

    @GetMapping("/buscarSetorPorId/{idSetor}")
    public DadosSetorDTO buscarSetorPorId(@PathVariable Integer idSetor) {
        return setorService.buscarSetorPorId(idSetor);
    }
}