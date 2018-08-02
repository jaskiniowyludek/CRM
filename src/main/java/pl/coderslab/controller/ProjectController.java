package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.Task;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.TaskRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    Validator validator;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TaskRepository taskRepository;

    @GetMapping("")
    public String showAall(Model model){
        model.addAttribute("projects", projectRepository.findAll());
        return "project/list";
    }

    @GetMapping("/add")
    public String addProject(Model model){
        model.addAttribute("project", new Project());
        return "project/form";
    }

    @PostMapping("/add")
    public String addProject(@Valid Project project, BindingResult result){
        if (result.hasErrors()) {
            return "project/form";
        }
        project.setCreated(LocalDateTime.now());

        String idRegex = "[żźćńółęąśŻŹĆĄŚĘŁÓŃ]";
        String identifier = project.getName().trim().replaceAll(" ", "-")
                .toLowerCase().replaceAll(idRegex, "");
        project.setIdentifier(identifier);
        projectRepository.save(project);
        return "redirect:/project";
    }

    @GetMapping("/edit/{id}")
    public String editProject(@PathVariable Long id, Model model) {
        Project project = projectRepository.findById(id);
        model.addAttribute("project",project);
        return "project/form";
    }
    @PostMapping("/edit/{id}")
    public String editArticle( Model model, @ModelAttribute Project project){
        projectRepository.save(project);
        model.addAttribute("project", project);
        return "redirect:/project";
    }

    @GetMapping("/details/{id}")
    public String showDetails(@PathVariable Long id, Model model){
        Project project = projectRepository.findById(id);
        LocalDateTime created = project.getCreated();
        String formatedDate = created.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        model.addAttribute("projectDate", formatedDate);
        model.addAttribute("project", project);
        return "project/details";
    }

    @ModelAttribute("projects")
    public List<Project> modelProject(){
        return projectRepository.findAll();
    }
    @ModelAttribute("usersmodel")
    public List<User> modelUser(){
        return userRepository.findAll();
    }
    @ModelAttribute("tasks")
    public List<Task> modelTask(){
        return taskRepository.findAll();
    }
}
