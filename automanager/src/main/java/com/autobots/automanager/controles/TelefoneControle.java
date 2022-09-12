package com.autobots.automanager.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.modelo.TelefoneAtualizador;
import com.autobots.automanager.repositorios.TelefoneRespositorio;



@RestController
@RequestMapping("/telefone")
public class TelefoneControle {
	@Autowired
	private TelefoneRespositorio repositorio;
	
	@GetMapping("/telefone{id}")
	public Telefone obterTelefoneId (@PathVariable Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	@GetMapping("/telefones")
	public java.util.List<Telefone> obterTelefone(){
		java.util.List<Telefone>telefones = repositorio.findAll();
		return telefones;
	}
	
	@PostMapping("/cadastrar")
	public void cadastrarTelefone(@RequestBody Telefone telefone) {
		repositorio.save(telefone);
	}
	
	@PutMapping("/atualizar")
	public void atualizarTelefone(@RequestBody Telefone atualizacao) {
		Telefone telefone = repositorio.getById(atualizacao.getId());
		TelefoneAtualizador atualizador = new TelefoneAtualizador();
		atualizador.atualizar(telefone, atualizacao);
		repositorio.save(telefone);
	}
	
	@DeleteMapping("/excluir")
	private void excluirTelefone(@RequestBody Telefone exclusao) {
		Telefone telefone = repositorio.getById(exclusao.getId());
		repositorio.delete(telefone);
	}
	
	
			
}
		
		
		


