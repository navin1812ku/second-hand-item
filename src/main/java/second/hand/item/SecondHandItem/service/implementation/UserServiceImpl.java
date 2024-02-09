package second.hand.item.SecondHandItem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import second.hand.item.SecondHandItem.model.UserModel;
import second.hand.item.SecondHandItem.model.request.UserChangePasswordRequest;
import second.hand.item.SecondHandItem.model.response.Response;
import second.hand.item.SecondHandItem.repository.UserRepository;
import second.hand.item.SecondHandItem.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Response register(UserModel userModel) {
        UserModel model=userRepository.findByEmail(userModel.getEmail());
        Response response=new Response();
        if(model==null){
            System.out.println(userModel.getEmail());
            System.out.println(userModel.getFirstName());
            System.out.println(userModel.getLastName());
            System.out.println(userModel.getPassword());
            System.out.println(userModel.getPhoneNumber());
            UserModel userModel1=new UserModel();
            userModel1.setEmail(userModel.getEmail());
            userModel1.setFirstName(userModel.getFirstName());
            userModel1.setLastName(userModel.getLastName());
            userModel1.setPassword(userModel.getPassword());
            userModel1.setPhoneNumber(userModel.getPhoneNumber());
            userRepository.save(userModel1);
            response.setMessage("Register successfully");
        }
        else{
            response.setMessage("This E-mail ID already exists");
        }
        return response;
    }

    @Override
    public Response login(String e_mail,String password) {
        UserModel model=userRepository.findByEmail(e_mail);
        Response response=new Response();
        if(model.equals(null)){
            response.setMessage("This Mail Id does not exists");
        }
        else{
            if(model.getPassword().equals(password)){
                response.setMessage("Login successful");
            }
            else {
                response.setMessage("Entered password is wrong");
            }
        }
        return response;
    }

    @Override
    public Response changePassword(UserChangePasswordRequest userChangePasswordRequest) {
        UserModel model=userRepository.findByEmail(userChangePasswordRequest.getE_mail());
        Response response=new Response();
        if(model.equals(null)){
            response.setMessage("This Mail Id does not exists");
        }
        else{
            model.setPassword(userChangePasswordRequest.getNew_password());
            userRepository.save(model);
            response.setMessage("Your password have been changed");
        }
        return response;
    }
}
