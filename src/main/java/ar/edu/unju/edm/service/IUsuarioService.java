package ar.edu.unju.edm.service;

import java.util.List;

import ar.edu.unju.edm.models.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public void save(Usuario usuario);
	
	public Usuario findOne(Long dni);
	
	public void delete(Long dni);

}
