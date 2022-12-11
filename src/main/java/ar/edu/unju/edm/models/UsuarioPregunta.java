package ar.edu.unju.edm.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class UsuarioPregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuarioPregunta;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	private Usuario usuario;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPregunta")
	private Pregunta pregunta;
	
	public UsuarioPregunta() {
		// TODO Auto-generated constructor stub
	}
	public int getIdUsuarioPregunta() {
		return idUsuarioPregunta;
	}
	public void setIdUsuarioPregunta(int idUsuarioPregunta) {
		this.idUsuarioPregunta = idUsuarioPregunta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	
	
}
