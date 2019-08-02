package net.psoap.mshex.news;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final NewsRepositoryPort newsRepository;
    private final String TOPIC = "user-id-resp-topic";
    private final String rest = "http://localhost:9075/exist-check/";

    private RestTemplate restTemplate;

    @PostMapping("create")
    @Override
    public News create(News news) {
        restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.getForEntity(rest + news.getAuthorId(), String.class);

        return response.getStatusCode().equals(HttpStatus.OK) ? newsRepository.save(news) : null;
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
}
