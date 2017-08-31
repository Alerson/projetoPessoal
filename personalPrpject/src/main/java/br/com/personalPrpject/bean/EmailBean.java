package br.com.personalPrpject.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.personalPrpject.model.Email;
import br.com.personalPrpject.service.EmailService;

@SessionScoped
@ManagedBean(name = "emailBean")
public class EmailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8533827689606422768L;
	private Email email = new Email();

	@ManagedProperty(value = "#{emailServiceImpl}")
	private EmailService service;

	public void enviarEmail() {
		service.enviar(email.getAssunto(), email.getMenssagem());
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public EmailService getService() {
		return service;
	}

	public void setService(EmailService service) {
		this.service = service;
	}
	
}
