package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroPostPutDto {
    @JsonProperty("isbn")
    @NotBlank(message = "ISBN não pode ser vazio")
    private String isbn;

    @JsonProperty("titulo")
    @NotBlank(message = "Titulo não pode ser vazio")
    private String titulo;

    @JsonProperty("id_autor")
    @NotNull(message = "Autor não pode ser vazio")
    private Long autorId;

    @JsonProperty("ano")
    private String ano;

    @JsonProperty("edicao")
    private String edicao;
}