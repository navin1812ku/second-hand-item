package second.hand.item.SecondHandItem.model.request;

import lombok.Data;

@Data
public class MessageCreationRequest {
    private String sender;
    private String receiver;
    private String data;
}
