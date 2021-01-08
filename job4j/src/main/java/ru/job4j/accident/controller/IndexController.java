package ru.job4j.accident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    private final AccidentRepository accidents;

    @Autowired
    public IndexController(AccidentRepository accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> result = new ArrayList<>();
        accidents.findAll().forEach(result::add);
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accidents", result);
        return "index";
    }
}
