package modelMapper.diffName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Me {
    private List<String> hobbies;
    private int count;

    public Me() {}

    public Me(List<String> hobbies, int count) {
        this.hobbies = hobbies;
        this.count = count;
    }
}

