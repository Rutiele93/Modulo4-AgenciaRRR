package br.com.crud.model;
import java.util.Date;

public class Reservas {

		private int idReserva, quantReservada;
	    private Date dataReserva;
	    private String pagamento, statusPedido;
	    private double precoTotal;
	    private Destino destino;
	    private Cliente cliente;
	    
	    
		public Destino getDestino() {
			return destino;
		}

		public void setDestino(Destino destino) {
			this.destino = destino;
		}

		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Reservas() {
			
		}

		
		public int getQuantReservada() {
			return quantReservada;
		}


		public void setQuantReservada(int quantReservada) {
			this.quantReservada = quantReservada;
		}

		
		public int getIdReserva() {
			return idReserva;
		}


		public void setIdReserva(int idReserva) {
			this.idReserva = idReserva;
		}


		public Date getDataReserva() {
			return dataReserva;
		}


		public void setDataReserva(Date dataReserva) {
			this.dataReserva = dataReserva;
		}


		public String getPagamento() {
	        return pagamento;
	    }
	    
	      
	    public String getStatusPedido() {
	    	return statusPedido;
	    }
	    
	    public void setStatusPedido(String statusPedido) {
	    	this.statusPedido = statusPedido;
	    }
	    

	    public void setPagamento(String pagamento) {
	        this.pagamento = pagamento;
	    }


		public double getPrecoTotal() {
			return precoTotal;
		}


		public void setPrecoTotal(double precoTotal) {
			this.precoTotal = precoTotal;
		}
	    
	    
	}

