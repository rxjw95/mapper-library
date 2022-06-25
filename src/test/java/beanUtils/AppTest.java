package beanUtils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void copyProperties_UserToUser_Success() {
        User sourceUser = new User("jangwook", 28, List.of("football", "tennis"));
        User targetUser = new User();

        BeanUtils.copyProperties(sourceUser, targetUser);

        assertEquals("jangwook", targetUser.getName());
        assertEquals(28, targetUser.getAge());
        assertEquals(List.of("football", "tennis"), targetUser.getHobbies());
    }

    @Test
    void copyProperties_UserToPerson_Success() {
        User sourceUser = new User("jangwook", 28, List.of("football", "tennis"));
        Person targetPerson = new Person();

        BeanUtils.copyProperties(sourceUser, targetPerson, Person.class);

        assertEquals(28, targetPerson.getAge());
        assertTrue(targetPerson.getFirstName() == null);
        assertTrue(targetPerson.getLastName() == null);
    }
}