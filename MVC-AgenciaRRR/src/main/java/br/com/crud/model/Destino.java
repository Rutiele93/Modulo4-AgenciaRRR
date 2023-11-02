package br.com.crud.model;

import java.sql.Date;

public class Destino {
	    
	    private int idDestino;
	    private String nomeDestino, categoriaDestino, condicao;
	    private double precoUnit;
	    private int qtdDisponivel;
	    private Date dataIda;
	    private String horaIda;
	    private Date dataChegada;
	    private String horaChegada;	    
	    
		public Destino(int idDestino, String nomeDestino, String categoriaDestino, String condicao, double precoUnit,
				int qtdDisponivel, Date dataIda, String horaIda, Date dataChegada, String horaChegada) {
			super();
			this.idDestino = idDestino;
			this.nomeDestino = nomeDestino;
			this.categoriaDestino = categoriaDestino;
			this.condicao = condicao;
			this.precoUnit = precoUnit;
			this.qtdDisponivel = qtdDisponivel;
			this.dataIda = dataIda;
			this.horaIda = horaIda;
			this.dataChegada = dataChegada;
			this.horaChegada = horaChegada;
		}
		
		public Destino() {
			
		}

		public int getIdDestino() {
			return idDestino;
		}
		public void setIdDestino(int idDestino) {
			this.idDestino = idDestino;
		}
		public String getNomeDestino() {
			return nomeDestino;
		}
		public void setNomeDestino(String nomeDestino) {
			this.nomeDestino = nomeDestino;
		}
		public String getCategoriaDestino() {
			return categoriaDestino;
		}
		public void setCategoriaDestino(String categoriaDestino) {
			this.categoriaDestino = categoriaDestino;
		}
		public String getCondicao() {
			return condicao;
		}
		public void setCondicao(String condicao) {
			this.condicao = condicao;
		}
		public double getPrecoUnit() {
			return precoUnit;
		}
		public void setPrecoUnit(double precoUnit) {
			this.precoUnit = precoUnit;
		}
		public int getQtdDisponivel() {
			return qtdDisponivel;
		}
		public void setQtdDisponivel(int qtdDisponivel) {
			this.qtdDisponivel = qtdDisponivel;
		}
		public Date getDataIda() {
			return dataIda;
		}
		public void setDataIda(Date dataIda) {
			this.dataIda = dataIda;
		}
		public String getHoraIda() {
			return horaIda;
		}
		public void setHoraIda(String horaIda) {
			this.horaIda = horaIda;
		}
		public Date getDataChegada() {
			return dataChegada;
		}
		public void setDataChegada(Date dataChegada) {
			this.dataChegada = dataChegada;
		}
		public String getHoraChegada() {
			return horaChegada;
		}
		public void setHoraChegada(String horaChegada) {
			this.horaChegada = horaChegada;
		}
	    
	    
	    

	}
