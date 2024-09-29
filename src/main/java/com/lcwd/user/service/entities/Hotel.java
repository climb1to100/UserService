package com.lcwd.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private Long id;
    private String name;
    private String email;
    private String about;
}