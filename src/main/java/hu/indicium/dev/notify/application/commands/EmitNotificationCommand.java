package hu.indicium.dev.notify.application.commands;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmitNotificationCommand {
    private String message;
}
