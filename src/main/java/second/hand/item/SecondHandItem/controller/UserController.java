package second.hand.item.SecondHandItem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import second.hand.item.SecondHandItem.model.UserModel;
import second.hand.item.SecondHandItem.model.request.UserChangePasswordRequest;
import second.hand.item.SecondHandItem.model.request.UserLoginRequest;
import second.hand.item.SecondHandItem.model.response.Response;
import second.hand.item.SecondHandItem.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

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
}
