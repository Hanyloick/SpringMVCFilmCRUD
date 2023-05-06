package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.DatabaseAccessor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private DatabaseAccessor dao;

	@RequestMapping(path = { "/", "home.do" })
	public String home(Model model) {
		return "WEB-INF/home.jsp";

	}

	@RequestMapping(path = { "film.do" }, params = "id", method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") String input) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/singlefilm.jsp");
		modelAndView.addObject("film", dao.findFilmById(Integer.parseInt(input)));
		return modelAndView;
	}
	
	@RequestMapping(path = "film.do", method = RequestMethod.POST)
	public ModelAndView newState(Film film, RedirectAttributes redir) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		dao.createFilm(film);
		
		redir.addFlashAttribute("film", film);
		
		modelAndView.setViewName("redirect:filmAdded.do"); // redirect to new mapping
		
		return modelAndView;
	}
	
	@RequestMapping(path = "filmAdded.do",
			method = RequestMethod.GET)
	public ModelAndView stateAdded() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/singlefilm.jsp");
		return modelAndView;
	}
	
	public DatabaseAccessor getDao() {
		return dao;
	}

	public void setDao(DatabaseAccessor dao) {
		this.dao = dao;
	}

}
