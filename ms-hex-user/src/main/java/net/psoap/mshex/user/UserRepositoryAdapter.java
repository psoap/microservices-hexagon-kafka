package net.psoap.mshex.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryAdapter extends UserRepositoryPort, JpaRepository<User, Long> {
    <T extends User> T save(T user);

    Optional<User> findById(Long id);

    Optional<User> findByLogin(String login);

    void delete(User user);

    void deleteById(Long id);
}