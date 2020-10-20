package com.uam.desafio;

import com.google.gson.Gson;
import com.uam.desafio.domain.Cliente;
import com.uam.desafio.repositories.ClienteRepository;
import com.uam.desafio.repositories.EmpresaRepository;
import com.uam.desafio.repositories.EnderecoRepository;
import com.uam.desafio.repositories.GeolocalizacaoRepository;
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

	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
