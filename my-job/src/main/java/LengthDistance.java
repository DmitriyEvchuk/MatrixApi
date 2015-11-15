import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;

public class LengthDistance {

	String ApiKey;

	public LengthDistance(String ApiKey) {

		this.ApiKey = ApiKey;

	}

	public Long getDistanse(String origins, String destinations)
			throws Exception {

		GeoApiContext api = new GeoApiContext();
		api.setApiKey(ApiKey);
		DistanceMatrixApiRequest dist = new DistanceMatrixApiRequest(api);

		dist.origins(origins);

		/*
		 * GeoApiContext context = new GeoApiContext().setApiKey(ApiKey);
		 * 
		 * DistanceMatrixApiRequest
		 * distanseRequest=DistanceMatrixApi.getDistanceMatrix(context, new
		 * String []{origins}, new String []{strings}); DistanceMatrix
		 * a=distanseRequest.await();
		 * 
		 * Long rez= a.rows[0].elements[0].distance.inMeters;
		 * 
		 * 
		 * return rez;
		 */

		return dist.destinations(destinations).await().rows[0].elements[0].distance.inMeters;
	}

}
