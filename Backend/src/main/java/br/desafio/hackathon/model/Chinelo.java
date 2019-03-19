package br.desafio.hackathon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Chinelo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SQ_CH_NU", sequenceName = "SQ_CH_NU", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CH_NU")
	@Column(name = "CH_NU")
	private Long id;

	@Column(name = "CH_MODE")
	private String modelo;
	
	@Column(name = "CH_COR")
	private String cor;

	@Column(name = "CH_TAMANHO")
	private Integer tamanho;

	@ManyToOne
	@com.fasterxml.jackson.annotation.JsonIgnore
	@JoinColumn(name = "HO_NU", referencedColumnName = "HO_NU")
	private Home home;
	
	public Chinelo() {
		super();
	}

	public Chinelo(String modelo, Integer tamanho) {
		super();
		this.modelo = modelo;
		this.tamanho = tamanho;
		this.cor = cor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chinelo other = (Chinelo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}