package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.crud.dao.ClienteDAO;
import br.com.crud.dao.DestinoDAO;
import br.com.crud.dao.ReservasDAO;
import br.com.crud.model.Cliente;
import br.com.crud.model.Destino;
import br.com.crud.model.Reservas;

@WebServlet(urlPatterns = { "/reserva", "/inserir-reserva", "/criar-reserva", "/excluir-reserva", "/editar-reserva" ,"/atualizar-reserva"})
public class ControllerReserva extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	ReservasDAO reservasDAO = new ReservasDAO();
	DestinoDAO destinoDAO = new DestinoDAO();
	ClienteDAO clienteDAO = new ClienteDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/reserva": //rota exibirReserva.jsp
			listaReserva(request, response);
			break; //ok
		case "/inserir-reserva":  // retorna para rota reserva --> exibirReserva.jps
			inserir(request, response);			
			break;
		case "/criar-reserva": // rota para reserva.jsp
			listaCriar(request, response);
			break;			
		case "/excluir-reserva": // retorna para rota reserva --> exibirReserva.jsp
			deletar(request, response);
			break;
		case "/editar-reserva": // rota EditarReserva.jsp
			editar(request, response);
			break;
		case "/atualizar-reserva": // retorna para rota reserva --> exibirReserva.jsp
			alterar(request, response);
			break;
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

// retorana rota reserva ---> /inserir-reserva
	protected void inserir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebendo os dados do formulario via parametro

		int idCliente = Integer.parseInt(request.getParameter("cliente"));
		Cliente cliente = clienteDAO.getClienteById(idCliente);
		int idDestino = Integer.parseInt(request.getParameter("destino"));
		Destino destino = destinoDAO.getDestinoById(idDestino);
		int quantReservada = Integer.parseInt(request.getParameter("quantReservada"));
		double precoTotal = Double.parseDouble(request.getParameter("precoTotal"));
		String pagamento = request.getParameter("pagamento");
		String statusPedido = request.getParameter("statusPedido");

		// criando o objeto reserva
		Reservas reservas = new Reservas();

		reservas.setQuantReservada(quantReservada);
		reservas.setDataReserva(new Date());
		reservas.setPrecoTotal(precoTotal);
		reservas.setPagamento(pagamento);
		reservas.setStatusPedido(statusPedido);
		reservas.setCliente(cliente);
		reservas.setDestino(destino);

		reservasDAO.save(reservas);
		response.sendRedirect("reserva");

	}

// responde pela rota criar-reserva
	protected void listaCriar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Reservas> pedidos = new ArrayList<Reservas>();
		ReservasDAO rdao = new ReservasDAO();
		pedidos = rdao.getPedidos();
		req.setAttribute("listaReservas", pedidos);
		ClienteDAO cdao = new ClienteDAO();
		List<Cliente> clientes = cdao.getClientes();
		req.setAttribute("listaClientes", clientes);
		DestinoDAO ddao = new DestinoDAO();
		List<Destino> destinos = ddao.getDestinos();
		req.setAttribute("listaDestinos", destinos);

		RequestDispatcher dispatcher = req.getRequestDispatcher("./views/Reserva.jsp");
		dispatcher.forward(req, resp);
	}

	// retorna a rota exibirReserva atraves da reta reserva
	protected void listaReserva(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Reservas> pedidos = new ArrayList<Reservas>();
		ReservasDAO rdao = new ReservasDAO();
		pedidos = rdao.getPedidos();
		req.setAttribute("listaReservas", pedidos);

		RequestDispatcher dispatcher = req.getRequestDispatcher("./views/exibirReserva.jsp");
		dispatcher.forward(req, resp);
	}

	protected void deletar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idReserva = Integer.parseInt(req.getParameter("idReserva"));
		ReservasDAO rdao = new ReservasDAO();

		rdao.removeById(idReserva);
		resp.sendRedirect("reserva");
	}

//	protected void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		int idReserva = Integer.parseInt(req.getParameter("idReserva"));
//		ReservasDAO rdao = new ReservasDAO();
//		Reservas ReservaSelecionado = rdao.getReservasById(idReserva);
//		req.setAttribute("reservas", ReservaSelecionado);
//		RequestDispatcher rd = req.getRequestDispatcher("./views/EditarReserva.jsp");
//		rd.forward(req, resp);
//	}

	protected void editar(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		int idReserva = Integer.parseInt(req.getParameter("idReserva"));
		ReservasDAO rDAO = new ReservasDAO();
		Reservas ReservaSelecionado = rDAO.getReservasById(idReserva);

		req.setAttribute("reserva", ReservaSelecionado);

		RequestDispatcher rd = req.getRequestDispatcher("./views/EditarReserva.jsp");
		rd.forward(req, resp);
	}
	
	protected void alterar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Reservas reservasAlterado = new Reservas();

		reservasAlterado.setPagamento(req.getParameter("pagamento"));
		reservasAlterado.setQuantReservada(Integer.parseInt(req.getParameter("quantReservada")));
		reservasAlterado.setPrecoTotal(Double.parseDouble(req.getParameter("precoTotal")));
		reservasAlterado.setStatusPedido(req.getParameter("statusPedido"));
		reservasAlterado.setIdReserva(Integer.parseInt(req.getParameter("idReserva")));

		ReservasDAO ra = new ReservasDAO();
		ra.update(reservasAlterado);
		resp.sendRedirect("reserva");
	}

}