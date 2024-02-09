package second.hand.item.SecondHandItem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import second.hand.item.SecondHandItem.model.MessageModel;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<MessageModel,String> {
    List<MessageModel> findByReceiverMail(String e_mail);
    MessageModel findByMessageId(String id);
}
