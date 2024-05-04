package second.hand.item.SecondHandItem.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
@Data
public class MessageModel {
    @Id
    @Column(nullable = false)
    private String messageId;
    @Column(nullable = false)
    private String sender;
    @Column(nullable = false)
    private String receiver;
    @Column(nullable = false)
    private String data;
}
