package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");

		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);

		// PrintWriter writer = resp.getWriter();

		// writer.println("<html>");
		// writer.println("<body>");
		//
		// writer.println("Empresa " + empresa.getNome() + " adicionada com
		// Sucesso!");
		//
		// writer.println("</body>");
		// writer.println("</html>");

		// writer.close();

		req.setAttribute("empresa", empresa);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/NovaEmpresa.jsp");
		dispatcher.forward(req, resp);
	}
}
