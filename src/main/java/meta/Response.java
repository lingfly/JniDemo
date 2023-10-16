package meta;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Response {
    private Long id;
    private String name;

    public Response(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
