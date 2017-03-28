package interact.movieIndex.core;

import interact.movieIndex.api.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieIndex {
	Movie save(Movie movie);
	Movie findByTitle(String title);
	Movie update(String title, Movie movie);
	void delete(String title);
}