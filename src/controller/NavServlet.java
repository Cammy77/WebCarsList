package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CarList;

/**
 * Servlet implementation class NavServlet
 */
@WebServlet("/navServlet")
public class NavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarListHelper clh = new CarListHelper();
		String act = request.getParameter("doThisToCar");

		String path = "/viewAllCarsServlet";

		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CarList carToDelete = clh.searchForCarById(tempId);
				clh.deleteCar(carToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a vehicle");
			}
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CarList carToEdit = clh.searchForCarById(tempId);
				request.setAttribute("carToEdit", carToEdit);
				path = "/edit-car.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an vehicle");
			}
		} else if (act.equals("add")) {
			path = "/index.html";
		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
