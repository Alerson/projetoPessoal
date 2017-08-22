/**
 * 
 */
package br.com.personalPrpject.service;

import br.com.personalPrpject.model.EnderecoDozer.Enderecos;

/**
 * @author alersonr
 *
 */
public interface EnderecoService {
	
	public Enderecos chamarWebService(String uf, String localidade, String logradouro);

}
