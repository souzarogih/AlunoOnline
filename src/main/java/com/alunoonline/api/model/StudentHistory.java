package com.alunoonline.api.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "student_history")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentHistory {
    @Id
    private String id;
    private String student_name;
    private String student_id;
    private String history_type;

}
