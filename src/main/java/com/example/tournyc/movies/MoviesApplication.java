package com.example.tournyc.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
	private MovieRepository repo;
	public MovieController(MovieRepository repo) {
		this.repo = repo;
	}

	@GetMapping("/")
	public String index() {
		return "movies 3";
	}

	@GetMapping("/movies")
	public Iterable<Movie> movies() {
		return repo.findAll();
	}
}

interface MovieRepository extends CrudRepository<Movie, Integer>{}
