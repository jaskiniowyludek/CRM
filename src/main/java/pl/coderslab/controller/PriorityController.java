package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Priority;
import pl.coderslab.repository.PriorityRepository;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("priority")
public class PriorityController {

    @Autowired
    Validator validator;
    @Autowired
    PriorityRepository priorityRepository;

    @GetMapping("")
    public String showAall(Model model){
        model.addAttribute("priorities", priorityRepository.findAll());
        return "priority/list";
    }

    @GetMapping("/add")
    public String addPriority(Model model){
        model.addAttribute("priority", new Priority());
        return "priority/form";
    }

    @PostMapping("/add")
    public String addPriority(@Valid Priority priority, BindingResult result){
        if (result.hasErrors()) {
            return "priority/form";
        }
        priorityRepository.save(priority);
        return "redirect:/priority";
    }

    @GetMapping("/edit/{id}")
    public String editPriority(@PathVariable Long id, Model model) {
        Priority priority = priorityRepository.findOne(id);
        model.addAttribute("priority", priority);
        return "priority/form";
    }
    @PostMapping("/edit/{id}")
    public String editPriority( Model model, @ModelAttribute Priority priority){
        priorityRepository.save(priority);
        model.addAttribute("priority", priority);
        return "redirect:/priority";
    }

    @GetMapping("/deleteConfirm/{id}")
    public String deletePriority(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "/priority/confirmDelete";
    }
    @GetMapping("/delete/{id}")
    public String deletePriority(@PathVariable long id){
        Priority priority = priorityRepository.findOne(id);
        priorityRepository.delete(priority);
        return "/priority/deleted";
    }
}
