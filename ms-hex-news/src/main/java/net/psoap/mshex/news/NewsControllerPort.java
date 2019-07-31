package net.psoap.mshex.news;

import org.springframework.http.ResponseEntity;

public interface NewsControllerPort {
    ResponseEntity getAll();

    ResponseEntity getById(Long id);

    ResponseEntity create(News News);

    ResponseEntity delete(News News);
}
