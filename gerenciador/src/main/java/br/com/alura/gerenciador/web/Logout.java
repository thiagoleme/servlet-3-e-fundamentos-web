package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Tarefa {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		// Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();

		// if (cookie != null){
		// cookie.setMaxAge(0);
		// resp.addCookie(cookie);
		// }

		request.getSession().removeAttribute("usuarioLogado");

		// PrintWriter writer = resp.getWriter();
		// writer.println("<html><body>Deslogado com Sucesso</body></html>");

		// resp.sendRedirect("logout.html");

		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		// dispatcher.forward(request, response);

		return "/WEB-INF/paginas/logout.html";
	}
}
