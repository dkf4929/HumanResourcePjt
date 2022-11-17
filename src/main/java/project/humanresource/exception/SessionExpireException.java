package project.humanresource.exception;

public class SessionExpireException extends RuntimeException {

    public SessionExpireException() {
    }

    public SessionExpireException(String message) {
        super(message);
    }

    public SessionExpireException(String message, Throwable cause) {
        super(message, cause);
    }

    public SessionExpireException(Throwable cause) {
        super(cause);
    }
}
