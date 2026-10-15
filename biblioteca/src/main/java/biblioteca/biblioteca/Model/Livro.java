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
    private String isbn;

    @Column(name = "titulo", nullable = false)
    @JsonProperty("titulo")
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_autor", nullable = false)
    private Autor autor;

    @Column(name = "ano", nullable = false)
    @JsonProperty("ano")
    private String ano;

    @Column(name = "edicao", nullable = false)
    @JsonProperty("edicao")
    private String edicao;
}