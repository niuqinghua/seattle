package city.seattle.api.dto.pagination;

import java.util.List;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class PaginationResultDto<T> {

    private long count;

    private List<T> result;

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
                ", count=" + count +
                ", result=" + result +
                '}';
    }
}
