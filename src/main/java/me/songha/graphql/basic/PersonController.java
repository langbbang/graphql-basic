package me.songha.graphql.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PersonController {
    private final PersonRepository personRepository;

    @SchemaMapping(typeName = "Query", value = "findAll")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @SchemaMapping(typeName = "Query", value = "findById")
    public Person findById(@Argument Long id) {
        return personRepository.findById(id).get();
    }

    @MutationMapping(value = "create")
    public Person create(@Argument PersonDto personDto) {
        return personRepository.save(personDto.toEntity());
    }

}