package br.com.personalPrpject.serviceMailImpl;

import java.util.Properties;

import javax.annotation.PostConstruct;

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

	public PersonalPrpjectMailSenderImpl() {
		super();
	}
	
	@PostConstruct
	public void init() {
		super.setHost(env.getProperty("mail.host"));
		Properties mailProps = new Properties();
		mailProps.setProperty("mail.smtp.auth", "false");
		super.setJavaMailProperties(mailProps);
	}
	
}
