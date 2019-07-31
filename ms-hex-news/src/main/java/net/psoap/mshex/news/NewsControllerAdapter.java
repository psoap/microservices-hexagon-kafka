package net.psoap.mshex.news;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NewsControllerAdapter implements NewsControllerPort {
    private final NewsService newsService;

    @Override
    public ResponseEntity getAll() {
        return null;
    }

    @Override
    public ResponseEntity getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity create(@RequestBody News news) {
        return ResponseEntity.ok(newsService.create(news));
    }

    @Override
    public ResponseEntity delete(News news) {
        newsService.delete(news);
        return ResponseEntity.noContent().build();
    }
}
