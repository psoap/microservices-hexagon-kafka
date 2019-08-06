package net.psoap.mshex.news;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewsRepositoryAdapter extends NewsRepositoryPort, JpaRepository<News, Long> {
    <T extends News> T save(T user);

    Optional<News> findById(Long id);

    List<News> findAll();

    void delete(News news);

    void deleteById(Long id);

    @Override
    void deleteByAuthorId(Long id);
}