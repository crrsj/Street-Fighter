package br.com.api.sf.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.api.sf.entity.Personagem;
import jakarta.validation.constraints.NotBlank;

public record PersonagemDto(
		Long id,
		@NotBlank(message = "Não pode estar em branco")
		String nome, 		
	    @JsonFormat(pattern = "dd/MM/yyyy")
		LocalDate dataNasc,
		@NotBlank(message = "Não pode estar em branco")
		String paisOrigem,
		
		double altura,
		@NotBlank(message = "Não pode estar em branco")
		String peso,
		@NotBlank(message = "Não pode estar em branco")
		String estiloDeLuta,
		@NotBlank(message = "Não pode estar em branco")
	    String primeiraAparicao) {

	public PersonagemDto(Personagem cadastrarPersonagem) {
		this(
				cadastrarPersonagem.getId(),
				cadastrarPersonagem.getNome(),
				cadastrarPersonagem.getDataNasc(),
				cadastrarPersonagem.getPaisOrigem(),
				cadastrarPersonagem.getAltura(),
				cadastrarPersonagem.getPeso(),
				cadastrarPersonagem.getEstiloDeLura(),
				cadastrarPersonagem.getPrimeiraAparicao());
	}

}
