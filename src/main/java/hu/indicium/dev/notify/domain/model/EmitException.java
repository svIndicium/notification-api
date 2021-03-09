package hu.indicium.dev.notify.domain.model;

public class EmitException extends RuntimeException {
    public EmitException(String service, String message) {
        super("Emit notification failed for platform: " + service + ". The message is \"" + message + "\"");
    }
}
