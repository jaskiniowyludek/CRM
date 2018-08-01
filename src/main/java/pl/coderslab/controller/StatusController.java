package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.Status;
import pl.coderslab.repository.StatusRepository;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("status")
public class StatusController {

    @Autowired
    Validator validator;
    @Autowired
    StatusRepository statusRepository;

    @GetMapping("")
    public String showAall(Model model){
        model.addAttribute("statuses", statusRepository.findAll());
        return "status/list";
    }

    @GetMapping("/add")
    public String addStatus(Model model){
        model.addAttribute("status", new Status());
        return "status/form";
    }

    @PostMapping("/add")
    public String addStatus(@Valid Status status, BindingResult result){
        if (result.hasErrors()) {
            return "status/form";
        }
        statusRepository.save(status);
        return "redirect:/status";
    }

    @GetMapping("/edit/{id}")
    public String editStatus(@PathVariable Long id, Model model) {
        Status status = statusRepository.findOne(id);
        model.addAttribute("status", status);
        return "status/form";
    }
    @PostMapping("/edit/{id}")
    public String editStatus( Model model, @ModelAttribute Status status){
        statusRepository.save(status);
        model.addAttribute("status", status);
        return "redirect:/status";
    }

    @GetMapping("/deleteConfirm/{id}")
    public String deleteStatus(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "/status/confirmDelete";
    }
    @GetMapping("/delete/{id}")
    public String deleteStatus(@PathVariable long id){
        Status status = statusRepository.findOne(id);
        statusRepository.delete(status);
        return "/status/deleted";
    }
}
