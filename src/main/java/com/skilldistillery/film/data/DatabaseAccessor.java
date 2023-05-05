package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface DatabaseAccessor {
	Film findFilmById(int filmId);

	List<Film> findFilmsByActorId(int actorId);

	List<Film> findFilmsByKeyword(String keyword);

	List<Film> findCopiesCondition(Film film);

	Actor findActorById(int actorId);

	List<Actor> findActorsByFilmId(int filmId);

	public List<Film> getAllInfoOnAllCopiesFilms(String keyword);

	public Actor createActor(Actor actor);

	public boolean saveActor(Actor actor);

	public boolean deleteActor(Actor actor);
	
	public Film createFilm(Film film);
	
	public boolean saveFilm(int filmId, Film film);
	
	public boolean deleteFilm(int filmId, Film film);

}
