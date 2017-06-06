/**
 * 
 */
package br.unp.web.revisao_de_acessos.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author Alisson Nascimento
 *
 */
@Entity
@Table(name = "setor")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Setor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_setor")
    private Long id;
    
    @NotBlank(message = "O nome do setor é um campo obrigatório")
    @Size(max = 100, message = "O tamanho do nome do setor deve estar entre 1 e 100")
    private String nome;
    
    @OneToMany(mappedBy="setor", fetch=FetchType.EAGER)
    private List<Aprovador> aprovadores;

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

	public List<Aprovador> getAprovadores() {
		return aprovadores;
	}

	public void setAprovadores(List<Aprovador> aprovadores) {
		this.aprovadores = aprovadores;
	}
	
}
