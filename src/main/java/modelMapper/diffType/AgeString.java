package modelMapper.diffType;

import lombok.Getter;

@Getter
public class AgeString {
    String age;

    public AgeString() {}

    public AgeString(String age) {
        this.age = age;
    }
}
