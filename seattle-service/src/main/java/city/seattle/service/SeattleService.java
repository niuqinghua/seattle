package city.seattle.service;

import city.seattle.domain.Seattle;
import city.seattle.pagination.PaginationQuery;
import city.seattle.pagination.PaginationResult;

/**
 * Created by niuqinghua on 2014/9/14.
 */
public interface SeattleService {
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
     * 分页获取Seattle
     * @param query
     * @return
     */
    public PaginationResult<Seattle> findSeattles(PaginationQuery query);

}
