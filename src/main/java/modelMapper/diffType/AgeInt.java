package modelMapper.diffType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AgeInt {
    Integer age;

    public AgeInt() {}

    public AgeInt(Integer age) {
        this.age = age;
    }
}
