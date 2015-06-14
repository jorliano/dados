package br.com.jortec.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.jortec.model.Cliente;

@Transactional
@Repository
public class ClienteDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Cliente cliente) {       		
			manager.persist(manager.merge(cliente));						
	}
	
	public void deletar(Cliente c) {
		manager.remove(manager.merge(c));
		
	}

	//Para instalação adm
	public List<Cliente> listar(){	
		
		String consulta = "select c from Cliente c ";		
		TypedQuery<Cliente> query = manager.createQuery(consulta, Cliente.class);			
		return query.getResultList();
	}



	
    
	

}
