package hu.indicium.dev.notify.infrastructure.messaging.events;

import hu.indicium.dev.notify.infrastructure.messaging.QueueableEvent;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotificationEvent {
    private String message;

    private int version;

    private String routingKey;
}
