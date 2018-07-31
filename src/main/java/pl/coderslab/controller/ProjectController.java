package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.repository.ProjectRepository;

import javax.validation.Validator;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    Validator validator;
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("")
    public String showAall(Model model){
        model.addAttribute("projects", projectRepository.findAll());
        return "project/list";
    }

//    @GetMapping("/edit/{id}")
//    public String editProject() DOKOŃCZ!!
}
