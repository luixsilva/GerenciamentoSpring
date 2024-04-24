// DadosProjetoDTO.java
package demo.demo.dtos;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosProjetoDTO {
    private ProjetoDTO projetoDTO;
    private List<String> funcionarios;
}