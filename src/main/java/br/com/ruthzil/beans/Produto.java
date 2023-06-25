package br.com.ruthzil.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Column(name = "idProd")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProd;

	@Column(name = "prod_codigo", length = 255)
	private String prod_codigo;

	@Column(name = "prod_codigo_ori", length = 255)
	private String prod_codigo_ori;

	@Column(name = "prod_linha_fabricacao", length = 255)
	private String prod_linha_fabricacao;

	@Column(name = "prod_pc_jg", length = 255)
	private String prod_pc_jg;

	@Column(name = "prod_peso", length = 255)
	private String prod_peso;

	@Column(name = "prod_preco", length = 255)
	private String prod_preco;

	@Column(name = "prod_data_da_alteracao", length = 255)
	private String prod_data_da_alteracao;

	@Column(name = "prod_classificacao", length = 255)
	private String prod_classificacao;

	@Column(name = "prod_aplicacao_modelo", length = 255)
	private String prod_aplicacao_modelo;

	@Column(name = "prod_quant_maquina", length = 255)
	private String prod_quant_maquina;

	@Column(name = "prod_observacao_1", length = 255)
	private String prod_observacao_1;

	@Column(name = "prod_observacao_2", length = 255)
	private String prod_observacao_2;

	@Column(name = "prod_observacao_3", length = 255)
	private String prod_observacao_3;

	@Column(name = "prod_observacao_4", length = 255)
	private String prod_observacao_4;

	@Column(name = "prod_observacao_5", length = 255)
	private String prod_observacao_5;

	@Column(name = "prod_observacao_6", length = 255)
	private String prod_observacao_6;

	@Column(name = "prod_observacao_7", length = 255)
	private String prod_observacao_7;

	@Column(name = "prod_quant_em_estoque", length = 255)
	private String prod_quant_em_estoque;

	@Column(name = "prod_ncm", length = 255)
	private String prod_ncm;

	@Column(name = "nome", length = 255)
	private String nome_prod;

	@Column(name = "prod_descricao", length = 255)
	private String prod_descricao;

	@Column(name = "ncm", length = 20)
	private int ncm;

	@Column(name = "marca", length = 255)
	private String marca;

	@Column(name = "modelo", length = 255)
	private String modelo;

	@Column(name = "categoria", length = 255)
	private String categoria;

}