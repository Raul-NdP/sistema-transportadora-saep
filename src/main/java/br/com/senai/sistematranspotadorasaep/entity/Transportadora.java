package br.com.senai.sistematranspotadorasaep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "transportadoras")
@Entity(name = "Transportadora")
public class Transportadora {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Column(name = "nome")
	private String nome;
	
	@Transient
	public boolean isPersistido() {
		return getId() != null && getId() > 0;
	}
	
}
