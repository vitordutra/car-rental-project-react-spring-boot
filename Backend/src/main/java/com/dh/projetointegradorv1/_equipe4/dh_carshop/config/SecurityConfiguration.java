package com.dh.projetointegradorv1._equipe4.dh_carshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/product/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/product/**").permitAll()
                .antMatchers(HttpMethod.GET, "/category/**").permitAll()
                .antMatchers(HttpMethod.GET, "/city/**").permitAll()
                .antMatchers(HttpMethod.GET, "/reservation/**").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/reservation/**").permitAll()
                .antMatchers(HttpMethod.GET, "/characteristic/**").permitAll()
                .antMatchers("/role/**").permitAll()
                .antMatchers("/authenticate/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers(HttpMethod.POST, "/product/**").hasAuthority("admin")
                .anyRequest()
                .authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }


}
