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

import br.com.crud.dao.ClienteDAO;
import br.com.crud.model.Cliente;


@WebServlet(urlPatterns = { "/cliente", "/criar-cliente", "/editar-cliente", "/atualizar-cliente", "/excluir-cliente" })
public class ControllerCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		switch (action) {
		case "/cliente": //exibirCadastro.jsp
			cliente(request, response);
			break;
		case "/criar-cliente": //cadastre.html
			try {
				inserir(request, response);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/editar-cliente": //EditarCliente.jsp
			editar(request, response);
			break;
		case "/excluir-cliente": //volta para rota cliente... exibirCadatro.jsp
			deletar(request, response);
			break;
		case "/atualizar-cliente": //volta para rota cliente... exibirCadatro.jsp
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
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dataNascimento = new Date(dateFormat.parse(request.getParameter("data")).getTime());      
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		// criando o objeto cliente
		Cliente cliente = new Cliente();

		cliente.setNomeCliente(nome);
		cliente.setCpf(cpf);
		cliente.setDataNascimento(dataNascimento);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		cliente.setSenha(senha);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.save(cliente);

		response.sendRedirect("cliente");		

	}

	protected void cliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Cliente> cliente = new ArrayList<Cliente>();
		ClienteDAO cdao = new ClienteDAO();
		cliente = cdao.getClientes();
		req.setAttribute("listaClientes", cliente);

		RequestDispatcher dispatcher = req.getRequestDispatcher("./views/exibirCadastro.jsp");
		dispatcher.forward(req, resp);
	}

	protected void deletar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));

		ClienteDAO cdao = new ClienteDAO();

		cdao.removeById(idCliente);
		resp.sendRedirect("cliente");
	}

	protected void editar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idCliente = Integer.parseInt(req.getParameter("idCliente"));
		ClienteDAO cdao = new ClienteDAO();
		Cliente ClienteSelecionado = cdao.getClienteById(idCliente);

		req.setAttribute("cliente", ClienteSelecionado);
		RequestDispatcher rd = req.getRequestDispatcher("./views/EditarCliente.jsp");
		rd.forward(req, resp);
	}

	protected void alterar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente clienteAlterado = new Cliente();

		clienteAlterado.setNomeCliente(req.getParameter("nomeCliente"));
		clienteAlterado.setCpf(req.getParameter("cpf"));
		// clienteAlterado.setDataNascimento(new Date());
		clienteAlterado.setTelefone(req.getParameter("telefone"));
		clienteAlterado.setEmail(req.getParameter("email"));
		clienteAlterado.setSenha(req.getParameter("senha"));
		clienteAlterado.setIdCliente(Integer.parseInt(req.getParameter("idCliente")));

		ClienteDAO cd = new ClienteDAO();
		cd.update(clienteAlterado);
		resp.sendRedirect("cliente");
	}

}
