package hu.indicium.dev.notify.infrastructure.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.indicium.dev.notify.application.commands.EmitNotificationCommand;
import hu.indicium.dev.notify.application.service.NotificationService;
import hu.indicium.dev.notify.infrastructure.messaging.events.NotificationEvent;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotificationListener {
    private final NotificationService notificationService;

    private final ObjectMapper objectMapper;

    @RabbitListener(queues = "notification")
    public void execute(String eventJson) {
        try {
            NotificationEvent notificationEvent = objectMapper.readerFor(NotificationEvent.class).readValue(eventJson);
            EmitNotificationCommand emitNotificationCommand = EmitNotificationCommand.builder()
                    .message(notificationEvent.getMessage())
                    .build();
            notificationService.emit(emitNotificationCommand);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
