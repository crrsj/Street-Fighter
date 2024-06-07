package br.com.api.sf.dto;

import org.springframework.http.HttpStatus;

public record MensagemDeErro(HttpStatus status, String mensagem) {

}
