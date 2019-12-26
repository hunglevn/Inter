package com.inter.webservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.inter.config.ConfigConstant;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan("com.inter.webservice.security")
public class APISecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationFailedHandler accessDeniedHandler;

	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private AuthenticationSuccessHandler successHandler;

	private SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("kevin").password(encoder().encode(
	 * "123456")).roles("ADMIN"); }
	 */

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
				.authenticationEntryPoint(restAuthenticationEntryPoint).and().authorizeRequests().antMatchers("/")
				.permitAll().antMatchers("/api/feedback/**").permitAll()
				.antMatchers("/api/admin/**").hasRole(ConfigConstant.ADMIN_ROLE_NAME).and().formLogin().successHandler(successHandler)
				.failureHandler(failureHandler).and().httpBasic().and().logout();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return userDetailsService;
	}

}
