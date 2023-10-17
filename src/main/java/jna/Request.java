package jna;

import com.sun.jna.Structure;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Structure.FieldOrder({"id", "name"})
public class Request extends Structure implements Structure.ByValue {

    public Long id;
    public String name;
}
