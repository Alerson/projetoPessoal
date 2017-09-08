package br.com.personalPrpject.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.personalPrpject.model.EnderecoBusca;
import br.com.personalPrpject.model.EnderecoDozer.Enderecos;
import br.com.personalPrpject.service.EnderecoService;
import br.com.personalPrpject.util.JSFUtil;
/**
 * 
 * @author alersonr
 *
 */
@SessionScoped
@ManagedBean(name = "enderecoBean")
public class EnderecoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3817194591110827981L;
	private Map<String, String> estados = new HashMap<String, String>();
	private Map<String, String> listaEstadosOrdenada = new LinkedHashMap<>();
	private EnderecoBusca enderecoBusca = new EnderecoBusca();
	private Enderecos listaEnderecoDozerMapper;
	
	@ManagedProperty(value = "#{enderecoServiceImpl}")
	private EnderecoService service;

	@ManagedProperty("#{proper}")
	private ResourceBundle proper;

	@PostConstruct
	public void listaEstados() {
		try {
			estados = service.listaEstadosBrasileiro();

			// CONCEITO LAMBDA JAVA 8 PARA ORDENAR A LISTA HASHMAP ACIMA
			estados.entrySet().stream().sorted(Map.Entry.<String, String>comparingByKey()).forEachOrdered(x -> listaEstadosOrdenada.put(x.getKey(), x.getKey()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enviarEmail() {
		redirecionar("/pages/email.xhtml");
	}

	public void telaBusca() {
		redirecionar("/pages/principal.xhtml");
	}

	public void redirecionar(String pagina) {
		try {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			externalContext.redirect(externalContext.getRequestContextPath() + pagina);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buscarCep() {
		listaEnderecoDozerMapper = service.chamarWebService(enderecoBusca.getUf(), enderecoBusca.getLocalidade(), enderecoBusca.getLogradouro());
		if(listaEnderecoDozerMapper.getEndereco() == null || listaEnderecoDozerMapper.getEndereco().isEmpty() || listaEnderecoDozerMapper.getEndereco().size() <= 0) {
			JSFUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, proper.getString("proper.message.naoEncontrado"));
		} else {
			enderecoBusca = new EnderecoBusca();
		}
	}

	public Enderecos getListaEnderecoDozerMapper() {
		return listaEnderecoDozerMapper;
	}

	public void setListaEnderecoDozerMapper(Enderecos listaEnderecoDozerMapper) {
		this.listaEnderecoDozerMapper = listaEnderecoDozerMapper;
	}

	public EnderecoService getService() {
		return service;
	}

	public void setService(EnderecoService service) {
		this.service = service;
	}

	public EnderecoBusca getEnderecoBusca() {
		return enderecoBusca;
	}

	public void setEnderecoBusca(EnderecoBusca enderecoBusca) {
		this.enderecoBusca = enderecoBusca;
	}

	public Map<String, String> getEstados() {
		return estados;
	}

	public void setEstados(Map<String, String> estados) {
		this.estados = estados;
	}

	public Map<String, String> getListaEstadosOrdenada() {
		return listaEstadosOrdenada;
	}

	public void setListaEstadosOrdenada(Map<String, String> listaEstadosOrdenada) {
		this.listaEstadosOrdenada = listaEstadosOrdenada;
	}

	public ResourceBundle getProper() {
		return proper;
	}

	public void setProper(ResourceBundle proper) {
		this.proper = proper;
	}

}
