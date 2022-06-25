package modelMapper.person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class PersonDto {
    private String lastName;
    private String firstName;
    private int internationalAge;
    private int domesticAge;
    private List<String> jobs;
    private int countOfJobs;
}
