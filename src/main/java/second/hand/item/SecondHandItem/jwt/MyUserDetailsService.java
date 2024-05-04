package second.hand.item.SecondHandItem.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import second.hand.item.SecondHandItem.model.UserModel;
import second.hand.item.SecondHandItem.repository.UserRepository;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel userModel=userRepository.findByEmail(s);
        return new User(userModel.getEmail(), userModel.getPassword(),
                new ArrayList<>());
    }
}