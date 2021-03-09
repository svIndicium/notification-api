package hu.indicium.dev.notify.infrastructure.emitters.logging;

import hu.indicium.dev.notify.domain.model.Notification;
import hu.indicium.dev.notify.domain.model.NotificationEmitter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogNotificationEmitter implements NotificationEmitter {
    @Override
    public void emit(Notification notification) {
        log.info(notification.getMessage());
    }
}
