package second.hand.item.SecondHandItem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class MessageModel {
    @Id
    private String messageId;
    private String receiverMail;
    private String sender;
    private String receiver;
    private String data;
}
