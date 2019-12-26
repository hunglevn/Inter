package com.inter.webservice.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.inter.config.ConfigConstant;

/**
 * Username/password is pre-configure in application.properties file by following properties:
 * + preconfigure.username
 * + preconfigure.password
 * 
 * We can create another implementation of to check username/password by from Database.
 * 
 * @author Kevin
 *
 */
@Service
public class PreconfigureUserDetailsService implements UserDetailsService {
	@Value("${preconfigure.username}")
	private String preconfigureUsername;
	
	@Value("${preconfigure.password}")
	private String preconfigurePassword;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(!preconfigureUsername.equalsIgnoreCase(username)) {
			throw new UsernameNotFoundException(String.format("Cannot find user [%s]", username));
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		/**
		 * Need to add "ROLE_" prefix to role name.
		 */
		authorities.add(new SimpleGrantedAuthority("ROLE_" + ConfigConstant.ADMIN_ROLE_NAME));
		return new User(username, passwordEncoder.encode(preconfigurePassword), authorities);
	}

}
