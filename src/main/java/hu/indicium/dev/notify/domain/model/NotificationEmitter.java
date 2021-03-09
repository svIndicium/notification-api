package hu.indicium.dev.notify.domain.model;

public interface NotificationEmitter {
    void emit(Notification notification) throws EmitException;
}
