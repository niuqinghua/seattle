package city.seattle.vo;

/**
 * Created by niuqinghua on 2014/9/16.
 */
public class SeattleVo {

    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SeattleVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
