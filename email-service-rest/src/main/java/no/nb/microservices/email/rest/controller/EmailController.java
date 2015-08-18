package no.nb.microservices.email.rest.controller;

import no.nb.microservices.email.model.Email;
import no.nb.microservices.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);
    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void sendEmail(@RequestBody Email email) {
        emailService.sendEmail(email);
    }
}

