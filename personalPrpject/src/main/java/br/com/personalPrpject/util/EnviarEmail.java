package br.com.personalPrpject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.personalPrpject.serviceMail.MailService;

@Component
public class EnviarEmail {

	@Autowired
	MailService mailService;

	public void enviarEmail(String assunto, String message, String[] emailNotificacao) throws Exception {
		mailService.sendMail("FINDER_CEP@personalProject.com.br", emailNotificacao, assunto, gerarCorpoEmail(message));
	}

	public void enviarEmail(String assunto, String message, String emailNotificacao) throws Exception{
		mailService.sendMail("FINDER_CEP@personalProject.com.br", emailNotificacao, assunto, gerarCorpoEmail(message));
	}

	public String gerarCorpoEmail(String message) {
		StringBuilder sd = new StringBuilder();
		sd.append("<html><body>");
		sd.append("<p>Prezado,</p>");
		sd.append(message);
		sd.append("</body></html>");
		return sd.toString();
	}

}
