package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private DatabaseAccessor dao;

	@RequestMapping(path = { "makefilm.do" })
	public String home(Model model) {
		return "WEB-INF/createFilm.jsp";

	}
	
	@RequestMapping(path = { "findById.do" }, params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") String input) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("film", dao.findFilmById(Integer.parseInt(input)));
		modelAndView.setViewName("WEB-INF/idFilmSearch.jsp");
		System.out.println("MODEL AND VIEW"+modelAndView + "FILM BY ID CONTROLLER");
		return modelAndView;
	}
	
	@RequestMapping(path = "createFilm.do", method = RequestMethod.POST)
	public ModelAndView newFilm(Film film, RedirectAttributes redir) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		dao.createFilm(film);
		
		redir.addFlashAttribute("film", film);
		System.out.println("in create film controller method");
		modelAndView.setViewName("redirect:filmAdded.do"); // redirect to new mapping
		
		return modelAndView;
	}
	
	@RequestMapping(path = "filmAdded.do",
			method = RequestMethod.GET)
	public ModelAndView filmAdded() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/idFilmSearch.jsp");
		return modelAndView;
	}
	
	
	
	
	@RequestMapping(path = "editFilm.do", method = RequestMethod.GET)
	public ModelAndView filmEdited(Film film) {
		ModelAndView modelAndView = new ModelAndView();
		film = dao.findFilmById(film.getFilmId());
		modelAndView.addObject("film", film);
		modelAndView.setViewName("WEB-INF/editfilm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(path ="updateFilm.do", params="filmId", method = RequestMethod.POST)
	public ModelAndView updateFilm(@RequestParam("updateFilm") String filmId, @ModelAttribute("film") Film film) {
		System.out.println("results: " + film);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("film", film);
		dao.saveFilm(film.getFilmId(), film);
		modelAndView.setViewName("WEB-INF/confirmation.jsp");
		return modelAndView;
	}
	@RequestMapping(path = "filmDelete.do", method = RequestMethod.POST)
	public ModelAndView filmDelete(@RequestParam("delete") int filmId, RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("in delete");
		dao.deleteFilm(filmId);
		//redir.addFlashAttribute("film", film);
		modelAndView.setViewName("redirect:filmDeleted.do");
		return modelAndView;
	}
	@RequestMapping(path = "filmDeleted.do", method = RequestMethod.GET)
	public ModelAndView filmDeleted() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/deleteFilm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(path = "keyword.do", method = RequestMethod.GET)
	public ModelAndView filmKeyword(@RequestParam("keyword")String keyword) {
		ModelAndView modelAndView = new ModelAndView();
		List<Film> films = dao.findFilmsByKeyword(keyword);
		modelAndView.addObject("film", films);
		modelAndView.setViewName("WEB-INF/keyword.jsp");
		System.out.println(films);
		return modelAndView;
	}
	
	public DatabaseAccessor getDao() {
		return dao;
	}

	public void setDao(DatabaseAccessor dao) {
		this.dao = dao;
	}

}
