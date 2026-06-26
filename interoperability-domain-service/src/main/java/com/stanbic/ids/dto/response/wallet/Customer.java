package com.stanbic.ids.dto.response.wallet;

import lombok.Data;

@Data
public class Customer {

    private String firstName;
    private String lastName;
    private String gender;
    private String dateOfBirth;
    private IdDocument idDocument;

}
