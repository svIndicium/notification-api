package hu.indicium.dev.notify.infrastructure.emitters.discord;

import hu.indicium.dev.notify.domain.model.Notification;
import hu.indicium.dev.notify.domain.model.NotificationEmitter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class DiscordNotificationEmitter implements NotificationEmitter {
    @Override
    public void emit(Notification notification) {
        String webhookUrl = System.getenv("DISCORD_WEBHOOK_URL");

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response;
        HttpPost request = new HttpPost(webhookUrl);
        request.addHeader("Content-Type", "application/json");
        try {
            String jsonMessage = "{\"content\": \"" + notification.getMessage().replace("\"", "\\\"") + "\"}";
            StringEntity params = new StringEntity(jsonMessage);
            request.setEntity(params);
            response = httpClient.execute(request);
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
}
