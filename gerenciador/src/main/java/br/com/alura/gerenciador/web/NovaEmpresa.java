package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String nome = request.getParameter("nome");

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

		request.setAttribute("empresa", empresa);

		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("/WEB-INF/paginas/NovaEmpresa.jsp");
		// dispatcher.forward(request, response);

		return "/WEB-INF/paginas/NovaEmpresa.jsp";

	}
}
