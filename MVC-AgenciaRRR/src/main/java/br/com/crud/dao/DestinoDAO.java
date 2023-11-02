package br.com.crud.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.crud.model.ConnectionFactory;
import br.com.crud.model.Destino;

public class DestinoDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Destino destino) {		
		String sql = "INSERT INTO destino(nomeDestino, precoUnit, categoriaDestino,"
				+ " qtdDisponivel, condicao, dataIda, horaIda, dataChegada, HoraChegada)" 
				+ " VALUES(?,?,?,?,?,?,?,?,?)";

		try {

			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, destino.getNomeDestino());
			pstm.setDouble(2, destino.getPrecoUnit());
			pstm.setString(3, destino.getCategoriaDestino());
			pstm.setInt(4, destino.getQtdDisponivel());
			pstm.setString(5, destino.getCondicao());
			pstm.setDate(6, new Date(destino.getDataIda().getTime()));
			pstm.setString(7, destino.getHoraIda());
			pstm.setDate(8, new Date(destino.getDataChegada().getTime()));
			pstm.setString(9, destino.getHoraChegada());

			
			pstm.execute();
			System.out.println("Destino adicionado com sucesso!");

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
		String sql = "DELETE FROM destino WHERE idDestino = ?";

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
		
			pstm.execute();
			System.out.println("Destino excluído com sucesso!");

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


	public void update(Destino destino) {	
		
		String sql = "UPDATE destino SET nomeDestino = ?, precoUnit = ?, categoriaDestino = ?, "
				+ "qtdDisponivel = ?, condicao = ?, horaIda = ?, horaChegada = ? WHERE idDestino = ?";
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, destino.getNomeDestino());
			pstm.setDouble(2, destino.getPrecoUnit());
			pstm.setString(3, destino.getCategoriaDestino());
			pstm.setInt(4, destino.getQtdDisponivel());
			pstm.setString(5, destino.getCondicao());
//			pstm.setDate(6, new Date(destino.getDataIda().getTime()));
			pstm.setString(6, destino.getHoraIda());
//			pstm.setDate(8, new Date(destino.getDataChegada().getTime()));
			pstm.setString(7, destino.getHoraChegada());
			// CAMPO QUE SERÁ UTILIZADO PARA BUSCAR O CADASTRO
			pstm.setInt(8, destino.getIdDestino());
			

			pstm.execute();
			System.out.println("Destino atualizado com sucesso!");

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
	

	public List<Destino> getDestinos() {
		String sql = "SELECT * FROM destino";

		List<Destino> destinos = new ArrayList<Destino>();

		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();


			while (rset.next()) {

				Destino destino = new Destino();
				
				destino.setIdDestino(rset.getInt("idDestino"));
				destino.setNomeDestino(rset.getString("nomeDestino"));
				destino.setPrecoUnit(rset.getDouble("precoUnit"));
				destino.setCategoriaDestino(rset.getString("categoriaDestino"));				
				destino.setQtdDisponivel(rset.getInt("qtdDisponivel"));				
				destino.setCondicao(rset.getString("condicao"));
				destino.setDataIda(rset.getDate("dataIda"));
				destino.setHoraIda(rset.getString("horaIda"));
				destino.setDataChegada(rset.getDate("dataChegada"));
				destino.setHoraChegada(rset.getString("horaChegada"));
				
				destinos.add(destino);
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

		return destinos;
	}

	
	public Destino getDestinoById(int idDestino) {

		String sql = "SELECT * FROM destino where idDestino = ?";
		Destino destino = new Destino();

		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idDestino);
			rset = pstm.executeQuery();

			rset.next();

			destino.setIdDestino(rset.getInt("idDestino"));
			destino.setNomeDestino(rset.getString("nomeDestino"));
			destino.setPrecoUnit(rset.getDouble("precoUnit"));
			destino.setCategoriaDestino(rset.getString("categoriaDestino"));
			destino.setQtdDisponivel(rset.getInt("qtdDisponivel"));
			destino.setCondicao(rset.getString("condicao"));
			destino.setDataIda(rset.getDate("dataIda"));
			destino.setHoraIda(rset.getString("horaIda"));
			destino.setDataChegada(rset.getDate("dataChegada"));
			destino.setHoraChegada(rset.getString("horaChegada"));
			
			destino.setIdDestino(rset.getInt("idDestino"));

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
		return destino;
  
    }

	
}
