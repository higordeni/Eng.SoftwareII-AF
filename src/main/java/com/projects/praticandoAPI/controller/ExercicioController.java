package com.projects.praticandoAPI.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projects.praticandoAPI.controller.dto.ExercicioDTO;
import com.projects.praticandoAPI.controller.form.ExercicioForm;
import com.projects.praticandoAPI.modelo.Exercicio;
import com.projects.praticandoAPI.repository.ExercicioRepository;

@RestController
@CrossOrigin
@RequestMapping("/exercicios")
public class ExercicioController {
	
	@Autowired
	private ExercicioRepository exercicioRepository;
	
	@GetMapping
	public List<ExercicioDTO> lista() {
		List<Exercicio> exercicios = exercicioRepository.findAll();
		return ExercicioDTO.converter(exercicios);
	}
	
	@PostMapping
	public ResponseEntity<ExercicioDTO> cadastrar(@RequestBody ExercicioForm form, UriComponentsBuilder uriBuilder) {
		Exercicio exercicio = form.converter(exercicioRepository);
		exercicioRepository.save(exercicio);
		
		URI uri = uriBuilder.path("/exercicios/{id}").buildAndExpand(exercicio.getId()).toUri();
		return ResponseEntity.created(uri).body(new ExercicioDTO(exercicio));
	}
}
