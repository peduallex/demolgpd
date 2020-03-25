package br.com.rmn.demo.lgpd.demolgpd.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rmn.demo.lgpd.demolgpd.model.User;
import br.com.rmn.demo.lgpd.demolgpd.service.UserService;

/**
 * UserController
 */
@RequestMapping("api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public List<User> listAllUsers() {
        return userService.listAllUser();
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

}