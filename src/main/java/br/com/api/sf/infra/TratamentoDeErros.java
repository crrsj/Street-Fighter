package br.com.api.sf.infra;

import java.util.NoSuchElementException;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



import br.com.api.sf.dto.MensagemDeErro;

@ControllerAdvice
public class TratamentoDeErros {
    
	@ExceptionHandler(IncorrectResultSizeDataAccessException.class)
	public ResponseEntity<MensagemDeErro>erroAoBuscarPorNome(){
		var erros = new MensagemDeErro(HttpStatus.NOT_FOUND, "Personagem não encontrado !");
		return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErro>erroAoBuscarPorId(){
		var erros = new MensagemDeErro(HttpStatus.NOT_FOUND, "ID não encontrado !");
		return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>tratador400(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(TratandoErros::new).toList());		
	}
	public record TratandoErros(String campo,String mensagem) {
		public TratandoErros(FieldError erro) {
			this(erro.getField(),erro.getDefaultMessage());
		}
  }
}	
	
