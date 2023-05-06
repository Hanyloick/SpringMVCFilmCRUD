package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.DatabaseAccessor;

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

	
	public DatabaseAccessor getDao() {
		return dao;
	}

	public void setDao(DatabaseAccessor dao) {
		this.dao = dao;
	}

}
