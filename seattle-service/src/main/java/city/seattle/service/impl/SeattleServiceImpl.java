package city.seattle.service.impl;

import city.seattle.dao.SeattleDao;
import city.seattle.domain.Seattle;
import city.seattle.pagination.PaginationQuery;
import city.seattle.pagination.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import city.seattle.service.SeattleService;

import java.util.List;

/**
 * Created by niuqinghua on 2014/9/14.
 */
@Service("seattleService")
public class SeattleServiceImpl implements SeattleService {

    @Autowired
    private SeattleDao seattleDao;

    @Override
    public void create(Seattle seattle) {
        seattleDao.create(seattle);
    }

    @Override
    public void update(Seattle seattle) {
        seattleDao.update(seattle);
    }

    @Override
    public Seattle get(long id) {
        return seattleDao.get(id);
    }

    @Override
    public PaginationResult<Seattle> findSeattles(PaginationQuery query) {
        long count = seattleDao.count(query);
        if(count == 0) {
            return null;
        }

        List<Seattle> seattles = seattleDao.findSeattles(query);
        PaginationResult<Seattle> paginationResult = new PaginationResult<Seattle>();
        paginationResult.setCount(count);
        paginationResult.setResult(seattles);
        return paginationResult;
    }
}
