package city.seattle.mongodb.impl;

import city.seattle.domain.Seattle;
import city.seattle.mongodb.SeattleMongoDao;
import city.seattle.pagination.PaginationQuery;

import java.util.List;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class SeattleMongoDaoImpl implements SeattleMongoDao {

    @Override
    public void create(Seattle seattle) {

    }

    @Override
    public void update(Seattle seattle) {

    }

    @Override
    public Seattle get(long id) {
        return null;
    }

    @Override
    public long count(PaginationQuery paginationQuery) {
        return 0;
    }

    @Override
    public List<Seattle> findSeattles(PaginationQuery paginationQuery) {
        return null;
    }
}
