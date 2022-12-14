package com.mvc.pojo;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    @JsonAlias(value = {"u","un"})
    private String name;
    private String address;

}
