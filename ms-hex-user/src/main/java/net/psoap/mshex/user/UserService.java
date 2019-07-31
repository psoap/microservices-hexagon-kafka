package net.psoap.mshex.user;

import java.util.Optional;

public interface UserService {
    User create(User user);

    Optional<User> findByLogin(String login);

    void delete(User user);
}
