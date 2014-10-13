package city.seattle.protocol.dubbo.impl;

import city.seattle.api.dto.SeattleDto;
import city.seattle.api.dto.SeattleException;
import city.seattle.api.dto.pagination.PaginationQueryDto;
import city.seattle.api.dto.pagination.PaginationResultDto;
import city.seattle.api.protocol.dubbo.SeattleDubboService;
import city.seattle.domain.Seattle;
import city.seattle.pagination.PaginationQuery;
import city.seattle.pagination.PaginationResult;
import city.seattle.service.SeattleService;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuqinghua on 2014/9/14.
 */
@Service("seattleDubboService")
public class SeattleDubboServiceImpl implements SeattleDubboService {

    private static final Logger logger = LoggerFactory.getLogger(SeattleDubboServiceImpl.class);

    @Autowired
    private DozerBeanMapper dozerMapper;

    @Autowired
    private SeattleService seattleService;

    @Override
    public void create(SeattleDto seattleDto) {
        if(seattleDto == null) {
            throw new SeattleException("待创建实例不能为空");
        }

        try{
            Seattle seattle = dozerMapper.map(seattleDto, Seattle.class);
            seattleService.create(seattle);
        }catch (Exception e) {
            logger.error("创建Seattle实例异常," + seattleDto, e);
            throw new SeattleException("创建Seattle实例异常");
        }
    }

    @Override
    public void update(SeattleDto seattleDto) {
        if(seattleDto == null) {
            throw new SeattleException("实例不能为空");
        }

        try{
            Seattle seattle = dozerMapper.map(seattleDto, Seattle.class);
            seattleService.update(seattle);
        }catch (Exception e) {
            logger.error("更新Seattle实例异常," + seattleDto, e);
            throw new SeattleException("更新Seattle实例异常");
        }
    }

    @Override
    public SeattleDto get(long id) {
        try{
            Seattle seattle = seattleService.get(id);
            if(seattle == null) {
                return null;
            }
            return dozerMapper.map(seattle, SeattleDto.class);
        } catch (Exception e) {
            logger.error("获取Seattle实例异常,id[" + id +"]", e);
            throw new SeattleException("更新Seattle实例异常");
        }
    }

    @Override
    public PaginationResultDto<SeattleDto> findSeattles(PaginationQueryDto query) {
        if(query == null) {
            throw new SeattleException("分页查询条件为空");
        }

        int pageNo = query.getPageNo();
        int pageSize = query.getPageSize();
        int offset = (pageNo - 1) * pageSize;
        PaginationQuery paginationQuery = new PaginationQuery();
        paginationQuery.setOffset(offset);
        paginationQuery.setPageSize(pageSize);

        try{
            PaginationResult<Seattle> queryResult = seattleService.findSeattles(paginationQuery);
            if(queryResult == null) {
                return null;
            }

            PaginationResultDto<SeattleDto> result = new PaginationResultDto<SeattleDto>();
            result.setCount(queryResult.getCount());

            List<Seattle> seattleList = queryResult.getResult();
            if(CollectionUtils.isNotEmpty(seattleList)) {
                List<SeattleDto> seattleDtos = new ArrayList<SeattleDto>();
                for(Seattle seattle : seattleList) {
                    SeattleDto seattleDto = dozerMapper.map(seattle, SeattleDto.class);
                    seattleDtos.add(seattleDto);
                }
                result.setResult(seattleDtos);
            }

            return result;
        } catch (Exception e) {
            logger.error("分页获取Seattle列表异常", e);
            throw new SeattleException("分页获取Seattle列表异常");
        }
    }
}
