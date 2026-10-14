package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.AutorPostPutDto;
import biblioteca.biblioteca.Dto.AutorResponseDto;

import java.util.List;

public interface LivroCrudService {

    AutorResponseDto criarLivro(AutorPostPutDto autorPostPutDto);

    List<AutorResponseDto> buscarTodosLivros();

    AutorResponseDto buscarLivro(Long id);

    AutorResponseDto atualizarLivro(Long id, AutorPostPutDto autorPostPutDto);

    void removerLivro(Long id);
}