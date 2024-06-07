package br.com.api.sf.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.sf.dto.PersonagemDto;

import br.com.api.sf.service.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("fighter")
@RequiredArgsConstructor
public class PersonagemController {

	private final PersonagemService service; 
	
	@PostMapping
	@Operation(summary = "Rota responsável pelo cadastro de personagens") 
    @ApiResponse(responseCode = "201",description = "usuário cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })       
	public ResponseEntity<PersonagemDto>cadastrarPersonagem(@RequestBody @Valid PersonagemDto personagem){
		var cadastrarPersonagem = service.cadastroDePersonagem(personagem);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("fighter/{id}")
		.buildAndExpand(cadastrarPersonagem.getId()).toUri();
		return ResponseEntity.created(uri).body(new PersonagemDto(cadastrarPersonagem));
	}
	
	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todos os personagens")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<PersonagemDto>>buscarPersonagens(){
		var busca = service.buscarPersonagens().stream().map(PersonagemDto::new).toList();
		return ResponseEntity.ok(busca);
	}
	
	@GetMapping("{id}")
	@Operation(summary = "Rota responsável por buscar um personagem pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })      
	public ResponseEntity<PersonagemDto>buscarPorId(@PathVariable Long id){
		var buscaId = service.buscarPorId(id);
		return ResponseEntity.ok().body(new PersonagemDto(buscaId));
	}
	@PutMapping("{id}")
	@Operation(summary = "Rota responsável por atualizar um personagem pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })      
	public ResponseEntity<PersonagemDto>atualizarPersonagem(@RequestBody @Valid PersonagemDto personagem,@PathVariable Long id){
		var atualizar = service.AtualizarPersonagem(personagem, id);
		return ResponseEntity.ok().body(new PersonagemDto(atualizar));
	}
	
	@DeleteMapping("{id}")  	
	@Operation(summary = "Rota responsável por deletar um personagem pelo id")
	@ApiResponse(responseCode = "204",description = " sem conteúdo",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })        
	public ResponseEntity<Void>excluirPersonagem(@PathVariable Long id){
		service.excluirPersonagem(id);
		return ResponseEntity.noContent().build();
		
	}
	    @GetMapping("buscaNome")
	    @Operation(summary = "Rota responsável por buscar um personagem pelo nome")
		 @ApiResponse(responseCode = "200",description = " sucesso",content = {
		    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
		  })        
		public ResponseEntity<PersonagemDto>buscarPorNome(@RequestParam(name = "nome") String nome){
			var buscaPorNome = service.buscarPorNome(nome);
			return ResponseEntity.ok().body(new PersonagemDto(buscaPorNome));
			
		}
	}
