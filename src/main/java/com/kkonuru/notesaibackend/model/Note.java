package com.kkonuru.notesaibackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank
    private String name;
    @NotBlank
    private String content;

    private String userId;
    @NotBlank
    private int numDocuments;
    @NotBlank
    private Date lastUpdated;

}
