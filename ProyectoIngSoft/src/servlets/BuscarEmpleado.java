package servlets;

import interaccionArchivos.FileProcesser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.InteraccionBase;

/**
 * Servlet implementation class BuscarEmpleado
 */
@WebServlet("/Empleados_Buscar")
public class BuscarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FileProcesser fp = FileProcesser.getInstance();
		PrintWriter writer = response.getWriter();
		String text = fp
				.processFile("C:\\Paulo\\ProyectoIngSoft\\resources\\escogerEmpleado.php");
		writer.print(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null || id.equals("")) {
			response.sendRedirect("http://localhost:8081/ProyectoIngSoft/Empleados_Buscar");
		} else {
			InteraccionBase ib = InteraccionBase.getInstance();
			String ans = ib.buscarEmpleado(id);
			PrintWriter writer = response.getWriter();
			writer.write(ans);
		}
	}

}
