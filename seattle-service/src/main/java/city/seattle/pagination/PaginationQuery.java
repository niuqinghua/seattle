package city.seattle.pagination;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class PaginationQuery {

    private int offset;

    private int pageSize;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PaginationQuery{" +
                ", pageSize=" + pageSize +
                '}';
    }
}
