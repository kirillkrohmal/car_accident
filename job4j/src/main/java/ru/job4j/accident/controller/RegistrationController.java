package ru.job4j.accident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accident.model.User;
import ru.job4j.accident.repository.UserRepository;

@Controller
public class RegistrationController {
    private final PasswordEncoder encoder;
    private final UserRepository users;

    @Autowired
    public RegistrationController(PasswordEncoder encoder, UserRepository users) {
        this.encoder = encoder;
        this.users = users;
    }

    @RequestMapping(value = "/reg", method = RequestMethod.GET)
    public String regPage() {
        return "registration";
    }

    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public String reg(@ModelAttribute User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnabled(true);
        users.save(user);
        return "login";
    }
}
