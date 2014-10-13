package city.seattle.exception;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class WebException extends RuntimeException {

    public WebException() {
    }

    public WebException(String message) {
        super(message);
    }

    public WebException(String message, Throwable cause) {
        super(message, cause);
    }

    public WebException(Throwable cause) {
        super(cause);
    }
}
