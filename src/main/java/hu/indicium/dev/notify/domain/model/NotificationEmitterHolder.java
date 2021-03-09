package hu.indicium.dev.notify.domain.model;

import lombok.Singular;

import java.util.Collection;
import java.util.HashSet;

public class NotificationEmitterHolder {
    private final Collection<NotificationEmitter> emitters;

    private static NotificationEmitterHolder notificationEmitterHolder;

    private NotificationEmitterHolder() {
        emitters = new HashSet<>();
    }

    public static NotificationEmitterHolder getHolder() {
        if (notificationEmitterHolder == null) {
            notificationEmitterHolder = new NotificationEmitterHolder();
        }
        return notificationEmitterHolder;
    }

    public void registerEmitter(NotificationEmitter notificationEmitter) {
        this.emitters.add(notificationEmitter);
    }

    public void emit(Notification notification) {
        for (NotificationEmitter emitter : emitters) {
            emitter.emit(notification);
        }
    }
}
