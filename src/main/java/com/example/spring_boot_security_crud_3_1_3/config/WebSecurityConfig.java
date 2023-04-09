package com.example.spring_boot_security_crud_3_1_3.config;


import com.example.spring_boot_security_crud_3_1_3.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserServiceImpl userService;

    @Autowired
    public WebSecurityConfig(UserServiceImpl userService) {
        this.userService = userService;
    }

    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
        //.successHandler(successUserHandler)

        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().formLogin();
//        http
//        .authorizeRequests()
//                //Доступ только для не зарегистрированных пользователей
//                .antMatchers("/").not().fullyAuthenticated()
//                //Доступ только для пользователей с ролью Администратор
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/user").hasRole("USER")
//                //Доступ разрешен всем пользователей
//                .antMatchers("/", "/resources/**").permitAll()
//                //Все остальные страницы требуют аутентификации
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .and()
//                .logout()
//                .permitAll()
//                .logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public DaoAuthenticationProvider provider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(getPasswordEncoder());
        provider.setUserDetailsService(userService);
        return provider;
    }
}
