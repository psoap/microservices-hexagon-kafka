package net.psoap.mshex.news;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class NewsKafkaConsumer {
    @Autowired
    private final NewsService newsService;

    @KafkaListener(topics = "${application.kafka.user-removed-topic}", groupId = "users")
    @Transactional
    public void removeNewsWhenUserRemoved(@Payload Long id){
        newsService.deleteByAuthorId(id);
    }
}
