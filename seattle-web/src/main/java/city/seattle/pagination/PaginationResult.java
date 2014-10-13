package city.seattle.pagination;

import java.util.List;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class PaginationResult<T> {

    private boolean sucess;

    private String message;

    private long count;

    private List<T> result;

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PaginationResult{" +
                "sucess=" + sucess +
                ", message='" + message + '\'' +
                ", count=" + count +
                ", result=" + result +
                '}';
    }
}
