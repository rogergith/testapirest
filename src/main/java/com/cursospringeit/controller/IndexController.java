package com.cursospringeit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cursospringeit.model.DtoPersonas;
import com.cursospringeit.model.Persona;

@RestController
@RequestMapping("/api")
public class IndexController {

	private List<Persona> personas = new ArrayList<Persona>();
	private DtoPersonas dtoPersonas = new DtoPersonas();
	
	@PostConstruct
	public void init(){
		
		
		personas.add(new Persona("roger", "araque", "biruaca"));
		personas.add(new Persona("daniel", "perez", "san fernando"));
		personas.add(new Persona("jorge", "fernandez", "calabozo"));
		personas.add(new Persona("edwin", "duarte", "cucuta"));
		personas.add(new Persona("angela", "dominguez", "merida"));
		
		dtoPersonas.setData(personas);
		dtoPersonas.setNumfilas(personas.size());
		dtoPersonas.setSuccess(true);
	
	}
	
	/**
	 * http://localhost:8080/api/users
	 * @param session
	 * @return
	 */
	@GetMapping("/users")
	//@CrossOrigin(origins="*")
	@ResponseStatus(code=HttpStatus.OK)
	public DtoPersonas personas(){
			
		return dtoPersonas;

	}
	
	@PostMapping("/user")
	//@CrossOrigin(origins="*")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void crearPersona(@RequestBody Persona persona){
		
		personas.add(persona);
		
	}
	
	@GetMapping("/user/{nombre}")
	public ResponseEntity<Persona> persona(@PathVariable String nombre){
		
		for(Persona persona : personas){
			if(persona.getNombre().equalsIgnoreCase(nombre)){
				return new ResponseEntity<Persona>(persona, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}
	
	
}
