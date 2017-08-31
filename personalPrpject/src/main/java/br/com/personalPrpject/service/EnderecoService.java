/**
 * 
 */
package br.com.personalPrpject.service;

import java.util.HashMap;

import br.com.personalPrpject.model.EnderecoDozer.Enderecos;

/**
 * @author alersonr
 *
 */
public interface EnderecoService {

	public Enderecos chamarWebService(String uf, String localidade, String logradouro);

	public HashMap<String, String> listaEstadosBrasileiro();

}
