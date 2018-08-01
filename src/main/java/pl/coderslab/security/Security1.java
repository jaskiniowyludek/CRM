package pl.coderslab.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class Security1 //extends WebSecurityConfigurerAdapter
 {

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.inMemoryAuthentication()
//                 .withUser("user1").password("qwerty").roles("USER")
//                 .and()
//                 .withUser("user2").password("qwerty").roles("ADMIN");
//     }
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                    .regexMatchers("/sample.*").hasRole("USER")
//                    .regexMatchers("/jpa.*").hasRole("ADMIN")
//                    .anyRequest().permitAll()
//                    .and()
//                    .httpBasic().and().formLogin().loginPage("/login").usernameParameter("login<-nazwa "name" naszego pola w formularzu")
//                      .passwordParameter();
//            ;
//        }
}
