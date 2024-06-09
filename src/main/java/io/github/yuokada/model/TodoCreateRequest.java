package io.github.yuokada.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TodoCreateRequest(
    @JsonProperty("title")
    @NotBlank(message="Title may not be blank")
    @Size(max=32, message="Title must be between 1 and 32 characters")
    String title
//    ,
//    @JsonProperty("description")
//    @NotBlank(message="Description may not be blank")
//    @Size(max=256, message="Description must be between 1 and 256 characters")
//    String description
) {

}
