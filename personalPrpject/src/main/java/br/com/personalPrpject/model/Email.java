package br.com.personalPrpject.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Email implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6599838287692721552L;

	private String emailPessoal;
	private String assunto;
	private String menssagem;

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

	public String getEmailPessoal() {
		return emailPessoal;
	}

	public void setEmailPessoal(String emailPessoal) {
		this.emailPessoal = emailPessoal;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

}
