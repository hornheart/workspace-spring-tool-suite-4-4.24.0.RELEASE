package com.itwill.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		
		/*		httpSecurity.authorizeHttpRequests( (auth) -> auth.requestMatchers("/index","/","/authentication","/securityContext")
														  .permitAll()
													      .anyRequest().authenticated());*/
	
		/*
		httpSecurity.authorizeHttpRequests(	new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
			
			@Override
			public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry auth) {
				   auth.requestMatchers("/index","/","/authentication","/securityContext")
				  .permitAll()
			      .anyRequest().authenticated();
				
			}
		});*/
		httpSecurity.authorizeHttpRequests((auth)->{
			  auth.requestMatchers("/index","/","/authentication","/securityContext")
			  .permitAll()
		      .anyRequest().authenticated();
		});
		httpSecurity.sessionManagement((session)->{
			session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		});
		
		httpSecurity.formLogin((form)->form.loginPage("/login-form")
								.loginProcessingUrl("/login")
								.defaultSuccessUrl("/", true)
								.failureUrl("/login-form")
								.usernameParameter("username")
								.passwordParameter("password")
								.permitAll());
		httpSecurity.logout((logout)->logout.logoutUrl("/logout")
								.logoutSuccessUrl("/"));
		httpSecurity.exceptionHandling((exception)-> exception.accessDeniedPage("/access-denied"));
		return httpSecurity.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User.withUsername("user1").password(passwordEncoder().encode("1111")).roles("USER").build();
		UserDetails user2 = User.withUsername("user2").password(passwordEncoder().encode("2222")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user1, user2, admin);
	}
	/*
	@Bean
	public RoleHierarchy  roleHierarchy() {
		RoleHierarchyImpl roleHierarchyImpl=new RoleHierarchyImpl();
		roleHierarchyImpl.setHierarchy("ROLE_ADMIN > ROLE_USER");
		return roleHierarchyImpl;
	}
	*/
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (t) -> {
			t.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		};
	}
	
}