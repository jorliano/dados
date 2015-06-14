package br.com.jortec.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jortec.dao.ClienteDao;
import br.com.jortec.model.Cliente;
import br.com.jortec.service.ArquivoJson;
import br.com.jortec.util.Alerta;



@Controller
@Scope("request")
public class ClienteBean implements Serializable{
 
	
Cliente cliente = new Cliente();
List<Cliente> lista = new ArrayList<Cliente>();

  
 @Autowired
 ClienteDao dao;
  
 @Autowired
 Alerta alerta;
 
 @Autowired
 ArquivoJson json;
 
  public void salvar(){	  	 			  
		  dao.salvar(cliente);  		  		  
		  this.cliente = new Cliente();			 
		  alerta.info("local salvo com sucesso");
		  criarJson();
  } 
  
  public void deletar(){
	  Cliente c = new Cliente();
	  c = (Cliente) json.carregarArquivoJson("/home/jorliano/Downloads/saida.json");
	  dao.deletar(c);
	  criarJson();
  }
 
  public void criarJson(){
		lista = dao.listar();  
		json.criarArquivo(lista);
  }


public Cliente getCliente() {
	return cliente;
}


public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

 
 
  
}
