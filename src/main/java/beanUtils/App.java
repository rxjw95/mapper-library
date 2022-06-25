package beanUtils;

import java.util.List;

public class App {
    public static void main(String[] args) {
        User sourceUser = new User("jangwook", 28, List.of("football", "tennis"));
        User targetUser = new User();

        System.out.println(targetUser);
    }
}
