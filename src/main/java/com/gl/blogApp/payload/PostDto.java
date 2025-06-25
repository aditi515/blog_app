package com.gl.blogApp.payload;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    private Long id;
    @NotEmpty
    @Size(min = 2, message ="post title should have at least 2 character")
    private String title;

    @NotEmpty
    @Size(min = 10, message ="post description should have at least 10 character")
    private String description;
    @NotEmpty
    private String content;

//    private List<String> comments;


}
