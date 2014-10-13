package city.seattle.api.dto;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class SeattleException extends RuntimeException {

    public SeattleException() {
    }

    public SeattleException(String message) {
        super(message);
    }

    public SeattleException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeattleException(Throwable cause) {
        super(cause);
    }
}
