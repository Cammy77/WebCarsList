import java.util.List;



import controller.RegionHelper;
import model.Region;

/**
 * Cameron Mockobee - cmockobee1@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 3, 2023
 */
public class RegionTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Region northAmerica = new Region("North America");
		Region europe = new Region("Europe");
		
		RegionHelper rh = new RegionHelper();
		
		rh.insertRegion(northAmerica);
		rh.insertRegion(europe);
		
		List<model.Region> allRegions = rh.showAllRegions();
		for(model.Region r: allRegions) {
			System.out.println(r.toString());
		}

	}

}
