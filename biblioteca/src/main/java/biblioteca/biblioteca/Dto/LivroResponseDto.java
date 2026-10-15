package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponseDto {
    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("id_autor")
    private Long autorId;

    @JsonProperty("nomeAutor")
    private String nomeAutor;

    @JsonProperty("ano")
    private String ano;

    @JsonProperty("edicao")
    private String edicao;
}
