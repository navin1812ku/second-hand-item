package second.hand.item.SecondHandItem.service;

import org.springframework.stereotype.Service;
import second.hand.item.SecondHandItem.model.UserModel;
import second.hand.item.SecondHandItem.model.request.UserChangePasswordRequest;
import second.hand.item.SecondHandItem.model.request.UserLoginRequest;
import second.hand.item.SecondHandItem.model.response.Response;

public interface UserService {
    Response register(UserModel userModel);
    Response login(UserLoginRequest userLoginRequest);
    Response changePassword(UserChangePasswordRequest userChangePasswordRequest);
}
