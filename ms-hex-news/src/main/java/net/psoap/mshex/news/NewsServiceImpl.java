package net.psoap.mshex.news;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepositoryPort newsRepository;
    private final String TOPIC = "user-id-resp-topic";
    private final String rest = "http://localhost:9075/user/";

    private RestTemplate restTemplate;

    @PostConstruct
    private void init(){
        restTemplate = new RestTemplate();
    }

    @Override
    public News create(News news) {
        restTemplate.getForEntity(rest + news.getAuthorId(), String.class);
        news.setDate(LocalDateTime.now());
        return newsRepository.save(news);
    }

    @Override
    public Optional<News> findById(Long id) {
        return newsRepository.findById(id);
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public void deleteByAuthorId(Long id) {
        newsRepository.deleteByAuthorId(id);
    }
}
