package org.chinacalcweb.webgui.controllers;

import org.chinacalcweb.webgui.models.ChinacalcUser;
import org.chinacalcweb.webgui.models.Role;
import org.chinacalcweb.webgui.repos.UserRepository;
import org.chinacalcweb.webgui.util.PassGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path="/api/v1/chinacalc_user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name,
    @RequestParam String email,
    @RequestParam String login,
    @RequestParam(defaultValue="USER") Role role) {

        ChinacalcUser n = new ChinacalcUser();
        n.setName(name);
        n.setEmail(email);
        n.setLogin(login);
        n.setRole(role);
        n.setPassword(PassGen.generatePassayPassword());
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ChinacalcUser> getAllUsers() {
        return userRepository.findAll();
    }
}
