package com.idevalot.learnspringsecurity.basic;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthSecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated());
		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		http.httpBasic(withDefaults());
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	UserDetailsService userDetailService() {

		var user = User.withUsername("idevalot").password("{noop}dummy").roles("USER").build();

		var admin = User.withUsername("admin").password("{noop}dummy").roles("ADMIN").build();

		return new InMemoryUserDetailsManager(user, admin);
	}

}
