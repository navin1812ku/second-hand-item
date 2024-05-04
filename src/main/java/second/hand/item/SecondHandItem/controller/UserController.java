package second.hand.item.SecondHandItem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import second.hand.item.SecondHandItem.jwt.MyUserDetailsService;
import second.hand.item.SecondHandItem.jwt.models.AuthenticationRequest;
import second.hand.item.SecondHandItem.jwt.models.AuthenticationResponse;
import second.hand.item.SecondHandItem.jwt.util.JwtUtil;
import second.hand.item.SecondHandItem.model.UserModel;
import second.hand.item.SecondHandItem.model.request.UserChangePasswordRequest;
import second.hand.item.SecondHandItem.model.request.UserLoginRequest;
import second.hand.item.SecondHandItem.model.response.Response;
import second.hand.item.SecondHandItem.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> userRegistration(@RequestBody UserModel userModel){
        return new ResponseEntity<Response>(userService.register(userModel), HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<Response> userLogin(@RequestBody UserLoginRequest userLoginRequest){
        return new ResponseEntity<Response>(userService.login(userLoginRequest),HttpStatus.ACCEPTED);
    }

    @PutMapping("/changePassword")
    public ResponseEntity<Response> userChangePassword(@RequestBody UserChangePasswordRequest userChangePasswordRequest){
        return new ResponseEntity<Response>(userService.changePassword(userChangePasswordRequest),HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
