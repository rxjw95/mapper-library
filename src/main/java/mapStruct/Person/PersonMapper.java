package mapStruct.Person;

import modelMapper.person.Info;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(source = "name.lastName", target = "lastName")
    @Mapping(source = "name.firstName", target = "firstName")
    @Mapping(source = "age.international", target = "internationalAge")
    @Mapping(source = "age.domestic", target = "domesticAge")
    PersonDto toDto(Person person);

    @Mapping(source = "name.lastName", target = "lastName")
    @Mapping(source = "name.firstName", target = "firstName")
    @Mapping(source = "age.international", target = "internationalAge")
    @Mapping(source = "age.domestic", target = "domesticAge")
    Info assemble(Name name, Age age);
}
