package com.kkonuru.notesaibackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

//Data annotation bundles the features tostring, equals, getter/setter, and required args constructor
@Data
@Builder
@Document(collection="Note")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Note {

    @Id
    private String id;
    private String name;
    private String content;
    private String userId;
    private List<String> documentIds;
    private Date lastUpdated;

}
