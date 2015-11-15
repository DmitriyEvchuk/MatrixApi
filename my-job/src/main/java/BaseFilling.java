import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;

public class BaseFilling {

	private final ArrayList<String> cities = BaseReader.baseRead();

	private final LengthDistance distanse = new LengthDistance(
			"AIzaSyBsGna7JRoY2ztcJhTs6fOJ-DMZTtmLagU");

	public void fillBase() throws Exception {

		for (int i = 0; i < cities.size(); i++) {

			for (int j = 0; j < cities.size(); j++) {

				Long finalDist = distanse.getDistanse(cities.get(i),
						cities.get(j));

				if (finalDist > 300000) {

					System.out.println(cities.get(i) + " " + finalDist + " "
							+ cities.get(j));

				}

			}

		}

	}

	public static void main(String[] args) throws Exception {

		BaseFilling a = new BaseFilling();
		a.fillBase();

		// System.out.println(BaseReader.baseRead());

	}

}
