package net.psoap.mshex.user;

import java.util.Optional;

public interface UserRepositoryPort {
    <T extends User> T save(T user);
    Optional<User> findById(Long id);
    Optional<User> findByLogin(String login);
    void delete(User user);
    void deleteById(Long id);
}
