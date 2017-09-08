package br.com.personalPrpject.service.impl;

import org.springframework.stereotype.Service;

import br.com.personalPrpject.service.EmailService;
import br.com.personalPrpject.util.EnviaEmail;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public void enviar(String assunto, String mensagem, String enviadoPor) {
		EnviaEmail.enviarHTMLEmail(assunto, mensagem, enviadoPor);
	}

}
