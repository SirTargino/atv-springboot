package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;

import java.util.List;

public interface LivroCrudService {

    LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto);

    LivroResponseDto buscarLivro(String isbn);

    List<LivroResponseDto> buscarTodosLivros();

    List<LivroResponseDto> buscarLivrosPorIsbn(String isbn);

    List<LivroResponseDto> buscarLivrosPorTitulo(String titulo);

    LivroResponseDto atualizarLivro(String isbn, LivroPostPutDto livroPostPutDto);

    void removerLivro(String isbn);
}