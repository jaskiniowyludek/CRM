package pl.coderslab.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.ActivityRepository;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class HomepageController {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(value = "requested", required = false) String requestedURL){
        if (requestedURL != null) {
            model.addAttribute("requested", requestedURL);
        }
        return "user/login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User userInBase = userRepository.findByLogin(login);
        if (userInBase!=null) {
           if (BCrypt.checkpw(password, userInBase.getPassword())) {
               HttpSession session = request.getSession();
               session.setAttribute("user", userInBase);
               String requested = request.getParameter("requested");
               if (requested != null) {
                   try {
                       response.sendRedirect(requested);
                   } catch (IOException ioe) {
                       ioe.printStackTrace();
                   }
               }
               return "redirect:/homepage";
           }
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "user/logout";
    }

    @GetMapping("/homepage")
    public String HomePage(Model model){

       model.addAttribute("projects", projectRepository.findFirst5ByOrderByCreatedDesc());
       // model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("activities", activityRepository.findAll());
        return "homepage";
    }


}


//Strona	główna
//Strona	ta	ma	wyświetlać	ostatnio	utworzone	projekty	od	najnowszego	do	najstarszego.
//Limit	projektów	na	stronie	głównej	to	5.
//Strona	ta	ma	wyświetlać	listę	ostatnich	aktywności	użytkowników	systemu	od	najnowszej	do
//najstarszej.
//Limit	na	stronie	głównej	to	25.
//Zastanów	się	i	samodzielnie	opracuj	sposób	na	przechowywanie	danych	o	aktywnościach	-	informacja
//ta	nie	jest	sprecyzowana.
//-----------------------------------------------------------------------------------------
//Strona	główna
//Operacje,	które	mają	się	pojawiać	na	liście	aktywności,	to:
//utworzenie	projektu	-	informacja	kto	i	kiedy	to	zrobił
//dodanie	zadania	do	projektu	-	informacja	kto	i	kiedy	to	zrobił	oraz	do	jakiego	projektu,
//dodatkowo	powinien	się	pojawić	link	do	szczegółów	danego	zagadnienia.
//zmiana	statusu	zadania	-	informacja	kto	i	kiedy	to	zrobił	oraz	z	jakiego	projektu	pochodziło
//zadanie,	dodatkowo	powinien	się	pojawić	link	do	szczegółów	danego	zagadnienia.