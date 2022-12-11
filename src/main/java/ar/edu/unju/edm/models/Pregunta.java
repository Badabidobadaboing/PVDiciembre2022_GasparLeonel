package ar.edu.unju.edm.models;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Entity
public class Pregunta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int codPregunta;
	@NotEmpty(message = "El nombre del enunciado no puede estar en vacio")
	private String enunciado;
	@NotEmpty(message = "El tipo de nivel no puede estar en vacio")
	private String nivel;
	private String opcion01;
	private String opcion02;
	private String opcion03;
	private String opcion04;
	@Column (name = "opcion_correcta")
	private int opcionCorrecta;
	private Integer puntaje;
	
	public Pregunta() {
		// TODO Auto-generated constructor stub
	}

	public int getCodPregunta() {
		return codPregunta;
	}

	public void setCodPregunta(int codPregunta) {
		this.codPregunta = codPregunta;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getOpcion01() {
		return opcion01;
	}

	public void setOpcion01(String opcion01) {
		this.opcion01 = opcion01;
	}

	public String getOpcion02() {
		return opcion02;
	}

	public void setOpcion02(String opcion02) {
		this.opcion02 = opcion02;
	}

	public String getOpcion03() {
		return opcion03;
	}

	public void setOpcion03(String opcion03) {
		this.opcion03 = opcion03;
	}

	public String getOpcion04() {
		return opcion04;
	}

	public void setOpcion04(String opcion04) {
		this.opcion04 = opcion04;
	}

	public int getOpcionCorrecta() {
		return opcionCorrecta;
	}

	public void setOpcionCorrecta(int opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}

	public Integer getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Integer puntaje) {
		this.puntaje = puntaje;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
