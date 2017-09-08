package br.com.personalPrpject.service.impl;

import javax.faces.application.FacesMessage;

import org.springframework.stereotype.Service;

import br.com.personalPrpject.service.EmailService;
import br.com.personalPrpject.util.EnviaEmail;
import br.com.personalPrpject.util.JSFUtil;

@Service
public class EmailServiceImpl implements EmailService {

	@Override
	public Boolean enviar(String assunto, String mensagem, String enviadoPor, String messageError, String messageSuccess) {
		boolean retorno = true;
		if(EnviaEmail.validarEmail(enviadoPor)) {
			EnviaEmail.enviarHTMLEmail(assunto, mensagem, enviadoPor);
			JSFUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, messageSuccess);
		} else {
			JSFUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, messageError);
			retorno = false;
		}
		return retorno;
		
	}

}
