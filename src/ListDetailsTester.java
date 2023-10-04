import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import controller.RegionHelper;
import model.CarList;
import model.ListDetails;
import model.Region;


/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 3, 2023
 */
public class ListDetailsTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

 				Region northAmerica = new Region("North America");
				
				ListDetailsHelper ldh = new ListDetailsHelper();
				
				CarList chevy = new CarList("Chevy", "Tahoe");
				CarList ford = new CarList("Ford", "Bronco");
				
				List<CarList> nACars = new ArrayList<CarList>();
				nACars.add(chevy);
				nACars.add(ford);
				
				ListDetails nAList = new ListDetails("North America", LocalDate.now(), northAmerica);
				nAList.setListOfCars(nACars);
				ldh.insertNewListDetails(nAList);
				
				List<ListDetails> allLists = ldh.getLists();
				for(ListDetails a: allLists) {
					System.out.println(a.toString());
				}
				
			}
	}


