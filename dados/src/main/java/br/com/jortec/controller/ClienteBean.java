package br.com.jortec.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialResponseWriter;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.jortec.dao.ClienteDao;
import br.com.jortec.model.Cliente;
import br.com.jortec.service.ArquivoJson;
import br.com.jortec.util.Alerta;



@ManagedBean
public class ClienteBean implements Serializable{
 
	
Cliente cliente = new Cliente();
List<Cliente> lista = new ArrayList<Cliente>();
private Part foto;
  
 @ManagedProperty("#{clienteDao}")
 ClienteDao dao ;

 Alerta alerta = new Alerta();
 

 ArquivoJson json = new ArquivoJson();
 
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

public Part getFoto() {
	return foto;
}

public void setFoto(Part foto) {
	this.foto = foto;
}

public void setDao(ClienteDao dao) {
	this.dao = dao;
} 
 
  
}
