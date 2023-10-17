package jna;

import com.sun.jna.Structure;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Structure.FieldOrder({"id", "name"})
public class Response extends Structure implements Structure.ByValue {
    public Long id;
    public String name;
}
