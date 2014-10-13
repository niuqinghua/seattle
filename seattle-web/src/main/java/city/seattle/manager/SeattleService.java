package city.seattle.manager;

import city.seattle.pagination.PaginationQuery;
import city.seattle.pagination.PaginationResult;
import city.seattle.vo.SeattleVo;

/**
 * Created by niuqinghua on 2014/9/14.
 */
public interface SeattleService {

    /**
     * 创建Seattle实例
     * @param seattleVo
     */
    public void create(SeattleVo seattleVo);

    /**
     * 更新Seattle
     * @param seattleVo
     */
    public void update(SeattleVo seattleVo);

    /**
     * 获取Seattle实例
     * @param id
     * @return
     */
    public SeattleVo get(long id);

    /**
     * 分页获取Seattle
     * @param query
     * @return
     */
    public PaginationResult<SeattleVo> findSeattles(PaginationQuery query);
}
