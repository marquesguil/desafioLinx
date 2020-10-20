package com.uam.desafio;

import com.uam.desafio.repositories.ClienteRepository;
import com.uam.desafio.repositories.EmpresaRepository;
import com.uam.desafio.repositories.EnderecoRepository;
import com.uam.desafio.repositories.GeolocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*String urlToRead = "http://jsonplaceholder.typicode.com/users";

		StringBuilder result = new StringBuilder();
		URL url = new URL(urlToRead);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");

		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		rd.close();

		Gson gson = new Gson();

		ClienteNewDTO[] c = gson.fromJson(String.valueOf(result), ClienteNewDTO[].class);
		List<ClienteNewDTO> clientes = Arrays.asList(c);

		for (ClienteNewDTO x: clientes) {
			clienteRepository.saveAll(x);
		}


		/*
		clienteRepository.saveAll(clientes);
/*
		Endereco[] e = gson.fromJson(String.valueOf(result), Endereco[].class);
		List<Endereco> enderecos = Arrays.asList(e);
		enderecoRepository.saveAll(enderecos);

		Geolocalizacao[] g = gson.fromJson(String.valueOf(result), Geolocalizacao[].class);
		List<Geolocalizacao> geos = Arrays.asList(g);
		geolocalizacaoRepository.saveAll(geos);

		Empresa[] emp = gson.fromJson(String.valueOf(result), Empresa[].class);
		List<Empresa> empresas = Arrays.asList(emp);
		empresaRepository.saveAll(empresas);
*/
	}
}
