package net.psoap.mshex.user;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Optionals;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
@RequiredArgsConstructor
public class UserKafkaControllerAdapter implements UserKafkaControllerPort {

    private final UserService userService;

    private final KafkaTemplate<Long, Object> kafkaTemplate;
    private String topic = "user-id-resp-topic";

    @GetMapping("{id}")
    @Override
    public void id(@PathVariable("id") Long id) {
        Optionals
                .ifPresentOrElse(
                        userService.findById(id),
                        u -> kafkaTemplate.send(topic, true),
                        () -> kafkaTemplate.send(topic, false)
                );
    }

    @Override
    public void login(Long id) {

    }
}
