package com.example.mongodbrestapi.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class required for autoincrement sequence for other collections(long id)
 * <a href="https://www.baeldung.com/spring-boot-mongodb-auto-generated-field">Auto-Generated Field for MongoDB using Spring Boot</a>
 */
@Data
@Document(collection = "database_sequences")
@NoArgsConstructor
public class DatabaseSequence {
    @Id
    private String id;
    private long seq;
}
