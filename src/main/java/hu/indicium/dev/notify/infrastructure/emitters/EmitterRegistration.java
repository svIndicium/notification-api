package hu.indicium.dev.notify.infrastructure.emitters;

import hu.indicium.dev.notify.domain.model.NotificationEmitter;
import hu.indicium.dev.notify.domain.model.NotificationEmitterHolder;
import hu.indicium.dev.notify.infrastructure.emitters.discord.DiscordNotificationEmitter;
import hu.indicium.dev.notify.infrastructure.emitters.logging.LogNotificationEmitter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
public class EmitterRegistration implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Collection<NotificationEmitter> notificationEmitters = Arrays.asList(
                new DiscordNotificationEmitter(),
                new LogNotificationEmitter()
        );
        for (NotificationEmitter notificationEmitter : notificationEmitters) {
            NotificationEmitterHolder.getHolder().registerEmitter(notificationEmitter);
        }
    }
}
