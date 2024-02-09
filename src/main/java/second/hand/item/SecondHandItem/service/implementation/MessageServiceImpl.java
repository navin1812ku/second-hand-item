package second.hand.item.SecondHandItem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import second.hand.item.SecondHandItem.model.MessageModel;
import second.hand.item.SecondHandItem.model.request.MessageCreationRequest;
import second.hand.item.SecondHandItem.model.response.Response;
import second.hand.item.SecondHandItem.repository.MessageRepository;
import second.hand.item.SecondHandItem.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Response addMessage(String e_mail,MessageCreationRequest messageCreationRequest) {
        MessageModel messageModel=new MessageModel();
        Response response=new Response();
        String id=ProductServiceImpl.generateUniqueId();
        messageModel.setMessageId(id);
        messageModel.setReceiverMail(e_mail);
        messageModel.setSender(messageCreationRequest.getSender());
        messageModel.setReceiver(messageCreationRequest.getReceiver());
        messageModel.setData(messageCreationRequest.getData());
        if(messageRepository.findByMessageId(id).equals(null)){
            response.setMessage("Something went wrong your message was not sent");
        }
        else{
            response.setMessage("Message was successfully sent");
        }
        return response;
    }

    @Override
    public List<MessageModel> sendMessage(String e_mail) {
        return messageRepository.findByReceiverMail(e_mail);
    }
}
