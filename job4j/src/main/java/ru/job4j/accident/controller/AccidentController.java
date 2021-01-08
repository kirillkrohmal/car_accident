package ru.job4j.accident.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentRepository;

@Controller
@RequestMapping("/add-accident")
public class AccidentController {
    private final AccidentRepository accidents;

    @Autowired
    public AccidentController(AccidentRepository accidents) {
        this.accidents = accidents;
    }

    @GetMapping
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accident", new Accident());
        modelAndView.setViewName("accidentEdit");
        return modelAndView;
    }

    @PostMapping
    public String addAccident(@ModelAttribute("accident") Accident accident) {
        this.accidents.save(accident);
        return "redirect:/";
    }
}
