package br.com.personalPrpject.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

/**
 * Classe Utilitária que contém métodos para envio de Email através de conta do
 * Gmail
 */
public class EnviaEmail {

	private static final String SENDER_USER = "xxxxxxxx@gmail.com";
	private static final String PASSWORD = "xxxxxxxx";
	private static final String RECEIVING_BOX = "xxxxxxxxx@gmail.com";
	private static final String PORT_GMAIL_COM = "465";
	private static final String SMTP_GMAIL_COM = "smtp.gmail.com";

	public static void enviarEmail(String assunto, String mensagem, String emailPessoal) {
		SimpleEmail email = new SimpleEmail();
		email.setSSLOnConnect(true);
		email.setHostName(SMTP_GMAIL_COM);
		email.setSslSmtpPort(PORT_GMAIL_COM);
		email.setAuthenticator(new DefaultAuthenticator(SENDER_USER, PASSWORD));
		try {
			email.setFrom(emailPessoal);
			email.setDebug(true);
			email.setSubject(assunto);
			email.setMsg(mensagem);
			email.addTo(RECEIVING_BOX);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public static void enviarHTMLEmail(String assunto, String mensagem, String emailPessoal) {
		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(true);
		email.setHostName(SMTP_GMAIL_COM);
		email.setSslSmtpPort(PORT_GMAIL_COM);
		email.setAuthenticator(new DefaultAuthenticator(SENDER_USER, PASSWORD));
		try {
			email.setFrom(SENDER_USER);
			email.setDebug(true);
			email.setSubject(assunto);
			StringBuilder builder = new StringBuilder();
			builder.append("<h3>Buscador CEP</h3>");
			builder.append("<p>" + mensagem + "</p>");
			builder.append("<p>Enviado por: " + emailPessoal + "</p>");
			email.setHtmlMsg(builder.toString());
			email.addTo(RECEIVING_BOX);
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	public static boolean validarEmail(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}

}