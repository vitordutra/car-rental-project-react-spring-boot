package com.dh.projetointegradorv1._equipe4.dh_carshop.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig<MyUserDetailsService, JwtRequestFilter> extends WebSecurityConfigurerAdapter {

    @Autowired
    private com.dh.projetointegradorv1._equipe4.dh_carshop.service.MyUserDetailsService myUserDetailsService;

    @Autowired
    private com.dh.projetointegradorv1._equipe4.dh_carshop.security.JwtRequestFilter jwtRequestFilter;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/bookings/**").permitAll()
                .antMatchers("/categories/**").permitAll()
                .antMatchers("/cities/**").permitAll()
                .antMatchers("/features/**").permitAll()
                .antMatchers("/products/**").permitAll()
                .antMatchers("/roles/**").permitAll()
                .antMatchers("/users/**").permitAll()
                .antMatchers("/authenticate/**").permitAll()
                .anyRequest()
                .authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }





    //@Bean
    //CorsConfigurationSource corsConfigurationSource() {
       // org.springframework.web.cors.CorsConfiguration configuration = new org.springframework.web.cors.CorsConfiguration().applyPermitDefaultValues();
        //configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        //final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //source.registerCorsConfiguration("/**", configuration);
        //return source;
    //}
}
