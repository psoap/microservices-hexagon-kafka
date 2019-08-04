package net.psoap.mshex.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbInitializer implements CommandLineRunner {
    private final UserRepositoryPort userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "user1", "password1");
        User user2 = new User(null, "user2", "password2");
        User user3 = new User(null, "user3", "password3");
        User user4 = new User(null, "user4", "password4");
        User user5 = new User(null, "user5", "password5");
        User user6 = new User(null, "user6", "password6");
        User user7 = new User(null, "user7", "password7");

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);

        log.info("Users-db has initialized");
    }
}
