package modelMapper.person;

import lombok.Getter;

@Getter
public class Age {
    int international;
    int domestic;

    public Age(int international, int domestic) {
        this.international = international;
        this.domestic = domestic;
    }
}
