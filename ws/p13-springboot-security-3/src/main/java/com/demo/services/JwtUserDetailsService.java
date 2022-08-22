package com.demo.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// find user from database where user = :username
// userRepo.findByUsername(username);// username, password, roles

//		if ("demo".equals(username)) {
////			return new User("demo", "{noop}demo@123", new ArrayList<>());
////			return new User("demo", "{bcrypt}$2a$10$I.9/VzJtdX1IcPPHLT0eY.SW6MM4vTBj62tjmZhGKtLDeHy2/kVdW", new ArrayList<>());
//			return new User("demo", "$2a$10$I.9/VzJtdX1IcPPHLT0eY.SW6MM4vTBj62tjmZhGKtLDeHy2/kVdW", new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
		
		if("admin".equals(username)) {
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "MANAGER"));
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "OWNER"));

	        // admin@123
			return new User("admin", "$2a$10$LDGykhnV1z17POVHjZT3jeN5OZbIzGteHhy5G7TGK6uBZrR3bhtNm", authorities);
		} else if("manager".equals(username)) {
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "MANAGER"));
	        
	        // manager@123
			return new User("manager", "$2a$10$3M/Nfla1YJP9F95WPxxAH.f7388gAFGfhInLhbK9s0Wn6okhKPJd.", authorities);
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
