package com.example.homeworka.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data()
@AllArgsConstructor()
public class Article {
    @NotNull(message = "ID Cannot be nul.")
    private int id;

    @NotEmpty(message = "Title Cannot be nul")
    @Size(max = 100, message = "Maximum length of 100 characters.")
    private String title;

    @NotEmpty(message = "author Cannot be null")
    @Size(min = 4,max = 20, message = "Must be more than 4 characters. And Maximum length of 20 characters.")
    private String author;

    @NotEmpty(message = "content Cannot be null")
    @Size(min = 10, message = "Must be more than 200 characters")
    private String content;


    @NotEmpty(message = "category can not be null")
    @Pattern(regexp = "(politics|sports|technology)+$",message = "Must be either \"politics\", \" sports\" or \" technology\" only.")
    private String category;

    @NotEmpty(message = "imageUrl can not be null")
    private String imageUrl;


    @AssertFalse(message = "Must be by default false")
    private boolean isPublished;

    @NotNull(message = "publishDate can not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;


}
