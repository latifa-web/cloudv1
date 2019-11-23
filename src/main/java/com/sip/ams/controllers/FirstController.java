package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Animal;

@Controller

public class FirstController {
	@GetMapping("/home")
	public String home() {
		return "/first/home";
	}
	
	@GetMapping("/acceuil")
	public String acceuil(@RequestParam(required=false,defaultValue = "Latifa")String prenom,@RequestParam(required=false,defaultValue = "Chouk")String nom,ModelMap mnObj) {
		String ch = "Votre Nom Complet : "+prenom+" "+nom;
		mnObj.put("msg",ch);
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Lyon",3));
		animals.add(new Animal("Cat",2));
		animals.add(new Animal("Dog",1));
		mnObj.put("listeAnimals", animals);
		
		return "/first/acceuil";
	}

}
