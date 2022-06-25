package modelMapper.user;

import lombok.Getter;

import java.util.List;

@Getter
public class User {
    private String name;
    private int age;
    private List<String> hobbies;

    public User() {}

    public User(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }
}
