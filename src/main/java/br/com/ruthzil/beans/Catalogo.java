package br.com.ruthzil.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catalogo")
public class Catalogo {
		
		@Column(name="idCatalogo")
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int idCatalogo;
		
		@Column(name="nome", length = 255)
		private String nome;
		
		@Column(name="descricao", length = 255)
		private String descricao;
		
		@Column(name="categoria", length = 100)
		private String categoria;
		
		@Column(name="path", length = 255)
		private String path;
		
		

		@Override
		public String toString() {
			return "Catalogo [idCatalogo=" + idCatalogo + ", nome=" + nome + ", descricao=" + descricao + ", categoria="
					+ categoria + ", path=" + path + ", getIdCatalogo()=" + getIdCatalogo() + ", getNome()=" + getNome()
					+ ", getDescricao()=" + getDescricao() + ", getCat()=" + getCat() + ", getPath()=" + getPath()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}

		public Catalogo(int idCatalogo, String nome, String descricao, String categoria, String path) {
			super();
			this.idCatalogo = idCatalogo;
			this.nome = nome;
			this.descricao = descricao;
			this.categoria = categoria;
			this.path = path;
		}
		
		public Catalogo() {
			
		}

		public int getIdCatalogo() {
			return idCatalogo;
		}

		public void setIdCatalogo(int idCatalogo) {
			this.idCatalogo = idCatalogo;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getCat() {
			return categoria;
		}

		public void setCat(String cat) {
			this.categoria = cat;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
		
		
		

}