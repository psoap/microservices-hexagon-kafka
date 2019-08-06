package net.psoap.mshex.news;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    News create(News news);

    Optional<News> findById(Long id);

    List<News> findAll();

    void delete(Long id);

    void deleteByAuthorId(Long id);
}
