package net.psoap.mshex.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserControllerAdapter implements UserControllerPort {
    private final UserService userService;

    @PostMapping
    @Override
    public ResponseEntity create(@RequestBody User user) {
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity check(@PathVariable("id") Long id) {
        return userService.findById(id).isPresent()
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().body("User with id " + id + " not found");
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
