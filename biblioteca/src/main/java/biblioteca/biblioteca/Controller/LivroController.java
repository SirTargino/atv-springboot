package biblioteca.biblioteca.Controller;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Service.LivroCrudService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/livros", produces = MediaType.APPLICATION_JSON_VALUE)
public class LivroController {

    @Autowired
    LivroCrudService livroCrudService;

    @PostMapping("")
    public ResponseEntity<LivroResponseDto> criarLivro(
            @RequestBody @Valid LivroPostPutDto livroPostPutDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(livroCrudService.criarLivro(livroPostPutDto));
    }

    @GetMapping("")
    public ResponseEntity<List<LivroResponseDto>> buscarTodosLivros() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(livroCrudService.buscarTodosLivros());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<LivroResponseDto> buscarLivro(@PathVariable String isbn) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(livroCrudService.buscarLivro(isbn));
    }

    @GetMapping("/buscar/isbn")
    public ResponseEntity<List<LivroResponseDto>> buscarLivrosPorIsbn(@RequestParam String isbn) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(livroCrudService.buscarLivrosPorIsbn(isbn));
    }

    @GetMapping("/buscar/titulo")
    public ResponseEntity<List<LivroResponseDto>> buscarLivrosPorTitulo(@RequestParam String titulo) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(livroCrudService.buscarLivrosPorTitulo(titulo));
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<LivroResponseDto> atualizarLivro(
            @PathVariable String isbn,
            @RequestBody @Valid LivroPostPutDto livroPostPutDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(livroCrudService.atualizarLivro(isbn, livroPostPutDto));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<Void> removerLivro(@PathVariable String isbn) {
        livroCrudService.removerLivro(isbn);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
