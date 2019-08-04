package net.psoap.mshex.news;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbInitializer implements CommandLineRunner {
    private final NewsRepositoryPort newsRepository;

    @Override
    public void run(String... args) throws Exception {
        News news1 = new News(null, "news1", "description1", LocalDateTime.now(), 1L);
        News news2 = new News(null, "news2", "description2", LocalDateTime.now(), 1L);
        News news3 = new News(null, "news3", "description3", LocalDateTime.now(), 1L);
        News news4 = new News(null, "news4", "description4", LocalDateTime.now(), 1L);
        News news5 = new News(null, "news5", "description5", LocalDateTime.now(), 1L);
        News news6 = new News(null, "news6", "description6", LocalDateTime.now(), 1L);
        News news7 = new News(null, "news7", "description7", LocalDateTime.now(), 1L);

        newsRepository.save(news1);
        newsRepository.save(news2);
        newsRepository.save(news3);
        newsRepository.save(news4);
        newsRepository.save(news5);
        newsRepository.save(news6);
        newsRepository.save(news7);

        log.info("News-db has initialized");
    }
}
