package br.com.personalPrpject.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import br.com.personalPrpject.jaxb.Xmlcep;
import br.com.personalPrpject.model.EnderecoDozer;
import br.com.personalPrpject.model.EnderecoDozer.Enderecos;
import br.com.personalPrpject.service.EnderecoService;
import br.com.personalPrpject.util.Utils;

/**
 * 
 * @author alersonr
 *
 */
public class EnderecoServiceImpl implements EnderecoService {

	public Enderecos chamarWebService(String uf, String localidade, String logradouro) {
		Enderecos listaEnderecoDozerMapper = null;
		String localidadeSemCaraterEspecial = Utils.retiraCaracteresEspeciais(localidade);
		String logradouroSemCaracterEspecial = Utils.retiraCaracteresEspeciais(logradouro);
		try {
			String URLWEBSERIVE = "http://viacep.com.br/ws/" + uf + "/" + localidadeSemCaraterEspecial + "/"
					+ logradouroSemCaracterEspecial + "/xml/";
			URL url = new URL(URLWEBSERIVE);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			JAXBContext jaxbContext = JAXBContext.newInstance(Xmlcep.class);
			Unmarshaller jaxbUnmarsheller = jaxbContext.createUnmarshaller();
			Xmlcep xmlcep = (Xmlcep) jaxbUnmarsheller.unmarshal(bufferedReader);
			listaEnderecoDozerMapper = dozerMapper(xmlcep);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaEnderecoDozerMapper;
	}

	private Enderecos dozerMapper(Xmlcep xmlcep) {
		List<String> configurationDozerMaper = new ArrayList<String>();
		configurationDozerMaper.add("dozerMappingWS.xml");
		Mapper mapper = new DozerBeanMapper(configurationDozerMaper);
		EnderecoDozer.Enderecos enderecoDozer = (EnderecoDozer.Enderecos) mapper.map(xmlcep.getEnderecos(), EnderecoDozer.Enderecos.class, "caseA");
		return enderecoDozer;
	}

}
