package interact.movieIndex;

import interact.movieIndex.core.MovieIndexer;
import interact.movieIndex.core.MovieIndex;
import interact.movieIndex.resources.MovieResource;
import interact.movieIndex.resources.YearResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.io.IOException;

public class MovieIndexApplication extends Application<MovieIndexConfiguration> {

    public static void main(final String[] args) throws Exception {
        new MovieIndexApplication().run(args);
    }

    @Override
    public String getName() {
        return "MovieIndex";
    }

    @Override
    public void initialize(final Bootstrap<MovieIndexConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final MovieIndexConfiguration configuration, final Environment environment) {
        MovieIndex index;
        try {
            index = new MovieIndexer();
        } catch (IOException ioe) {
            System.out.println(ioe);
            throw new RuntimeException("couldn't read movie database", ioe);
        }
        MovieResource movieResource = new MovieResource(index);
        YearResource yearResource = new YearResource(index);
        environment.jersey().register(movieResource);
        environment.jersey().register(yearResource);
    }

}
