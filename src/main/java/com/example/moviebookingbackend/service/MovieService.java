package com.example.moviebookingbackend.service;

import com.example.moviebookingbackend.model.Movie;
import com.example.moviebookingbackend.model.MovieInfo;
import com.example.moviebookingbackend.model.ShowtimeInfo;
import com.example.moviebookingbackend.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public List<MovieInfo> getAllMoviesQuery() {
        List<Movie> movies = movieRepository.findAllMoviesQuery();
        List<MovieInfo> movieInfos = new ArrayList<>();

        for (Movie movie : movies) {
            List<String> genres = movieRepository.findGenresByMovieId(movie.getId());
            MovieInfo movieInfo = new MovieInfo();
            movieInfo.setId(movie.getId());
            movieInfo.setTitle(movie.getTitle());
            movieInfo.setDescription(movie.getDescription());
            movieInfo.setImage(movie.getImage());
            movieInfo.setReleaseDate(movie.getReleaseDate());
            movieInfo.setAgeLimit(movie.getAgeLimit());
            movieInfo.setDirector(movie.getDirector());
            movieInfo.setActors(movie.getActors());
            movieInfo.setPrice(movie.getPrice());
            movieInfo.setGenres(genres);
            movieInfos.add(movieInfo);
        }
        return movieInfos;
    }
    public List<Movie> getAllMoviesWithShowtimesToday() {return movieRepository.findMoviesWithShowtimesToday(); }

    public List<Movie> getAllMoviesWithShowtimesUpcoming() {return movieRepository.findMoviesWithShowtimesUpcoming(); }

    public MovieInfo getMovieById(int movieId) {
//        return movieRepository.findById(movieId).orElse(null);
        Movie movie = movieRepository.findById(movieId).orElse(null);

            List<String> genres = movieRepository.findGenresByMovieId(movie.getId());
            MovieInfo movieInfo = new MovieInfo();
            movieInfo.setId(movie.getId());
            movieInfo.setTitle(movie.getTitle());
            movieInfo.setDescription(movie.getDescription());
            movieInfo.setImage(movie.getImage());
            movieInfo.setReleaseDate(movie.getReleaseDate());
            movieInfo.setAgeLimit(movie.getAgeLimit());
            movieInfo.setDirector(movie.getDirector());
            movieInfo.setActors(movie.getActors());
            movieInfo.setPrice(movie.getPrice());
            movieInfo.setGenres(genres);

        return movieInfo;
    }


}
