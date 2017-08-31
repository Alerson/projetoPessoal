package br.com.personalPrpject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.personalPrpject.service.EmailService;
import br.com.personalPrpject.util.EnviarEmail;

@Service
public class EmailServiceImpl implements EmailService {

	private static final String EMAIL_NOTIFICACAO = "alerson.rigo@gmail.com";

	@Autowired
	private EnviarEmail email;

	@Override
	public void enviar(String assunto, String mensagem) {
		try {
			email.enviarEmail(assunto, mensagem, EMAIL_NOTIFICACAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
