package hu.indicium.dev.notify.application.service;

import hu.indicium.dev.notify.application.commands.EmitNotificationCommand;
import hu.indicium.dev.notify.domain.model.Notification;
import hu.indicium.dev.notify.domain.model.NotificationEmitter;
import hu.indicium.dev.notify.domain.model.NotificationEmitterHolder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void emit(EmitNotificationCommand emitNotificationCommand) {
        Notification notification = new Notification(emitNotificationCommand.getMessage());
        NotificationEmitterHolder.getHolder().emit(notification);
    }
}
