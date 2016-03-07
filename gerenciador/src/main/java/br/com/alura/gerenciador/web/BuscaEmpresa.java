package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class BuscaEmpresa implements Tarefa {

	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}

	// @Override
	// public void init() throws ServletException {
	// super.init();
	// System.out.println("Inicializando BuscaEmpresa " + this);
	// }

	// @Override
	// public void destroy() {
	// super.destroy();
	// System.out.println("Destruindo BuscaEmpresa " + this);
	// }

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		// PrintWriter writer = resp.getWriter();

		// writer.println("<html>");
		// writer.println("<body>");
		// writer.println("Resultado da busca:<br/>");

		String filtro = request.getParameter("filtro");
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

		// writer.println("<ul>");
		// for (Empresa empresa : empresas) {
		// writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() +
		// "</li>");
		// }
		// writer.println("</ul>");
		//
		// writer.println("</body>");
		// writer.println("</html>");
		//
		// writer.close();

		request.setAttribute("empresas", empresas);

		// request.getRequestDispatcher("/WEB-INF/paginas/BuscaEmpresa.jsp").forward(request,
		// response);
		return "/WEB-INF/paginas/BuscaEmpresa.jsp";
	}
}
