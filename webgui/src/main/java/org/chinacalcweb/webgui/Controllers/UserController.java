package org.chinacalcweb.webgui.Controllers;

import org.chinacalcweb.webgui.Models.User;
import org.chinacalcweb.webgui.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name) {

        User n = new User();
        n.setName(name);
        n.setRole("USER");
        userRepository.save(n);
        return String.format("New user %s added", name);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}