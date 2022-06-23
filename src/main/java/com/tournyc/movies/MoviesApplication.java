package com.tournyc.movies;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

}

@RestController
class MovieController {
	private MovieRepository repository;

	public MovieController(MovieRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public String index() {
		return "The data from the database is " + StreamSupport.stream(repository.findAll().spliterator(), false).map(m -> m.name()).collect(Collectors.joining(", "));
	}
}

interface MovieRepository extends CrudRepository<Movie, Integer>{}

record Movie(@Id Integer id, String name){}