package br.com.personalPrpject.service;

/**
 * 
 * @author alersonr
 *
 */
public interface EmailService {

	public Boolean enviar(String assunto, String mensagem, String enviadoPor, String messagaError, String messageSuccess);

}
