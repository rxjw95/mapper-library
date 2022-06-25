package modelMapper.person;

import lombok.Getter;

import java.util.List;

@Getter
public class Person {
    private Name name;
    private Age age;
    private List<String> jobs;

    public Person(Name name, Age age, List<String> jobs) {
        this.name = name;
        this.age = age;
        this.jobs = jobs;
    }
}
