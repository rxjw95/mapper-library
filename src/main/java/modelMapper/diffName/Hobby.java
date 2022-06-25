package modelMapper.diffName;

import lombok.Getter;

import java.util.List;

@Getter
public class Hobby {
    private List<String> names;
    private int count;

    public Hobby(List<String> names, int count) {
        this.names = names;
        this.count = count;
    }
}
