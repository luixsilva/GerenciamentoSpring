package demo.demo.repositories;

import demo.demo.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
    // Consultas personalizadas
    @Query("SELECT p FROM Projeto p JOIN FETCH p.funcionarios WHERE p.id = :projetoId")
    Projeto findByIdWithFuncionarios(Integer projetoId);

    List<Projeto> findByDataInicioBetween(LocalDate dataInicio, LocalDate dataFim);
}