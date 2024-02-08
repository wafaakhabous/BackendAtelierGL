package com.hani.security;


import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;
    private AuthenticationManager manager;


    @PostMapping("/register")
    public void addNewUser(@RequestBody UserCredential user){
        authService.save(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody  AuthRequest user ){
       Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if(authentication.isAuthenticated())
          return authService.generateToken(user.getUserName());
        throw new RuntimeException("Veriy ur email and password");
    }
    @GetMapping("/validate")
    public Boolean validateToken(@RequestParam("token") String token){
         authService.validateToken(token);
         return true;
    }


}
