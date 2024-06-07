package br.com.api.sf.entity;

import java.time.LocalDate;

import br.com.api.sf.dto.PersonagemDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private LocalDate dataNasc;
	private String paisOrigem;
	private double altura;
	private String peso;
	private String estiloDeLura;
	private String primeiraAparicao;
	

	public Personagem(PersonagemDto personagem) {
		this.id = personagem.id();
		this.nome = personagem.nome();
		this.dataNasc = personagem.dataNasc();
		this.paisOrigem = personagem.paisOrigem();
		this.altura = personagem.altura();
		this.peso = personagem.peso();
		this.estiloDeLura = personagem.estiloDeLuta();
		this.primeiraAparicao = personagem.primeiraAparicao();
		
	}
}
