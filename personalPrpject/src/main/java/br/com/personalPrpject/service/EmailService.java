package br.com.personalPrpject.service;

/**
 * 
 * @author alersonr
 *
 */
public interface EmailService {

	public void enviar(String assunto, String mensagem, String enviadoPor, String messagaInfo);

}
