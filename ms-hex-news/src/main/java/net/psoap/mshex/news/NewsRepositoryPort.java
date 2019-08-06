package net.psoap.mshex.news;

import java.util.List;
import java.util.Optional;

public interface NewsRepositoryPort {
    <T extends News> T save(T user);
    Optional<News> findById(Long id);
    List<News> findAll();
    void delete(News user);
    void deleteById(Long id);
    void deleteByAuthorId(Long id);
}
