package city.seattle.mongodb;

import city.seattle.domain.Seattle;
import city.seattle.pagination.PaginationQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by niuqinghua on 2014/9/14.
 */
public interface SeattleMongoDao {

    /**
     * 创建Seattle实例
     * @param seattle
     */
    public void create(Seattle seattle);

    /**
     * 更新Seattle
     * @param seattle
     */
    public void update(Seattle seattle);

    /**
     * 获取Seattle实例
     * @param id
     * @return
     */
    public Seattle get(long id);

    /**
     * 查询相关Seattle总量
     * @param paginationQuery
     * @return
     */
    public long count(PaginationQuery paginationQuery);

    /**
     * 查询相关Seattle列表
     * @param paginationQuery
     * @return
     */
    public List<Seattle> findSeattles(PaginationQuery paginationQuery);
}
