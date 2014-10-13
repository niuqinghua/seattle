package city.seattle.api.dto;

/**
 * Created by niuqinghua on 2014/9/14.
 */
public class SeattleDto {

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
        return "SeattleDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
