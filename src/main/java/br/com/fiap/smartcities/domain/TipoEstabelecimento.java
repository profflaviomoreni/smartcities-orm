package br.com.fiap.smartcities.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_tipo_estabelecimento")
public class TipoEstabelecimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_estabelecimento")
	private Integer id;

	@Column(name = "nome_tipo_estabelecimento", length=25, nullable=false)
	private String nome;

	@OneToMany(mappedBy = "tipo")
	private Collection<Estabelecimento> estabelecimentos;
	   
	
	public TipoEstabelecimento() {
		super();
	}

	public TipoEstabelecimento(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "TipoEstabelecimento [id=" + id + ", nome=" + nome + "]";
	}

}
	


