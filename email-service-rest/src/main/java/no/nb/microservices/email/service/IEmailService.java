package no.nb.microservices.email.service;

import no.nb.microservices.delivery.metadata.model.OrderMetadata;
import no.nb.microservices.email.model.Email;
import org.springframework.core.annotation.Order;

/**
 * Created by andreasb on 21.07.15.
 */
public interface IEmailService {
    void sendDeliveryEmail(OrderMetadata orderMetadata);

    void sendEmail(Email email);
}
