package interact.movieIndex.resources;

import interact.movieIndex.api.Movie;
import interact.movieIndex.core.MovieIndex;
import io.dropwizard.jersey.params.IntParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("movies/year")
@Produces(MediaType.APPLICATION_JSON)
public class YearResource {
	/*
	Retrieves movies based on year
	*/

	private MovieIndex index;

	public YearResource(MovieIndex index) {
		this.index = index;
	}

	//GET commands to this resource will return all movies for a given year
	@GET
	@Path("{year}")
	public List<Movie> getMoviesForYear(@PathParam("year") IntParam year) {
		List<Movie> moviesInYear = index.retrieveYear(year.get());
		return moviesInYear;
	}
}