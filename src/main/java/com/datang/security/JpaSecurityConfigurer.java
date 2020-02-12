package com.datang.security;

import com.datang.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class JpaSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("JpaSecurityConfigurer HttpSecurity 调用...");
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/", "/home").hasRole("ROCKET")
                .antMatchers("/admin/**").hasAnyRole("LAKER", "HEAT")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .successHandler(new MyAuthenticationSuccessHandler())
                .usernameParameter("username").passwordParameter("password")
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(playerService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}
