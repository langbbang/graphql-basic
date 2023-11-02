package me.songha.graphql.basic;

import lombok.Data;

@Data
public class PersonDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Long addressId;

    public Person toEntity() {
        return Person.builder()
                .id(this.id)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .phoneNumber(this.phoneNumber)
                .email(this.email)
                .build();
    }
}
