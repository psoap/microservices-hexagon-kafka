package net.psoap.mshex.news;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepositoryPort newsRepository;

    @Override
    public News create(News news) {
        return newsRepository.save(news);
    }

    @Override
    public Optional<News> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public void delete(News news) {
        newsRepository.delete(news);
    }
}
