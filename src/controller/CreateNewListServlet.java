package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListDetails;
import model.Region;
import model.CarList;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CarListHelper clh = new CarListHelper();
		String listName = request.getParameter("listName");
		System.out.println("Cars: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String regionName = request.getParameter("RegionName");
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		String[] selectedCars = request.getParameterValues("allCarsToAdd");
		List<CarList> selectedCarsFromList = new ArrayList<CarList>();
		
		if (selectedCars != null && selectedCars.length > 0) {
			for (int i = 0; i < selectedCars.length; i++) {
				System.out.println(selectedCars[i]);
				CarList c = clh.searchForCarById(Integer.parseInt(selectedCars[i]));
				selectedCarsFromList.add(c);
			}
		}
		
		Region region = new Region(regionName);
		ListDetails cld = new ListDetails(listName, ld, region);
		cld.setListOfCars(selectedCarsFromList);

		ListDetailsHelper ldh = new ListDetailsHelper();
		ldh.insertNewListDetails(cld);
		
		System.out.println(cld.toString());

		getServletContext().getRequestDispatcher("/viewListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
