package com.learnSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		/*http.authorizeRequests()
			.antMatchers("/home","/login","/register").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();*/
		
/*		http.authorizeRequests()
		.antMatchers("/public/**").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();*/
		
/*		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/public/**").hasRole("NORMAL")
		.antMatchers("/users/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();*/
	// Cross site request forgery (CSRF), also known as XSRF, Sea Surf or Session Riding, is an attack vector that tricks a web browser into executing an unwanted action in an application to which a user is logged in
	// jo aapki http hai ispe call kiya authorizeRequest (Request ko authoriza karna hai) konse request ko anyRequest (koi bhi request ko), authenticate ho (matlab jo bhi persmission access karne hai wo pehle authenticated hongi) or ham jo mechanism use karnege wo httpBasic karenge
	// antmatcher me jo url unke alawa authentication sabhi url ke liye chahiye	
	// jitne bhi /public se start hone wale URL hai usse NORMAL use kar paye or jitne bhi /users se start hone wale URL hai usse ADMIN use kar payega
	// Hamara jo spring security hai CSRF token bhej deta hai client ko or hame kya karna hota hai ki agar ham wahi client hai jisko aapne ye token bheja hai uss token ko aapko as a request phir se wapas bhejna hota hai

		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/signin").permitAll()
		.antMatchers("/public/**").hasRole("NORMAL")
		.antMatchers("/users/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin().loginPage("/signin") // ab jo login hoga wo /signin se hoga
		.loginProcessingUrl("/dologin") //Specifies the URL to validate the credentials.
		.defaultSuccessUrl("/users/") //Specifies where users will be redirected after authenticating successfully if theyhave not visited a secured page prior to authenticating. This is a shortcut forcalling
		;  
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("anubhav").password(this.passwordEncoder().encode("anurobo")).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("anurobo").password(this.passwordEncoder().encode("anusingh")).roles("ADMIN");
		/*
		 * If we want to add a custom user name and password in the Spring application for authentication we can add it easily(using application.properties ) but if we want to make our Spring application for multiple users it is difficult to configure their credentials. 
		 * So to overcome this situation when we handle multiple authentications along with their respective roles. We will use in-memory authentication in the Spring Application.
		 * We can perform validation until the Spring server is running. If the server is stopped the memory is cleared out and we cannot perform validation. This is the main drawback of in-memory authentication.
		 * inMemoryAuthentication() is the method of AuthenticationManagerBuilder class is used to perform in-memory authentication in the Spring Security.
		 * This method is used for creating the user with respective roles and passwords.
		 * */
	}
	
	// ROLE - High level Overview->NORMAL :READ
	// Authority - permission->READ
	// ADMIN- READ,WRITE,UPDATE
	@Bean
	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
		// paswrod hamlog direct nahi rakh sakte isko encode karke use karenge
	}
}
