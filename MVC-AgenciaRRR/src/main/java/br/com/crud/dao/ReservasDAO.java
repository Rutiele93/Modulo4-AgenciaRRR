package br.com.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.model.Cliente;
import br.com.crud.model.ConnectionFactory;
import br.com.crud.model.Destino;
import br.com.crud.model.Reservas;

public class ReservasDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	public void save(Reservas reservas) {

		String sql = "INSERT INTO reservas(dataReserva, idCliente, idDestino, quantReservada, precoTotal,statusPedido, pagamento)"
				+ "VALUES(?,?,?,?,?,?,?)";

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new Date(reservas.getDataReserva().getTime()));
			pstm.setInt(2, reservas.getCliente().getIdCliente());
			pstm.setInt(3, reservas.getDestino().getIdDestino());
			pstm.setInt(4, reservas.getQuantReservada());
			pstm.setDouble(5, reservas.getPrecoTotal());
			pstm.setString(6,reservas.getStatusPedido());
			pstm.setString(7,reservas.getPagamento()); 
				
			pstm.execute();
			System.out.println("Reserva salva com sucesso!");

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {


			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {
		String sql = "DELETE FROM reservas WHERE idReserva = ?";

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
		
			pstm.execute();
			System.out.println("Pedido excluído com sucesso!");

		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	
	public void update(Reservas pedido) {		
		
		String sql = "UPDATE reservas SET precoTotal = ?, pagamento = ?, statusPedido = ?, "
				+ "quantReservada = ? WHERE idReserva = ?";
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
						
			pstm.setDouble(1, pedido.getPrecoTotal());
			pstm.setString(2, pedido.getPagamento());
			pstm.setString(3, pedido.getStatusPedido());			
			pstm.setInt(4, pedido.getQuantReservada());
			
			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(5, pedido.getIdReserva());
			
			pstm.execute();
			System.out.println("RESERVA atualizado com sucesso!");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Reservas> getPedidos() { //esse comando mostra dados de todas as tabelas do projeto
		String sql = "select * from reservas r, clientes c, destino d where r.idCliente = c.idCliente and r.idDestino = d.idDestino";

		List<Reservas> pedidos = new ArrayList<Reservas>();
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Reservas pedido = new Reservas();
				Cliente clientes = new Cliente();
				Destino destinos = new Destino();
				
				pedido.setIdReserva(rset.getInt("idReserva"));
				pedido.setDataReserva(rset.getDate("dataReserva"));
				clientes.setIdCliente(rset.getInt("idCliente"));
				clientes.setNomeCliente(rset.getString("nomeCliente"));
				clientes.setCpf(rset.getString("cpf"));
				clientes.setDataNascimento(rset.getDate("dataNascimento"));
				clientes.setEmail(rset.getString("email"));
				clientes.setTelefone(rset.getString("telefone"));
				clientes.setSenha(rset.getString("senha"));	
				
				pedido.setCliente(clientes);
				destinos.setIdDestino(rset.getInt("idDestino"));
				destinos.setNomeDestino(rset.getString("nomeDestino"));
				destinos.setPrecoUnit(rset.getDouble("precoUnit"));
				destinos.setCategoriaDestino(rset.getString("categoriaDestino"));				
				destinos.setQtdDisponivel(rset.getInt("qtdDisponivel"));				
				destinos.setCondicao(rset.getString("condicao"));
				destinos.setDataIda(rset.getDate("dataIda"));
				destinos.setHoraIda(rset.getString("horaIda"));
				destinos.setDataChegada(rset.getDate("dataChegada"));
				destinos.setHoraChegada(rset.getString("horaChegada"));
				pedido.setDestino(destinos);
				
				pedido.setQuantReservada(rset.getInt("quantReservada"));
				pedido.setPrecoTotal(rset.getDouble("precoTotal"));				
				pedido.setStatusPedido(rset.getString("statusPedido"));
				pedido.setPagamento(rset.getString("pagamento"));
				
				
				pedidos.add(pedido);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pedidos;
	}

	
	public Reservas getPedidoById(int idReserva) {

		String sql = "SELECT * FROM reservas where idReserva = ?";
		
		Reservas reservas = new Reservas();
		Cliente clientes = new Cliente();
		Destino destinos = new Destino();

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idReserva);
			rset = pstm.executeQuery();

			rset.next();	
			clientes.setIdCliente(rset.getInt("idCliente"));
			clientes.setNomeCliente(rset.getString("nomeCliente"));
			clientes.setCpf(rset.getString("cpf"));
			clientes.setDataNascimento(rset.getDate("dataNascimento"));
			clientes.setEmail(rset.getString("email"));
			clientes.setTelefone(rset.getString("telefone"));
			clientes.setSenha(rset.getString("senha"));				
			reservas.setCliente(clientes);
			
			destinos.setIdDestino(rset.getInt("idDestino"));
			destinos.setNomeDestino(rset.getString("nomeDestino"));
			destinos.setPrecoUnit(rset.getDouble("precoUnit"));
			destinos.setCategoriaDestino(rset.getString("categoriaDestino"));				
			destinos.setQtdDisponivel(rset.getInt("qtdDisponivel"));				
			destinos.setCondicao(rset.getString("condicao"));
			destinos.setDataIda(rset.getDate("dataIda"));
			destinos.setHoraIda(rset.getString("horaIda"));
			destinos.setDataChegada(rset.getDate("dataChegada"));
			destinos.setHoraChegada(rset.getString("horaChegada"));			
			reservas.setDestino(destinos);
			
			reservas.setDataReserva(rset.getDate("dataReserva"));
			reservas.setQuantReservada(rset.getInt("quantReservada"));
			reservas.setPrecoTotal(rset.getDouble("precoTotal"));				
			reservas.setStatusPedido(rset.getString("statusPedido"));
			reservas.setPagamento(rset.getString("pagamento"));

			reservas.setIdReserva(rset.getInt("idReserva"));	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reservas;
  
    }
	public Reservas getReservasById(int idReserva) {

		String sql = "SELECT * FROM reservas where idReserva = ?";
		
		Reservas reservas = new Reservas();

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idReserva);
			rset = pstm.executeQuery();

			rset.next();	
	
			reservas.setDataReserva(rset.getDate("dataReserva"));
			reservas.setQuantReservada(rset.getInt("quantReservada"));
			reservas.setPrecoTotal(rset.getDouble("precoTotal"));				
			reservas.setStatusPedido(rset.getString("statusPedido"));
			reservas.setPagamento(rset.getString("pagamento"));

			reservas.setIdReserva(rset.getInt("idReserva"));	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reservas;
  
    }

}


