package demo.demo.repositories;

import demo.demo.models.Funcionario;
import demo.demo.models.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
 
    @Query("SELECT f.projetos FROM Funcionario f WHERE f.id = :funcionarioId")
    List<Projeto> findProjetosByFuncionarioId(Integer funcionarioId);
}
