package second.hand.item.SecondHandItem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import second.hand.item.SecondHandItem.model.MessageModel;
import second.hand.item.SecondHandItem.model.request.MessageCreationRequest;
import second.hand.item.SecondHandItem.model.response.Response;
import second.hand.item.SecondHandItem.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/newMessage")
    ResponseEntity<Response> messageAdding(@RequestBody MessageCreationRequest messageCreationRequest){
        return new ResponseEntity<>(messageService.addMessage(messageCreationRequest), HttpStatus.CREATED);
    }

    @GetMapping("/viewReceiverMessage/{e_mail}")
    ResponseEntity<List<MessageModel>> receiverMessageViewing(@PathVariable String e_mail){
        return new ResponseEntity<>(messageService.sendMessage(e_mail),HttpStatus.FOUND);
    }

    @GetMapping("/viewSenderMessage/{e_mail}")
    ResponseEntity<List<MessageModel>> senderMessageViewing(@PathVariable String e_mail){
        return new ResponseEntity<>(messageService.viewMessage(e_mail),HttpStatus.FOUND);
    }
}
