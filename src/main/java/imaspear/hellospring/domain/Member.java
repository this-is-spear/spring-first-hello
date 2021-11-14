package imaspear.hellospring.domain;

/**
 * Created by Imaspear on 2021-10-24
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class Member {
    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
