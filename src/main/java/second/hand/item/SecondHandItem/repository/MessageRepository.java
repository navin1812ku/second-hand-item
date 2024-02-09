package second.hand.item.SecondHandItem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import second.hand.item.SecondHandItem.model.MessageModel;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<MessageModel,String> {
    List<MessageModel> findByReceiverMail(String e_mail);
    MessageModel findByMessageId(String id);
}
