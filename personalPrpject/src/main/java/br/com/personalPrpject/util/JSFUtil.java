package br.com.personalPrpject.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class JSFUtil {

	public static void adicionarMensagem(Severity severity, String mensagem) {
		FacesMessage msg = new FacesMessage(severity, mensagem, mensagem);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, msg);
	}

}
