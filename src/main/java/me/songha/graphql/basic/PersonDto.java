package me.songha.graphql.basic;

import lombok.Data;

@Data
public class PersonDto {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Person toEntity() {
        return Person.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .build();
    }
}
