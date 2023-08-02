package com.example.exercises;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Exercise1 {
    private static final MovieService movieService = InMemoryMovieService.getInstance();

    public static void main(String[] args) {
        // Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();
        var directorMovieCount =
                movies.stream()
                        .map(Movie::getDirectors)
                        .flatMap(List::stream)
                        .collect(groupingBy(identity(), counting()));

        directorMovieCount.forEach((director, count) -> System.out.println("%24s: %2d".formatted(director.getName(),count)));

    }

}
