package br.com.personalPrpject.bean;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.personalPrpject.model.Email;
import br.com.personalPrpject.service.EmailService;

/**
 * 
 * @author alersonr
 *
 */
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

	@ManagedProperty("#{proper}")
	private ResourceBundle proper;

	public void enviarEmail() {
		if(service.enviar(email.getAssunto(), email.getMenssagem(), email.getEmailPessoal(), proper.getString("proper.message.emailInvalido"), proper.getString("proper.message.emailEnviado"))) {
			email = new Email();
		}
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

	public ResourceBundle getProper() {
		return proper;
	}

	public void setProper(ResourceBundle proper) {
		this.proper = proper;
	}
}
