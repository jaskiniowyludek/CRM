package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Project;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import javax.validation.Validator;
import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    Validator validator;
    @Autowired
    UserRepository userRepository;

    @GetMapping("")
    public String showAall(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("user", new User());
        return "user/form";
    }

    @PostMapping("/add")
    public String addUser(@Valid User user, BindingResult result){
        if (result.hasErrors()) {
            return "user/form";
        }
        userRepository.save(user);
        return "redirect:/user";
    }

    @GetMapping("/deleteConfirm/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "/user/confirmDelete";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User user = userRepository.findOne(id);
        userRepository.delete(user);
        return "deleted";
    }


    @ModelAttribute("usersmodel")
    public List<User> modelUser(){
        return userRepository.findAll();
    }

}
