package dio.web.api.controller;

import dio.web.api.model.User;
import dio.web.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/users/{username}")
    public User getOne(@PathVariable("username") String username){
        return userRepository.findByUsername(username);
    }
    @DeleteMapping("users/{id}")
    public void delete(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }
    @PostMapping("/users")
    public void postUser(@RequestBody User user){
        userRepository.save(user);
    }

    @PutMapping
    public void putUser(@RequestBody User user){
        userRepository.save(user);
    }
}
