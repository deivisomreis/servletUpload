package com.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import com.agenda.model.Contato;

public class ContatoDAO implements DAO<Contato>{
	
	private static List<Contato> repositorio;
	
	public ContatoDAO() {
		if(repositorio == null)
			repositorio = new ArrayList<Contato>();
	}

	@Override
	public void insert(Contato t) {
		repositorio.add(t);		
	}

	@Override
	public void remove(Integer id) {
		repositorio.remove(id);	
	}

	@Override
	public void update(Integer id, Contato t) {
		Contato c = repositorio.get(id);
		
		if(c != null){
			c.setDataNasc(t.getDataNasc());
			c.setEmail(t.getEmail());
			c.setNome(t.getNome());
			c.setNumeros(t.getNumeros());
			c.setObservacao(t.getObservacao());
			
			repositorio.set(id, c); //
		}
	}

	@Override
	public Contato getObject(Integer id) {
		return repositorio.get(id);
	}

	@Override
	public List<Contato> list() {
		return repositorio;
	}

}
