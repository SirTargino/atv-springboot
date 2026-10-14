package biblioteca.biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "tb_livro")
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    @Id
    @JsonProperty("isbn")
    private Long isbn;

    @Column(name = "ds_titulo", nullable = false)
    @JsonProperty("titulo")
    private String titulo;

    @Column(name = "fk_autor", nullable = false)
    @JsonProperty("id_autor")
    private String id_autor;

    @Column(name = "nu_ano", nullable = false)
    @JsonProperty("ano")
    private String ano;

    @Column(name = "cd_edicao", nullable = false)
    @JsonProperty("edicao")
    private String edicao;
}