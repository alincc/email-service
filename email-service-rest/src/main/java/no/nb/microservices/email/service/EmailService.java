package no.nb.microservices.email.service;

import no.nb.microservices.email.config.ApplicationSettings;
import no.nb.microservices.email.model.Email;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andreasb on 21.07.15.
 */
@Service
public class EmailService implements IEmailService {

    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;
    private ApplicationSettings applicationSettings;

    @Autowired
    public EmailService(JavaMailSender mailSender, VelocityEngine velocityEngine, ApplicationSettings applicationSettings) {
        this.mailSender = mailSender;
        this.velocityEngine = velocityEngine;
        this.applicationSettings = applicationSettings;
    }
    @Override
    public void sendEmail(Email email) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(email.getTo());
                if (email.getCc() != null) {
                    message.setCc(email.getCc());
                }
                message.setSubject(email.getSubject());
                message.setFrom(email.getFrom());
                Map model = new HashMap<>();
                model.put("email", email.getContent());
                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "templates/" + email.getTemplate(), model);
                message.setText(text, true);
            }
        };

        this.mailSender.send(preparator);
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }
}
