package second.hand.item.SecondHandItem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import second.hand.item.SecondHandItem.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,String> {
    UserModel findByEmail(String e_mail);
}
