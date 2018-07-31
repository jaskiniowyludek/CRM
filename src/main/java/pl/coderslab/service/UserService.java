package pl.coderslab.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user){

        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);

    }

    public boolean checkLogin(String login, String password) {
        User user = userRepository.findByLogin(login);
        if(user != null) {
            return BCrypt.checkpw(password, user.getPassword());
        }
        return false;
    }
}
