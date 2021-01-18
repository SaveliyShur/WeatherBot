package com.example.botodnoklasniki.controllers;

import com.example.botodnoklasniki.User;
import com.example.botodnoklasniki.logic.HandlerForUserMessage;
import com.example.botodnoklasniki.messageForUser.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.botodnoklasniki.User.Gender.*;

@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    HandlerForUserMessage handlerForUserMessage;

    @GetMapping("/hello")
    public User serve(){
        return new User("Saveliy", "Schur", 21, MAN);
    }

    @PostMapping("/bothook")
    @ResponseBody
    public Response serveHook(@RequestBody Notification notification) {
        logger.info("Got the message " + notification);
        handlerForUserMessage.handleMessage(notification);
        return new Response(true);
    }
}
