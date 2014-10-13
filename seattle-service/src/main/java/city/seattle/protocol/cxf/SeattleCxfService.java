package city.seattle.protocol.cxf;

import city.seattle.api.dto.SeattleDto;
import city.seattle.api.dto.pagination.PaginationQueryDto;
import city.seattle.api.dto.pagination.PaginationResultDto;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public interface SeattleCxfService {

    /**
     * 创建Seattle实例
     * @param seattleDto
     */
    public void create(SeattleDto seattleDto);

    /**
     * 更新Seattle
     * @param seattleDto
     */
    public void update(SeattleDto seattleDto);

    /**
     * 获取Seattle实例
     * @param id
     * @return
     */
    public SeattleDto get(long id);

    /**
     * 分页获取Seattle
     * @param query
     * @return
     */
    public PaginationResultDto<SeattleDto> list(PaginationQueryDto query);

}
