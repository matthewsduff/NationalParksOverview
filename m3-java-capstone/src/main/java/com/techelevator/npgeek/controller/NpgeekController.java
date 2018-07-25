package com.techelevator.npgeek.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;





@Controller 
@SessionAttributes("nationalParksSession")
public class  {

	@RequestMapping(path="/favFood", method=RequestMethod.GET)
	public String displayfavFood() {
		
		return "favFood";
	}
	
	@RequestMapping(path="/favColor", method=RequestMethod.POST)
	public String processFavColor(@RequestParam String color,
												 ModelMap model) {
		
		FavoriteThingModel favoriteThings = new FavoriteThingModel();
		favoriteThings.setColor(color);
		
		model.addAttribute("userFavoriteThings", favoriteThings);
		System.out.println(color);
		System.out.println(favoriteThings.getColor());
		return "redirect:/favFood";
	}
	
	@RequestMapping(path="/favFood", method=RequestMethod.POST)
	public String processFavFood(@RequestParam String food,
												 ModelMap model) {
		
		FavoriteThingModel favoriteThings = (FavoriteThingModel)model.get("userFavoriteThings");
		favoriteThings.setFood(food);
		
		return "redirect:/favSeason";
	}
	@RequestMapping(path="/favSeason", method=RequestMethod.POST)
	public String processFavSeason(@RequestParam String season,
												 ModelMap model) {
		
		FavoriteThingModel favoriteThings = (FavoriteThingModel)model.get("userFavoriteThings");
		favoriteThings.setSeason(season);
		
		
		
		return "redirect:/favSummary";
	}
	
	
	
	@RequestMapping(path="/favColor", method=RequestMethod.GET)
	public String displayfavColor() {
		
		return "favColor";
	}
	@RequestMapping(path="/favSummary", method=RequestMethod.GET)
	public String displaySummary() {
		
		return "favSummary";
	}
	@RequestMapping(path="/favSeason", method=RequestMethod.GET)
	public String displayfavSeason() {
		
		return "favSeason";
	}
}
