package com.example.botodnoklasniki;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String surname;
    private int age;
    private Gender gender;

    public enum Gender{
        MAN,
        WOMAN,
        OTHER,
    }
}
