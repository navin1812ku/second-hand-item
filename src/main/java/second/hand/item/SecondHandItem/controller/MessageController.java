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

    @PostMapping("/new_message/{e_mail}")
    ResponseEntity<Response> messageAdding(@PathVariable String e_mail, @RequestBody MessageCreationRequest messageCreationRequest){
        return new ResponseEntity<>(messageService.addMessage(e_mail,messageCreationRequest), HttpStatus.CREATED);
    }

    @GetMapping("/view_message/{e_mail}")
    ResponseEntity<List<MessageModel>> messageViewing(@PathVariable String e_mail){
        return new ResponseEntity<>(messageService.sendMessage(e_mail),HttpStatus.FOUND);
    }
}
