package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.crud.dao.DestinoDAO;
import br.com.crud.model.Destino;


@WebServlet(urlPatterns = { "/destino", "/criar-destino", "/editar-destino", "/atualizar-destino", "/excluir-destino"})
public class controllerDestino extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/destino":
			destino(request, response);
			break;
		case "/criar-destino": 
			try {
				inserir(request, response);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/editar-destino":
			editar(request, response);
			break;			
		case "/excluir-destino":
			deletar(request, response);
			break;
		case "/atualizar-destino":
			alterar(request, response);
			break;	
		default:
			response.sendRedirect("index.html");
			break;
		}
	}

	protected void inserir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		// recebendo os dados do formulario via parametro
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String nomeDestino = request.getParameter("nomeDestino");
		String categoriaDestino = request.getParameter("categoriaDestino");
		double precoUnit = Double.parseDouble(request.getParameter("precoUnit"));		
		int qtdDisponivel = Integer.parseInt(request.getParameter("qtdDisponivel"));
		String condicao = request.getParameter("condicao");		
		Date dataIda = new Date(dateFormat.parse(request.getParameter("dataIda")).getTime());
		String horaIda = request.getParameter("horaIda");
		Date dataChegada = new Date(dateFormat.parse(request.getParameter("dataChegada")).getTime());
		String horaChegada = request.getParameter("horaChegada");
		
		Destino destino = new Destino();
			
		destino.setNomeDestino(nomeDestino);
		destino.setPrecoUnit(precoUnit);
		destino.setCategoriaDestino(categoriaDestino);
		destino.setQtdDisponivel(qtdDisponivel);
		destino.setCondicao(condicao);
		destino.setDataIda(dataIda);
		destino.setHoraIda(horaIda);
		destino.setDataChegada(dataChegada);
		destino.setHoraChegada(horaChegada);

		DestinoDAO destinoDAO = new DestinoDAO();
		destinoDAO.save(destino);
		response.sendRedirect("destino");

	}

	protected void destino(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Destino> destinos = new ArrayList<Destino>();
		DestinoDAO dDAO = new DestinoDAO();
		destinos = dDAO.getDestinos();
		req.setAttribute("listaDestinos", destinos);

		RequestDispatcher dispatcher = req.getRequestDispatcher("./views/exibirdestino.jsp");
		dispatcher.forward(req, resp);
	}

	protected void deletar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idDestino = Integer.parseInt(req.getParameter("idDestino"));

		DestinoDAO dDAO = new DestinoDAO();

		dDAO.removeById(idDestino);
		resp.sendRedirect("destino");
	}

	protected void editar(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		int idDestino = Integer.parseInt(req.getParameter("idDestino"));
		DestinoDAO dDAO = new DestinoDAO();
		Destino DestinoSelecionado = dDAO.getDestinoById(idDestino);

		req.setAttribute("destino", DestinoSelecionado);

		RequestDispatcher rd = req.getRequestDispatcher("./views/EditarDestino.jsp");
		rd.forward(req, resp);
	}

	protected void alterar(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Destino destinoAlterado = new Destino();

		destinoAlterado.setNomeDestino(req.getParameter("nomeDestino")); 	
		destinoAlterado.setPrecoUnit(Double.parseDouble(req.getParameter("precoUnit")));
		destinoAlterado.setCategoriaDestino(req.getParameter("categoriaDestino"));
		destinoAlterado.setQtdDisponivel(Integer.parseInt(req.getParameter("qtdDisponivel")));		
		destinoAlterado.setHoraIda(req.getParameter("horaIda"));
		destinoAlterado.setHoraChegada(req.getParameter("horaChegada"));
		destinoAlterado.setCondicao(req.getParameter("condicao"));
		destinoAlterado.setIdDestino(Integer.parseInt(req.getParameter("idDestino")));

		DestinoDAO cd = new DestinoDAO();
		cd.update(destinoAlterado);
		resp.sendRedirect("destino");
	}

}
