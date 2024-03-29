package net.psoap.mshex.user;

import java.util.Optional;

public interface UserService {
    User create(User user);

    Optional<User> findByLogin(String login);

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
