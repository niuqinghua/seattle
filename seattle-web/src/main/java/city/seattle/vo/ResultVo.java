package city.seattle.vo;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class ResultVo {

    private boolean success;

    private String message;

    public ResultVo() {

    }

    public ResultVo(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
