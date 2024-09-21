package controller;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
	UserDetails loadUserByusername(String username);

}
