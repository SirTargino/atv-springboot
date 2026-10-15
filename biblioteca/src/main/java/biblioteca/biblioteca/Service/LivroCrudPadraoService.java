package biblioteca.biblioteca.Service;

import biblioteca.biblioteca.Dto.LivroPostPutDto;
import biblioteca.biblioteca.Dto.LivroResponseDto;
import biblioteca.biblioteca.Model.Autor;
import biblioteca.biblioteca.Model.Livro;
import biblioteca.biblioteca.Repository.AutorRepository;
import biblioteca.biblioteca.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LivroCrudPadraoService implements LivroCrudService {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Override
    public LivroResponseDto criarLivro(LivroPostPutDto livroPostPutDto) {
        Livro livro = Livro.builder()
                .isbn(livroPostPutDto.getIsbn())
                .titulo(livroPostPutDto.getTitulo())
                .autor(obterAutorExistente(livroPostPutDto.getAutorId()))
                .ano(livroPostPutDto.getAno())
                .edicao(livroPostPutDto.getEdicao())
                .build();
        return converterParaResponse(livroRepository.save(livro));
    }

    @Override
    public LivroResponseDto buscarLivro(String isbn) {
        return converterParaResponse(obterLivroExistente(isbn));
    }

    @Override
    public List<LivroResponseDto> buscarTodosLivros() {
        return livroRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    @Override
    public List<LivroResponseDto> buscarLivrosPorIsbn(String isbn) {
        return livroRepository.findByIsbnContaining(isbn)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    @Override
    public List<LivroResponseDto> buscarLivrosPorTitulo(String titulo) {
        return livroRepository.findByTituloContainingIgnoreCase(titulo)
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    @Override
    public LivroResponseDto atualizarLivro(String isbn, LivroPostPutDto livroPostPutDto) {
        Livro livro = obterLivroExistente(isbn);
        livro.setTitulo(livroPostPutDto.getTitulo());
        livro.setAutor(obterAutorExistente(livroPostPutDto.getAutorId()));
        livro.setAno(livroPostPutDto.getAno());
        livro.setEdicao(livroPostPutDto.getEdicao());
        return converterParaResponse(livroRepository.save(livro));
    }

    @Override
    public void removerLivro(String isbn) {
        livroRepository.delete(obterLivroExistente(isbn));
    }

    // isbn inexistente = 404
    private Livro obterLivroExistente(String isbn) {
        return livroRepository.findById(isbn)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));
    }

    // id de autor inexistente = 404
    private Autor obterAutorExistente(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Autor não encontrado"));
    }

    // conversão manual, pois o DTO "achata" os dados do autor
    private LivroResponseDto converterParaResponse(Livro livro) {
        return LivroResponseDto.builder()
                .isbn(livro.getIsbn())
                .titulo(livro.getTitulo())
                .autorId(livro.getAutor().getId())
                .nomeAutor(livro.getAutor().getNomeAutor())
                .ano(livro.getAno())
                .edicao(livro.getEdicao())
                .build();
    }
}
