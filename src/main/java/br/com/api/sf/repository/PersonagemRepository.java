package br.com.api.sf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.api.sf.entity.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
	@Query(value = "select p from Personagem p where upper(trim(p.nome)) like %?1% ") 
	Personagem findByNome(String nome);

}
