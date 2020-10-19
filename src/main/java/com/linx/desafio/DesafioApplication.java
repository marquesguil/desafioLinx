package com.linx.desafio;

import com.google.gson.Gson;
import com.linx.desafio.domain.Cliente;
import com.linx.desafio.repositories.ClienteRepository;
import com.linx.desafio.repositories.EmpresaRepository;
import com.linx.desafio.repositories.EnderecoRepository;
import com.linx.desafio.repositories.GeolocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private GeolocalizacaoRepository geolocalizacaoRepository;


	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String urlToRead = "http://jsonplaceholder.typicode.com/users";

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
		Cliente[] c = gson.fromJson(String.valueOf(result), Cliente[].class);

		List<Cliente> clientes = Arrays.asList(c);

		clienteRepository.saveAll(clientes);

	}
}
