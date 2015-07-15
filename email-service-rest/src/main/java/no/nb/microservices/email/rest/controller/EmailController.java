package no.nb.microservices.email.rest.controller;

import no.nb.microservices.delivery.metadata.model.ItemMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmailController {

    private static final Logger LOG = LoggerFactory.getLogger(EmailController.class);

    @RequestMapping(value = "/delivery/send", method = RequestMethod.POST)
    public ResponseEntity sendDeliveryEmail(@Valid ItemMetadata itemMetadata) {
        return new ResponseEntity(HttpStatus.OK);
    }
}
