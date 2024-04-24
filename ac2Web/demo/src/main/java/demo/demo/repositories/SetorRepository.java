package demo.demo.repositories;

import demo.demo.models.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SetorRepository extends JpaRepository<Setor, Integer> {
    // Consulta personalizada aqui, se necessário
    @Query("SELECT s FROM Setor s JOIN FETCH s.funcionarios")
    List<Setor> findAllWithFuncionarios();
}

