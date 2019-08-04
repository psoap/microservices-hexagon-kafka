package net.psoap.mshex.news;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RestControllerAdvice
@RequestMapping("news")
@RequiredArgsConstructor
public class NewsControllerAdapter implements NewsControllerPort {
    private final NewsService newsService;

    @GetMapping
    @Override
    public ResponseEntity getAll() {
        return ResponseEntity.ok(newsService.findAll());
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(newsService.findById(id));
    }

    @PostMapping
    @Override
    public ResponseEntity create(@RequestBody News news) {
        return ResponseEntity.ok(newsService.create(news));
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity delete(@PathVariable("id") Long id) {
        newsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<String> handleBadRequest(HttpClientErrorException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
