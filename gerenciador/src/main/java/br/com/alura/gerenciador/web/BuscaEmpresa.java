package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {

	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando BuscaEmpresa " + this);
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo BuscaEmpresa " + this);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// PrintWriter writer = resp.getWriter();

		// writer.println("<html>");
		// writer.println("<body>");
		// writer.println("Resultado da busca:<br/>");

		String filtro = req.getParameter("filtro");
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

		req.setAttribute("empresas", empresas);

		req.getRequestDispatcher("/WEB-INF/paginas/BuscaEmpresa.jsp").forward(req, resp);
	}
}
