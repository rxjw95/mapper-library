package modelMapper;

import modelMapper.diffName.Hobby;
import modelMapper.diffName.Me;
import modelMapper.diffType.AgeInt;
import modelMapper.diffType.AgeString;
import modelMapper.person.Age;
import modelMapper.person.Name;
import modelMapper.person.Person;
import modelMapper.person.PersonDto;
import modelMapper.user.User;
import modelMapper.user.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        modelMapper = new ModelMapper();
    }

    @Test
    void userToUserDto_Success() {
        User sourceUser = new User("jangwook", 28, List.of("tennis", "football"));
        UserDto targetUser = modelMapper.map(sourceUser, UserDto.class);

        assertEquals("jangwook", targetUser.getName());
        assertEquals(28, targetUser.getAge());
        assertEquals(List.of("tennis", "football"), targetUser.getHobbies());
    }

    @Test
    void userToUserDto_skipName_Success() {
        modelMapper.typeMap(User.class, UserDto.class)
                .addMappings(context -> {
                    context.skip(UserDto::setName);
                });

        User sourceUser = new User("jangwook", 28, List.of("tennis", "football"));
        UserDto targetUser = modelMapper.map(sourceUser, UserDto.class);

        assertEquals(null, targetUser.getName());
        assertEquals(28, targetUser.getAge());
        assertEquals(List.of("tennis", "football"), targetUser.getHobbies());
    }

    @Test
    void userToUserDto_skipNull_Success() {
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true);

        User sourceUser = new User(null, 28, List.of("tennis", "football"));
        UserDto targetUser = new UserDto("jangwook", 0, null);
        modelMapper.map(sourceUser, targetUser);

        assertEquals("jangwook", targetUser.getName());
        assertEquals(28, targetUser.getAge());
        assertEquals(List.of("tennis", "football"), targetUser.getHobbies());
    }

    @Test
    void PersonToPersonDto_Strategy_Statdard_Success() {
        Person sourcePerson = new Person(new Name("jangwook", "ryu"), new Age(26, 28), List.of("tennis", "football"));
        PersonDto targetPerson = modelMapper.map(sourcePerson, PersonDto.class);

        assertEquals("jangwook", targetPerson.getFirstName());
        assertEquals("ryu", targetPerson.getLastName());
        assertEquals(26, targetPerson.getInternationalAge());
        assertEquals(28, targetPerson.getDomesticAge());
    }

    @Test
    void PersonToPersonDto_Strategy_Strict_Fail() {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        Person sourcePerson = new Person(new Name("jangwook", "ryu"), new Age(26, 28), List.of("tennis", "football"));
        PersonDto targetPerson = modelMapper.map(sourcePerson, PersonDto.class);

        assertNull(targetPerson.getFirstName());
        assertNull(targetPerson.getLastName());
        assertEquals(0, targetPerson.getInternationalAge());
        assertEquals(0, targetPerson.getDomesticAge());
        assertEquals(List.of("tennis", "football"), targetPerson.getJobs());
    }

    @Test
    void HobbyToMe_DiffFieldName_Success_1() {
        modelMapper.typeMap(Hobby.class, Me.class)
                .addMapping(Hobby::getNames, Me::setHobbies)
                .addMapping(Hobby::getCount, Me::setCount);

        Hobby source = new Hobby(List.of("tennis", "football"), 2);
        Me target = modelMapper.map(source, Me.class);

        assertEquals(List.of("tennis", "football"), target.getHobbies());
        assertEquals(2, target.getCount());
    }

    @Test
    void HobbyToMe_DiffFieldName_Success_2() {
        modelMapper.typeMap(Hobby.class, Me.class)
                .addMappings(mapper -> {
                    mapper.map(Hobby::getNames, Me::setHobbies);
                    mapper.map(Hobby::getCount, Me::setCount);
                });

        Hobby source = new Hobby(List.of("tennis", "football"), 2);
        Me target = modelMapper.map(source, Me.class);

        assertEquals(List.of("tennis", "football"), target.getHobbies());
        assertEquals(2, target.getCount());
    }

    @Test
    void AgeStringToAgeInt_DiffType_Success() {
        modelMapper.typeMap(AgeString.class, AgeInt.class)
                .addMappings(m ->
                        m.using((Converter<String, Integer>) context -> (Integer) Integer.parseInt(context.getSource()))
                            .map(AgeString::getAge, AgeInt::setAge)
                );

        AgeString sourceAge = new AgeString("28");
        AgeInt targetAge = modelMapper.map(sourceAge, AgeInt.class);

        assertEquals(28, targetAge.getAge());
    }

}