package hu.indicium.dev.notify.application.commands;

import lombok.Data;

@Data
public class EmitNotificationCommand {
    private String message;
}
