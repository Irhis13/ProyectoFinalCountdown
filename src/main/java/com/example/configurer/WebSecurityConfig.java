package com.example.configurer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Autowired
    private LoginSuccessMessage successMessage;

  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
          //Aquí van las urls que pueden ser accedidas sin restricciones
        http.authorizeRequests().antMatchers("/home","/","/css/**","/js/**","/templates/**").permitAll()
        // Aquí las que si van a tener restricciones
        .antMatchers("/formularioEmpleado/").hasAnyRole("ADMIN")
        .antMatchers("/formularioCliente/").hasAnyRole("USER")
        .anyRequest().authenticated()
        .and()
        .formLogin()
            .successHandler(successMessage)
            .loginPage("/login")
        .permitAll()
        .and()
        .logout().permitAll(); 

    }

    @Autowired
    public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception {

        builder.jdbcAuthentication()
        .dataSource(dataSource)
        .passwordEncoder(passEncoder)
        .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
        .authoritiesByUsernameQuery("SELECT u.username, r.rol FROM roles r INNER JOIN users u ON r.user_id=u.id WHERE u.username=?");
    }
}