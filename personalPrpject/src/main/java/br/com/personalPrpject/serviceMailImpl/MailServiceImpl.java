package br.com.personalPrpject.serviceMailImpl;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import br.com.personalPrpject.serviceMail.MailService;

@Service("MailServiceImpl")
public class MailServiceImpl implements MailService {

	@Autowired
	@Qualifier("PersonalPrpjectMailSenderImpl")
	private JavaMailSenderImpl mailSender;

	@Override
	public void sendMail(String from, String[] to, String subject, String body) throws Exception {

		InternetAddress toAddrs[] = new InternetAddress[to.length];

		for (int i = 0; i < to.length; i++) {
			if (!to[i].equals("")) {
				toAddrs[i] = new InternetAddress(to[i]);
				System.out.println(toAddrs[i]);
			}
		}

		InternetAddress fromAddr = new InternetAddress(from);

//		MimeMessage message = mailSender.createMimeMessage(); USADO NO PROJETO (SISTEMATIZACAO - RJ)
		MimeMessage message = new MimeMessage(mailSender.getSession());
		message.setHeader("Content-Transfer-Encoding", "ISO-8859-1");
		message.setFrom(fromAddr);
		message.setRecipients(javax.mail.Message.RecipientType.TO, toAddrs);
		message.setSubject(subject);
		message.setContent(body, "text/html; charset=\"ISO-8859-1\"");

		mailSender.send(message);
	}

	@Override
	public void sendMailAnexo(String from, String[] enderecos, String subject, String body, byte[] anexo)
			throws Exception {
		InternetAddress toAddrs[] = new InternetAddress[enderecos.length];

		for (int i = 0; i < enderecos.length; i++) {
			if (!enderecos[i].equals("")) {
				toAddrs[i] = new InternetAddress(enderecos[i]);
				System.out.println(toAddrs[i]);
			}
		}

		InternetAddress fromAddr = new InternetAddress(from);

		MimeMessage message = mailSender.createMimeMessage();
		message.setHeader("Content-Transfer-Encoding", "ISO-8859-1");
		message.setFrom(fromAddr);
		message.setRecipients(javax.mail.Message.RecipientType.TO, toAddrs);
		message.setSubject(subject);

		// Create the message part
		BodyPart messageBodyPart = new MimeBodyPart();

		// Now set the actual message
		messageBodyPart.setContent(body, "text/html; charset=\"ISO-8859-1\"");

		// Create a multipar message
		Multipart multipart = new MimeMultipart();

		// Set text message part
		multipart.addBodyPart(messageBodyPart);

		// Part two is attachment
		messageBodyPart = new MimeBodyPart();

		messageBodyPart.setDataHandler(new DataHandler(new ByteArrayDataSource(anexo, "aplication/pdf")));

		messageBodyPart.setFileName("Justificativa.pdf");
		multipart.addBodyPart(messageBodyPart);

		message.setContent(multipart);
		mailSender.send(message);
	}

	@Override
	public void sendMail(String from, String endereco, String subject, String body) throws Exception {
		InternetAddress fromAddr = new InternetAddress(from);

		MimeMessage message = mailSender.createMimeMessage();
		message.setHeader("Content-Transfer-Encoding", "ISO-8859-1");
		message.setFrom(fromAddr);
		message.setRecipients(javax.mail.Message.RecipientType.TO, endereco);
		message.setSubject(subject);
		message.setContent(body, "text/html; charset=\"ISO-8859-1\"");

		mailSender.send(message);
	}

}
