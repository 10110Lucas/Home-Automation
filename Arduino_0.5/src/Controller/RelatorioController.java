package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Arduino;
import Service.ArduinoService;

/**
 * Servlet implementation class RelatorioController
 */
@WebServlet("/Relatorio.do")
public class RelatorioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArduinoService service;
    
    public RelatorioController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		service = new ArduinoService();
		
		if(acao.equals("Listar")) {
			ArrayList<Arduino> conteudo = service.lista2();
			request.setAttribute("conteudo", conteudo);
			request.getRequestDispatcher("Relatorio.jsp").forward(request, response);
		}
	}

}
