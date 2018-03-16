package com.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import com.agenda.model.Usuario;

public class UsuarioDAO  implements DAO<Usuario>{
	
	private static List<Usuario> repositorio;
	
	public UsuarioDAO() {
		if(repositorio == null)
			repositorio = new ArrayList<Usuario>();
	}

	@Override
	public void insert(Usuario t) {
		repositorio.add(t);		
	}

	@Override
	public void remove(Integer id) {
		repositorio.remove(id);
	}

	@Override
	public void update(Integer id, Usuario t) {
		Usuario u = repositorio.get(id);
		
		if(u != null){
			u.setDataNasc(t.getDataNasc());
			u.setEmail(t.getEmail());
			u.setNome(t.getNome());
			u.setNumero(t.getNumero());
			u.setSenha(t.getSenha());
			
			repositorio.set(id, u);
		}
		
	}

	@Override
	public Usuario getObject(Integer id) {
		return repositorio.get(id);
	}

	@Override
	public List<Usuario> list() {
		return repositorio;
	}
	
	public Usuario login(String email, String senha){
		for(Usuario u : repositorio){
			if(u.getEmail().equalsIgnoreCase(email.trim()) && u.getSenha().equalsIgnoreCase(senha.trim()))
				return u;
		}
		
		return null;
	}
}
