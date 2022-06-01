package com.projects.praticandoAPI.controller.dto;
import com.projects.praticandoAPI.modelo.Exercicio;
import com.projects.praticandoAPI.modelo.Topico;

import java.util.List;
import java.util.stream.Collectors;


public class ExercicioDTO {

	private Long id;
	private String nome;
	private Topico topico;
	private Integer pontos;
	
	public ExercicioDTO(Exercicio exercicio) {
		this.id = exercicio.getId();
		this.nome = exercicio.getNome();
		this.topico = exercicio.getTopico();
		this.pontos = exercicio.getPontos();
	}

	public Long getId() {
		return id;
	}

	public static List<ExercicioDTO> converter(List<Exercicio> exercicios) {
		return exercicios.stream().map(ExercicioDTO::new).collect(Collectors.toList());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

}
