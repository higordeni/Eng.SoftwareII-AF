package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Exercicio;
import com.projects.praticandoAPI.modelo.Topico;
import com.projects.praticandoAPI.repository.ExercicioRepository;

public class ExercicioForm {
    
	private String nome;
	private Topico topico;
	private Integer pontos;
	
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
	
	public Exercicio converter(ExercicioRepository exercicioRepository) {
		
		return new Exercicio(nome, topico, pontos);
	}
}
