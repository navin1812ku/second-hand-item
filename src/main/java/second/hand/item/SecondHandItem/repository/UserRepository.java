package second.hand.item.SecondHandItem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import second.hand.item.SecondHandItem.model.UserModel;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String> {
    UserModel findByEmail(String e_mail);
}
