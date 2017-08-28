package br.com.personalPrpject.serviceMail;

public interface MailService {

	public void sendMail(String from, String[] enderecos, String subject,
			String body) throws Exception;
	
	public void sendMailAnexo(String from, String[] enderecos, String subject,
			String body, byte[] anexo) throws Exception;
	
	public void sendMail(String from, String endereco, String subject,
			String body) throws Exception;

}
