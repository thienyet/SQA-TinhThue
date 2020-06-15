package com.example.BTL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SpringBootApplication
@EnableWebSecurity
public class BtlApplication extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	private UserDetailsService userDetailsService;
	
	public static void main(String[] args) {
		SpringApplication.run(BtlApplication.class, args);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .antMatchers("/member/**").hasRole("MEMBER")
	                .antMatchers("/admin/**").hasRole("ADMIN")
	                .anyRequest().permitAll()
	                .and()
	            .formLogin()
	                .loginPage("/loginAdmin")
	                .usernameParameter("username")
	                .passwordParameter("password")
	                .defaultSuccessUrl("/admin/welcome")
	                .failureUrl("/loginAdmin?err=1")
	                .and()
	             .logout()
	             	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))            
	             	.logoutSuccessUrl("/loginAdmin")
	             	.permitAll()
	             	.and()
	            .exceptionHandling()
	                .accessDeniedPage("/access-denied");
	    }
	

}
