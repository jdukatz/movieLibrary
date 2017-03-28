package interact.movieIndex.resources;

import interact.movieIndex.api.Movie;
import interact.movieIndex.core.MovieIndex;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {
	/*
	Recieves HTTP REST commands for CRUD operations
	and makes calls to the indexer based on those commands
	*/

	private MovieIndex index;

	public MovieResource(MovieIndex index) {
		this.index = index;
	}

	//C
	@POST
	public Movie create(Movie movie) {
		return index.save(movie);
	}

	//R
	@GET
	@Path("{title}")
	public Movie retrieve(@PathParam("title") String title) {
		return index.findByTitle(title);
	}

	//U
	@PUT
	@Path("{title}")
	public Movie update(@PathParam("title") String title, Movie movie) {
		return index.update(title, movie);
	}

	//D
	@DELETE
	@Path("{title}")
	public Response delete(@PathParam("title") String title) {
		index.delete(title);
		return Response.ok().build();
	}
}