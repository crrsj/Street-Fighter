package br.com.api.sf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.api.sf.dto.PersonagemDto;
import br.com.api.sf.entity.Personagem;
import br.com.api.sf.repository.PersonagemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonagemService {
	
	private final PersonagemRepository repository;
	
	public Personagem cadastroDePersonagem (PersonagemDto personagem) {
		var cadastrarPersonagem  = new Personagem(personagem);
		return repository.save(cadastrarPersonagem);
	}

	public List<Personagem>buscarPersonagens(){
		return repository.findAll();
	}
	
	public Personagem buscarPorId(Long id) {
		return repository.findById(id).get();
	}
	
	public Personagem AtualizarPersonagem(PersonagemDto personagem,Long id) {
		var atualizarPersonagem  = new Personagem(personagem);
		atualizarPersonagem.setId(id);
		return repository.save(atualizarPersonagem);
	}
	public void excluirPersonagem(Long id) {
		repository.findById(id);
		repository.deleteById(id);
	}
	public Personagem buscarPorNome(String nome) {
		return repository.findByNome(nome.trim().toUpperCase());
	}
}
