package com.projects.praticandoAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.praticandoAPI.modelo.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

	Exercicio findByNome(String nome);
	
	List<Exercicio> findAll();

}