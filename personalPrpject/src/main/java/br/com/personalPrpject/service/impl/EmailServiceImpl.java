package br.com.personalPrpject.service.impl;

import br.com.personalPrpject.service.EmailService;
import br.com.personalPrpject.util.EnviaEmail;

public class EmailServiceImpl implements EmailService {

	@Override
	public void enviar(String assunto, String mensagem, String enviadoPor) {
		EnviaEmail.enviarHTMLEmail(assunto, mensagem, enviadoPor);
	}

}
