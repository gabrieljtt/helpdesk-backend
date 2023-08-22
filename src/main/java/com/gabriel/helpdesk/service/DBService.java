package com.gabriel.helpdesk.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gabriel.helpdesk.domain.Chamado;
import com.gabriel.helpdesk.domain.Cliente;
import com.gabriel.helpdesk.domain.Tecnico;
import com.gabriel.helpdesk.domain.enums.Perfil;
import com.gabriel.helpdesk.domain.enums.Prioridade;
import com.gabriel.helpdesk.domain.enums.Status;
import com.gabriel.helpdesk.repositories.ChamadoRepository;
import com.gabriel.helpdesk.repositories.ClienteRepository;
import com.gabriel.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		
		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "431.131.740-90", "valdir@mail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Gabriel Turatti", "250.795.940-12", "gabriel@mail.com", encoder.encode("123"));
		tec2.addPerfil(Perfil.ADMIN);
		Tecnico tec3 = new Tecnico(null, "Carlos Eduardo", "466.317.430-28", "eduardo@mail.com", encoder.encode("123"));
		tec3.addPerfil(Perfil.ADMIN); 
		Tecnico tec4 = new Tecnico(null, "João Sousa", "757.632.180-60", "joao@mail.com", encoder.encode("123"));
		tec4.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "896.696.110-08", "torvalds@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Alberto Nogueira", "169.102.580-10", "nogueira@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Vinicius Sousa", "919.143.850-04", "vinicius@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Guilherme Felipe", "987.218.270-10", "guilherme@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Fabio Motta", "926.998.990-97", "motta@mail.com", encoder.encode("123"));
		Cliente cli6 = new Cliente(null, "Tobias Karyl", "652.289.620-69", "karyl@mail.com", encoder.encode("123"));
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.BAIXA, Status.FECHADO, "Chamado 02", "Segundo chamado", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 03", "Terceiro chamado", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.MEDIA, Status.FECHADO, "Chamado 04", "Quarto chamado", tec1, cli4);
		Chamado c5 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 05", "Quinto chamado", tec2, cli5);
		Chamado c6 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamado 06", "Sexto chamado", tec3, cli6);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5, cli6));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}

}
