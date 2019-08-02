package net.psoap.mshex.user;

import org.springframework.http.ResponseEntity;

public interface UserControllerPort {
    ResponseEntity create(User user);

    ResponseEntity check(Long id);

    ResponseEntity delete(Long id);
}
