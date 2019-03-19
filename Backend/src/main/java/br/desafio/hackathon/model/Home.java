package br.desafio.hackathon.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.beans.factory.annotation.Autowired;

import br.desafio.hackathon.enums.SituacaoEnum;
import br.desafio.hackathon.repository.HomeRepository;

@Entity
public class Home implements Serializable{
		
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "SQ_HO_NU", sequenceName = "SQ_HO_NU", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_HO_NU")
	@Column(name = "HO_NU")
	private Long id;
	
	@Column(name="HO_NO")
	private String nome;
	
	@Column(name="HO_LI")
	private Integer limite;
		
	@Column(name = "DN_SIT")
	@Enumerated(EnumType.STRING)
	private SituacaoEnum situacao;
	
	@OneToMany(mappedBy="home", cascade=CascadeType.REMOVE)
	private List<Chinelo> chinelos;
	
	public Home() {
		super();
	}
	
	public Home(Long id, String nome, SituacaoEnum situacao) {
		super();
		this.id=id;
		this.nome=nome;
		this.situacao=situacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getLimite() {
		return limite;
	}

	public void setLimite(Integer limite) {
		this.limite = limite;
	}

	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}

	public List<Chinelo> getChinelos() {
		return chinelos;
	}

	public void setChinelos(List<Chinelo> chinelos) {
		this.chinelos = chinelos;
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
		Home other = (Home) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
