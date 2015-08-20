package no.nb.microservices.email.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "email")
public class ApplicationSettings {
    private String outgoingServer;
    private String deliveryDownloadUrl;

    public String getOutgoingServer() {
        return outgoingServer;
    }

    public void setOutgoingServer(String outgoingServer) {
        this.outgoingServer = outgoingServer;
    }

    public String getDeliveryDownloadUrl() {
        return deliveryDownloadUrl;
    }

    public void setDeliveryDownloadUrl(String deliveryDownloadUrl) {
        this.deliveryDownloadUrl = deliveryDownloadUrl;
    }
}
