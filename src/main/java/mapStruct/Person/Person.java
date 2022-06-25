package mapStruct.Person;

import java.util.List;

public record Person(
        Name name,
        Age age,
        List<String> jobs) {}
