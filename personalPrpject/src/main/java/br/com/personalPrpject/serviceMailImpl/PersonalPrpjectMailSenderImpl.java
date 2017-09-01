package br.com.personalPrpject.serviceMailImpl;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Configuration
@Service("PersonalPrpjectMailSenderImpl")
@PropertySource("classpath:email.properties")
public class PersonalPrpjectMailSenderImpl extends JavaMailSenderImpl {

	@Autowired
	private Environment env;
	
	private Session session;

	public PersonalPrpjectMailSenderImpl() {
		super();
	}

	@PostConstruct
	public void init() {
		// super.setHost(env.getProperty("mail.host"));
		Properties mailProps = new Properties();
		// mailProps.setProperty("mail.smtp.auth", "false");
		mailProps.put("mail.smtp.host", "smtp.gmail.com");
		mailProps.put("mail.smtp.socketFactory.port", "465");
		mailProps.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		mailProps.put("mail.smtp.auth", "true");
		mailProps.put("mail.smtp.port", "465");
		// mailProps.put("mail.username", "alerson.rigo@gmail.com");
		// mailProps.put("mail.password", "470700321");
		super.setJavaMailProperties(mailProps);

		session = Session.getDefaultInstance(mailProps, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(env.getProperty("mail.username"), env.getProperty("mail.password"));
			}
		});

	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
