package city.seattle.manager.impl;

import city.seattle.api.dto.SeattleDto;
import city.seattle.api.dto.pagination.PaginationResultDto;
import city.seattle.manager.SeattleService;
import city.seattle.pagination.PaginationQuery;
import city.seattle.pagination.PaginationResult;
import city.seattle.vo.SeattleVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class SeattleServiceCXFImpl implements SeattleService {

    @Autowired
    private DozerBeanMapper dozerMapper;

    @Autowired
    private WebClient webClient;

    @Override
    public void create(SeattleVo seattleVo) {
        webClient.path("/seattleCxfService/create").accept(MediaType.APPLICATION_JSON).post(seattleVo);
    }

    @Override
    public void update(SeattleVo seattleVo) {
        webClient.path("/seattleCxfService/update").accept(MediaType.APPLICATION_JSON).put(seattleVo);
    }

    @Override
    public SeattleVo get(long id) {
        SeattleDto seattleDto = webClient.path("/seattleCxfService/{id}", id)
                                         .accept(MediaType.APPLICATION_JSON).get(SeattleDto.class);

        if(seattleDto == null) {
            return null;
        }

        return dozerMapper.map(seattleDto, SeattleVo.class);
    }

    @Override
    public PaginationResult<SeattleVo> findSeattles(PaginationQuery query) {
        GenericType<PaginationResultDto<SeattleDto>> responseType = new GenericType<PaginationResultDto<SeattleDto>>(){};
        PaginationResultDto<SeattleDto> paginationResultDto = webClient.path("/seattleCxfService/list")
                                                                       .accept(MediaType.APPLICATION_JSON).post(query, responseType);

        if(paginationResultDto == null) {
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
