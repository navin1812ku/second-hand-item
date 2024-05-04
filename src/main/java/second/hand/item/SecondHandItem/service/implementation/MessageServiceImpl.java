package second.hand.item.SecondHandItem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import second.hand.item.SecondHandItem.model.MessageModel;
import second.hand.item.SecondHandItem.model.request.MessageCreationRequest;
import second.hand.item.SecondHandItem.model.response.Response;
import second.hand.item.SecondHandItem.repository.MessageRepository;
import second.hand.item.SecondHandItem.service.MessageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Object addMessage(MessageCreationRequest messageCreationRequest) {
        MessageModel messageModel=new MessageModel();
        Response response=new Response();
        String id=ProductServiceImpl.generateUniqueId();
        messageModel.setMessageId(id);
        messageModel.setSender(messageCreationRequest.getSender());
        messageModel.setReceiver(messageCreationRequest.getReceiver());
        messageModel.setData(messageCreationRequest.getData());
        messageRepository.save(messageModel);
        if(messageRepository.findByMessageId(id)==null){
            response.setMessage("Something went wrong your message was not sent");
            return response;
        }
        else{
            response.setMessage("Message was successfully sent");
            List<Object> messageDetails=new ArrayList<>();
            messageDetails.add(response);
            messageDetails.add(messageRepository.findByMessageId(id));
            return messageDetails;
        }
    }

    @Override
    public List<MessageModel> sendMessage(String e_mail) {
        return messageRepository.findByReceiver(e_mail);
    }

    @Override
    public List<MessageModel> viewMessage(String e_mail) {
        return messageRepository.findBySender(e_mail);
    }
}
