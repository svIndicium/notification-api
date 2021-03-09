package hu.indicium.dev.notify.application.service;

import hu.indicium.dev.notify.application.commands.EmitNotificationCommand;
import hu.indicium.dev.notify.domain.model.Notification;

public interface NotificationService {
    void emit(EmitNotificationCommand emitNotificationCommand);
}
