package rad.shopapp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rad.shopapp.Jwt.JwtUtil;
import rad.shopapp.Models.AuthenticationRequest;
import rad.shopapp.Models.AuthenticationResponse;
import rad.shopapp.Models.CustomUserDetails;
import rad.shopapp.Models.User;
import rad.shopapp.Repositories.UserRepository;
import rad.shopapp.Services.CustomUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String Hi(HttpServletRequest httpRequest){
        final String authorizationHeader = httpRequest.getHeader("Authorization");
        String jwt = null;
        String email = null;
        if(authorizationHeader!=null){
            jwt = authorizationHeader;
            email = jwtTokenUtil.extractEmail(jwt);
        }
        User user = userRepository.findByEmail(email);
        return "Hi " + user.getFirstName() + " " + user.getLastName();
    }
    @RequestMapping(value = "/hi/user", method = RequestMethod.GET)
    public String HiUser(){
        return "Hi user";
    }
    @RequestMapping(value = "/hi/hi")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/hi/admin", method = RequestMethod.GET)
    public String HiAdmin(){
        return "Hi admin";
    }



    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                    authenticationRequest.getPassword()));

        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailsService
                .loadUserByUsername(authenticationRequest.getEmail());

        final String jwt = jwtTokenUtil.generateToken(customUserDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
