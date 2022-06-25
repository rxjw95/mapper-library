package modelMapper.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
public class UserDto {
    private String name;
    private int age;
    private List<String> hobbies;

    public UserDto() {}

    public UserDto(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }
}
