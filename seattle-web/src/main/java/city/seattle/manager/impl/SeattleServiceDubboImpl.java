package city.seattle.manager.impl;

import city.seattle.api.dto.SeattleDto;
import city.seattle.api.dto.pagination.PaginationQueryDto;
import city.seattle.api.dto.pagination.PaginationResultDto;
import city.seattle.api.protocol.dubbo.SeattleDubboService;
import city.seattle.manager.SeattleService;
import city.seattle.pagination.PaginationQuery;
import city.seattle.pagination.PaginationResult;
import city.seattle.vo.SeattleVo;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuqinghua on 2014/9/14.
 */
public class SeattleServiceDubboImpl implements SeattleService {

    @Autowired
    private DozerBeanMapper dozerMapper;

    @Autowired
    private SeattleDubboService seattleDubboService;

    @Override
    public void create(SeattleVo seattleVo) {
        SeattleDto seattleDto = dozerMapper.map(seattleVo, SeattleDto.class);
        seattleDubboService.create(seattleDto);
    }

    @Override
    public void update(SeattleVo seattleVo) {
        SeattleDto seattleDto = dozerMapper.map(seattleVo, SeattleDto.class);
        seattleDubboService.update(seattleDto);
    }

    @Override
    public SeattleVo get(long id) {
        SeattleDto seattleDto = seattleDubboService.get(id);

        if(seattleDto == null) {
            return null;
        }

        return dozerMapper.map(seattleDto, SeattleVo.class);
    }

    @Override
    public PaginationResult<SeattleVo> findSeattles(PaginationQuery query) {
        PaginationQueryDto paginationQueryDto = dozerMapper.map(query, PaginationQueryDto.class);
        PaginationResultDto<SeattleDto> paginationResultDto = seattleDubboService.findSeattles(paginationQueryDto);

        if(paginationQueryDto == null) {
            return null;
        }

        PaginationResult<SeattleVo> paginationResult = new PaginationResult<SeattleVo>();
        paginationResult.setCount(paginationResultDto.getCount());

        List<SeattleDto> seattleDtos = paginationResultDto.getResult();
        if(CollectionUtils.isNotEmpty(seattleDtos)) {
            List<SeattleVo> seattleVos = new ArrayList<SeattleVo>();
            for(SeattleDto seattleDto : seattleDtos) {
                SeattleVo seattleVo = dozerMapper.map(seattleDto, SeattleVo.class);
                seattleVos.add(seattleVo);
            }
            paginationResult.setResult(seattleVos);
        }

        return paginationResult;
    }
}
