package br.com.personalPrpject.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.personalPrpject.serviceMail.MailService;

@Component
public class EnviarEmail {

	@Autowired
	MailService mailService;

	//Email email = new Email();

	/*public void enviarEmail(String assunto, String message, String[] emailNotificacao) throws Exception {
		mailService.sendMail("FINDER_CEP@personalProject.com.br", emailNotificacao, assunto, gerarCorpoEmail(message, "userTeste"));
	}*/

	public void enviarEmail(String assunto, String message, String emailNotificacao, String enviadoPor) throws Exception{
		mailService.sendMail("FINDER_CEP@personalProject.com.br", emailNotificacao, assunto, gerarCorpoEmail(message, enviadoPor));
	}

	public String gerarCorpoEmail(String message, String enviadoPor) {
		StringBuilder sd = new StringBuilder();
		sd.append("<html><body>");
		sd.append("<p><strong>Buscador Cep</strong></p>");
		sd.append(message);
		sd.append("<p><strong>Enviado por: </strong>" + enviadoPor + "</p>");
		sd.append("</body></html>");
		return sd.toString();
	}

}
