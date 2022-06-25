package mapStruct.Person;

import java.util.List;

public record PersonDto(
        String lastName,
        String firstName,
        int internationalAge,
        int domesticAge,
        List<String> jobs) {}
