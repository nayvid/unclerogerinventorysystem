package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JWTTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	       try {
	    	   
	    	   //1. validate the credentials
	    	   Authentication authencation = authenticationManager.authenticate(
	    			   new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	    	   
	    	   //2. generate a jwt token if valid
	    	   //final keyword is used because we do not want to change the value after init
	    	   final UserDetails userDetails = (UserDetails) authencation.getPrincipal();
	    	   final String token = jwtTokenUtil.generateToken(userDetails);
	    	   
	    	   //3. return the token
	    	   return ResponseEntity.ok(
	    			   new JWTResponse(token)
	    			   );
	       }catch (BadCredentialsException e) {
	    	   	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
	        
	    	   	// This is a simplified example
			/*
			 * if ("user".equals(loginRequest.getUsername()) &&
			 * "password".equals(loginRequest.getPassword())) { return
			 * ResponseEntity.ok().body("{\"token\": \"dummy-jwt-token\"}"); } else { return
			 * ResponseEntity.status(HttpStatus.UNAUTHORIZED).
			 * body("{\"error\": \"Invalid credentials\"}"); }
			 */
	    }
	}
}
