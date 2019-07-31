package net.psoap.mshex.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserControllerAdapter implements UserControllerPort {
    private final UserService userService;

    @Override
    public ResponseEntity create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @Override
    public ResponseEntity delete(User user) {
        userService.delete(user);
        return ResponseEntity.noContent().build();
    }
}
