package br.com.banco.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "TRANSFERENCIA")
@Data @NoArgsConstructor @ AllArgsConstructor
public class Transferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	@Setter(value = AccessLevel.NONE)
	private Long id;
	
	@Getter(value = AccessLevel.NONE)
	@Column(name = "data_transferencia", nullable = false)
	private LocalDate dataTransferencia;
	
	@Column(columnDefinition = "numeric(20, 2)", nullable = false)
	private Double valor;
	
	@Column(length = 15, nullable = false)
	private String tipo;
	
	@Column(name = "nome_operador_transacao", nullable = true, length = 50)
	private String nomeOperadorTransacao;
	
	@ManyToOne
	@JoinColumn(name = "conta_id")
	private Conta conta;

	public String getDataTransferencia() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		return dataTransferencia.format(formatter);
	}
	
	
	
}
