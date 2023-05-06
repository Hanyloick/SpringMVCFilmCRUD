package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.DatabaseAccessorObject;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmQueryController {
	@Autowired
	private DatabaseAccessorObject databaseAccessorObject;
	
	@RequestMapping(path = {"GetFilmData.do"}, 
					params = "id", 
					method = RequestMethod.GET)
	public ModelAndView getFilmById(@RequestParam("id") String input) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("WEB-INF/singlefilm.jsp");
		modelAndView.addObject("film", databaseAccessorObject.findFilmById(Integer.parseInt(input)));
		return modelAndView;
	}
	
	public DatabaseAccessorObject getDatabaseAccessorObject() {
		return databaseAccessorObject;
	}

	public void setDatabaseAccessorObject(DatabaseAccessorObject databaseAccessorObject) {
		this.databaseAccessorObject = databaseAccessorObject;
	}

//	@RequestMapping(path = {"GetFilmData.do"},
//					params = "keyword",
//					method = RequestMethod.GET)
//	public ModelAndView getFilmsByKeySearch(@RequestParam("keyword") String input) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("WEB-INF/films.jsp");
//		modelAndView.addObject("film" ,databaseAccessorObject.findFilmsByKeyword(input));
//		return modelAndView;	
//		
//	}
	
	@RequestMapping(value = "GetFilmData.do", 
					produces = "text/html", 
					method = RequestMethod.GET, 
					params = "keyword")
	public ModelAndView getFilmsByKeySearch(@RequestParam("keyword") String input,
	        @ModelAttribute("filmList") List<Film> filmList,
	        Model model) {
	  
	    ModelAndView mnv=  new ModelAndView("WEB-INF/films.jsp");
	    mnv.getModelMap().addAttribute("filmList", filmList);
	    return mnv;
	}
	

}
