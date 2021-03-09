package hu.indicium.dev.notify.infrastructure.emitters.discord;

import hu.indicium.dev.notify.domain.model.EmitException;

public class DiscordEmitException extends EmitException {
    public DiscordEmitException(String message) {
        super("Discord", message);
    }
}
