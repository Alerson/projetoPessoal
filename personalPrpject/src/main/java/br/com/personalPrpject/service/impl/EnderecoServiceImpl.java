package br.com.personalPrpject.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import br.com.personalPrpject.jaxb.Xmlcep;
import br.com.personalPrpject.jaxb.Xmlcep.Enderecos.Endereco;
import br.com.personalPrpject.service.EnderecoService;

/**
 * 
 * @author alersonr
 *
 */
public class EnderecoServiceImpl implements EnderecoService {

	public void chamarWebService(String uf, String localidade, String logradouro) {
		try {
			URL url = new URL("http://viacep.com.br/ws/" + uf + "/" + localidade + "/" + logradouro + "/xml/");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			JAXBContext jaxbContext = JAXBContext.newInstance(Xmlcep.class);
			Unmarshaller jaxbUnmarsheller = jaxbContext.createUnmarshaller();
			Xmlcep xmlcep = (Xmlcep) jaxbUnmarsheller.unmarshal(bufferedReader);
			for (Endereco endereco : xmlcep.getEnderecos().getEndereco()) {
				System.out.println(endereco.getBairro() + "\n");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
