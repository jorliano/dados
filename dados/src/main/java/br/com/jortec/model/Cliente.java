package br.com.jortec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente  implements Serializable                                                                                                                                                                                          {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id;
	
   
	
	@Column(name= "local")
	private String Local;
	
	@Column(name= "longitude")
	private String Longitude;
	
	@Column(name= "latitude")
	private String Latitude;
	
	@Column(name= "endereco")
	private String endereco;
	
	@Column(name= "cidade")
	private String Cidade;
	
	@Column(name= "bairro")
	private String Bairro;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocal() {
		return Local;
	}

	public void setLocal(String local) {
		Local = local;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	
	
	
}
