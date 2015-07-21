package no.nb.microservices.email.service;

import no.nb.microservices.email.model.Email;

/**
 * Created by andreasb on 21.07.15.
 */
public interface IEmailService {
    void sendEmail(Email email);
}
