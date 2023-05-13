package com.example.mongodbrestapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "employee")
@NoArgsConstructor
public class Employee {
    @Id
    private long id;
    private String firstName;
    private String lastName;
    @Field("email")
    private String emailId;
    // Unique reference to the auto-incremented sequence for the employee collection
    @Transient
    public static final String SEQUENCE_NAME = "employees_sequence";
}
