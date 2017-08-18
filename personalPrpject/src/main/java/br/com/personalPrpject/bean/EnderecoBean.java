package br.com.personalPrpject.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3817194591110827981L;
	private String estado;
	private Map<String, String> estados = new HashMap<String, String>();
	private Map<String, String> listaEstadosOrdenada = new LinkedHashMap<>();

	@PostConstruct
	public void listaEstados() {
		estados = new HashMap<String, String>();
		estados.put("AC", "AC");
		estados.put("AL", "AL");
		estados.put("AP", "AP");
		estados.put("AM", "AM");
		estados.put("BA", "BA");
		estados.put("CE", "CE");
		estados.put("DF", "DF");
		estados.put("ES", "ES");
		estados.put("GO", "GO");
		estados.put("MA", "MA");
		estados.put("MT", "MT");
		estados.put("MS", "MS");
		estados.put("MG", "MG");
		estados.put("PA", "PA");
		estados.put("PB", "PB");
		estados.put("PR", "PR");
		estados.put("PE", "PE");
		estados.put("PI", "PI");
		estados.put("RJ", "RJ");
		estados.put("RN", "RN");
		estados.put("RS", "RS");
		estados.put("RO", "RO");
		estados.put("RR", "RR");
		estados.put("SC", "SC");
		estados.put("SP", "SP");
		estados.put("SE", "SE");
		estados.put("TO", "TO");

		// CONCEITO LAMBDA JAVA 8 PARA ORDENAR A LISTA HASHMAP ACIMA
		estados.entrySet().stream().sorted(Map.Entry.<String, String>comparingByKey()).forEachOrdered(x -> listaEstadosOrdenada.put(x.getKey(), x.getKey()));
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

}
