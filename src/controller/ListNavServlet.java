package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;

/**
 * Servlet implementation class ListNavServlet
 */
@WebServlet("/listNavServlet")
public class ListNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListDetailsHelper ldh = new ListDetailsHelper();
		String act = request.getParameter("doThisToList");
		
		if(act==null) {
			getServletContext().getRequestDispatcher("/viewListsServlet").forward(request, response);
		}else if(act.equals("delete")) {
			
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListDetails listToDelete = ldh.searchForListDetailsById(tempId);
				ldh.deleteList(listToDelete);
			 
				getServletContext().getRequestDispatcher("/viewListsServlet").forward(request, response);
			}else if(act.equals("add")) {
				getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
			}
	}

}
