package second.hand.item.SecondHandItem.service;

import org.springframework.stereotype.Service;
import second.hand.item.SecondHandItem.model.MessageModel;
import second.hand.item.SecondHandItem.model.request.MessageCreationRequest;
import second.hand.item.SecondHandItem.model.response.Response;

import java.util.List;

public interface MessageService {
    Response addMessage(MessageCreationRequest messageCreationRequest);
    List<MessageModel> sendMessage(String e_mail);
    List<MessageModel> viewMessage(String e_mail);
}
