package com.example.tournyc.movies;

import org.springframework.data.annotation.Id;

public record Movie(@Id Integer id, String name) {

}
