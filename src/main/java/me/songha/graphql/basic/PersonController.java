package me.songha.graphql.basic;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PersonController {
    private final PersonRepository personRepository;

    @QueryMapping(value = "findAll")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @QueryMapping(value = "findById")
    public Person findById(@Argument Long id) {
        return personRepository.findById(id).get();
    }

    @MutationMapping(value = "create")
    public Person create(@Argument PersonDto personDto) {
        return personRepository.save(personDto.toEntity());
    }

    @MutationMapping(value = "update")
    public Person update(@Argument PersonDto personDto) {
        return personRepository.save(personDto.toEntity());
    }

    @MutationMapping(value = "delete")
    public int delete(@Argument Long id) {
        personRepository.deleteById(id);
        return 1;
    }

}