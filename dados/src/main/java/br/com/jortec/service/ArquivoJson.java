package br.com.jortec.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import br.com.jortec.model.Cliente;


public class ArquivoJson {
  
	public void criarArquivo(List<Cliente> lista){
		//Cria um Objeto JSON
		
		
				JSONObject jsonObjectWrite = new JSONObject();
				JSONArray jsonArray = new JSONArray();
				
				FileWriter writeFile = null;
				
				//Armazena dados em um Objeto JSON
				for (int i = 0; i < lista.size(); i++) {
					JSONObject jsonObject = new JSONObject();
					
					jsonObject.put("id", lista.get(i).getId());
					jsonObject.put("local", lista.get(i).getLocal());
					jsonObject.put("endereco", lista.get(i).getEndereco());
					jsonObject.put("bairro", lista.get(i).getBairro());
					jsonObject.put("cidade", lista.get(i).getCidade());
					
					//Adicio o objecto em um array  
					jsonArray.add(jsonObject);
				}
				
				jsonObjectWrite.put("lista", jsonArray);
				
				try{
					writeFile = new FileWriter("/C:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps/dados/novo.json");
					//Escreve no arquivo conteudo do Objeto JSON
					writeFile.write(jsonObjectWrite.toJSONString());
					writeFile.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
				
				//Imprimne na Tela o Objeto JSON para vizualização
				System.out.println(jsonObjectWrite);
				
	
			
	}
	public Object carregarArquivoJson(String caminho){
		System.out.println("iniciado");
		JSONObject jsonObject;
		//Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		//Variaveis que irao armazenar os dados do arquivo JSON
		List<Cliente> lista = new ArrayList<Cliente>(); 

		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader(
					caminho));						
			
			Cliente c = new Cliente();
			//Salva nas variaveis os dados retirados do arquivo
			c.setId((long)  jsonObject.get("id"));
			c.setLocal((String) jsonObject.get("local"));
			c.setEndereco( (String) jsonObject.get("endereco"));
			c.setBairro((String) jsonObject.get("bairro"));
			c.setCidade((String) jsonObject.get("cidade"));
         
			
			System.out.printf(
					"Id: %s\nlocal: %s\nEndereco: %s\nBairro: %s\nCidade",
					c.getId(),c.getLocal(), c.getEndereco(),c.getBairro(),c.getCidade());
			return c;
			
		} 
		//Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		 catch (org.json.simple.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return null;

	}	
	public static void main(String[] args) {
		
		System.out.println("novo.json");
	}
}
