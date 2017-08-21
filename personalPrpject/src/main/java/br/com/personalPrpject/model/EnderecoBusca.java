package br.com.personalPrpject.model;

/**
 * 
 * @author alersonr
 *
 */
public class EnderecoBusca {

	private String localidade;
	private String uf;
	private String logradouro;

	public EnderecoBusca() {
		super();
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
