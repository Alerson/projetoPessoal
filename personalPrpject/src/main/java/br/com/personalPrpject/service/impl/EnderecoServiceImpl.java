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
		uf = retiraCaracteresEspeciais(uf);
		localidade = retiraCaracteresEspeciais(localidade);
		logradouro = retiraCaracteresEspeciais(logradouro);
		try {
			String URLWEBSERIVE = "http://viacep.com.br/ws/" + uf + "/" + localidade + "/" + logradouro + "/xml/";
			URL url = new URL(URLWEBSERIVE);
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

	public static String retiraCaracteresEspeciais(String stringFonte) {
		String passa = stringFonte;
		passa = passa.replaceAll("[ÂÀÁÄÃ]", "A");
		passa = passa.replaceAll("[âãàáä]", "a");
		passa = passa.replaceAll("[ÊÈÉË]", "E");
		passa = passa.replaceAll("[êèéë]", "e");
		passa = passa.replaceAll("ÎÍÌÏ", "I");
		passa = passa.replaceAll("îíìï", "i");
		passa = passa.replaceAll("[ÔÕÒÓÖ]", "O");
		passa = passa.replaceAll("[ôõòóö]", "o");
		passa = passa.replaceAll("[ÛÙÚÜ]", "U");
		passa = passa.replaceAll("[ûúùü]", "u");
		passa = passa.replaceAll("Ç", "C");
		passa = passa.replaceAll("ç", "c");
		/*passa = passa.replaceAll("[ýÿ]", "y");
		passa = passa.replaceAll("Ý", "Y");
		passa = passa.replaceAll("ñ", "n");
		passa = passa.replaceAll("Ñ", "N");
		passa = passa.replaceAll("[-+=*&amp;%$#@!_]", "");
		passa = passa.replaceAll("['\"]", "");
		passa = passa.replaceAll("[<>()\\{\\}]", "");
		passa = passa.replaceAll("['\\\\.,()|/]", "");
		passa = passa.replaceAll("[^!-ÿ]{1}[^ -ÿ]{0,}[^!-ÿ]{1}|[^!-ÿ]{1}", " ");*/
		return passa;
	}

}
