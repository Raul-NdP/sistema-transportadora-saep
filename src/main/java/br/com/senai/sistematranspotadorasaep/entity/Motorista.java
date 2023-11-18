package br.com.senai.sistematranspotadorasaep.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "motoristas")
@Entity(name = "Motorista")
public class Motorista {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Column(name = "nome")
	private String nome;
	
	@NotBlank(message = "A cnh é obrigatória")
	@Column(name = "cnh")
	private String cnh;
	
	@NotNull(message = "A transportadora é obrigatória")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_transportadora")
	private Transportadora transportadora;
	
	@Transient
	public boolean isPersistido() {
		return getId() != null && getId() > 0;
	}
	
}
