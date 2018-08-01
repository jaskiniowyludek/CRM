package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    PriorityRepository priorityRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String showAall(Model model){
        model.addAttribute("tasks", taskRepository.findAll());
        return "task/list";
    }

    @GetMapping("/add")
    public String addTask(Model model){
        model.addAttribute("task", new Task());
        return "task/form";
    }

    @PostMapping("/add")
    public String addTask(@Valid Task task, BindingResult result){
        if (result.hasErrors()) {
            return "task/form";
        }
        task.setCreated(LocalDateTime.now());
        taskRepository.save(task);
        return "redirect:/task";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskRepository.findOne(id);
        model.addAttribute("task", task);
        return "task/form";
    }
    @PostMapping("/edit/{id}")
    public String editTask( Model model, @ModelAttribute Task task){
        taskRepository.save(task);
        model.addAttribute("task", task);
        return "redirect:/task";
    }

    @GetMapping("/details/{id}")
    public String showTask(@PathVariable Long id, Model model){
        Task task = taskRepository.findOne(id);
        model.addAttribute("task", task);
        return "task/details";
    }

    @ModelAttribute("projects")
    public List<Project> modelProject(){
        return projectRepository.findAll();
    }
    @ModelAttribute("users")
    public List<User> modelUser(){
        return userRepository.findAll();
    }
    @ModelAttribute("priorities")
    public List<Priority> modelPriority(){
        return priorityRepository.findAll();
    }
    @ModelAttribute("statuses")
    public List<Status> modelStatus(){
        return statusRepository.findAll();
    }
}
