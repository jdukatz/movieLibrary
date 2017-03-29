package interact.movieIndex.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import interact.movieIndex.api.Movie;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

public class MovieIndexer implements MovieIndex {
	/*
	Implements the index interface. Responsible for recieving
	REST commands from resources.
	*/

	private List<Movie> movies;

	public MovieIndexer() throws IOException {
		URL url = Resources.getResource("movie_database.json"); //just loading in a fake "database" for now
		String json = Resources.toString(url, Charsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Movie.class);
		movies = mapper.readValue(json, type);
	}

	@Override
	public Movie save(Movie movie) {
		movies.add(movie);
		return movie;
	}
	
	@Override
	public Movie findByTitle(String title) {
		Movie movie = new Movie();
		Boolean found = false;
		for (int i=0; i < movies.size(); i++) {
			if (movies.get(i).getTitle().equals(title) == true) {
				found = true;
				movie = movies.get(i);
				break;
			}
		}
		if (found == false) {
			System.out.println("movie does not exist");
		}
		return movie;
	}

	@Override
	public Movie update(String title, Movie movie) {
		Movie existingMovie = findByTitle(title);
		if (existingMovie.getTitle() == null) {
			//findByTitle will return an empty Movie object if not found
			System.out.println("movie not found");
		} else {
			//remove the current entry, add the new one
			movies.remove(existingMovie);
			save(movie);
		}
		return movie;
	}

	@Override
	public void delete(String title) {
		movies.removeIf(m -> m.getTitle().equals(title) == true);
	}

	@Override
	public List<Movie> retrieveYear(Integer year) {
		List<Movie> moviesForYear = new ArrayList<Movie>();
		for (Movie m : movies) {
			if (m.getYear() == year) {
				moviesForYear.add(m);
			}
		}
		return moviesForYear;
	}
}