package hello;

import com.google.maps.DistanceMatrixApi;

import com.google.maps.DistanceMatrixApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private final String API_KEY = "AIzaSyA-Jrq0m3hAc35s8aiG6aXUJ58QDpn9BJM";
    private final GeoApiContext context = new GeoApiContext.Builder().apiKey(API_KEY).build();

    public DistanceMatrix getDistanceBetween2Points(Double startLat, Double startLng, Double endLat, Double endLng) {
        return getDistanceBetween2Points(new LatLng(startLat, startLng), new LatLng(endLat, endLng));
    }

    public DistanceMatrix getDistanceBetween2Points(LatLng departure, LatLng arrivals) {
        try {
            DistanceMatrixApiRequest req = DistanceMatrixApi.newRequest(context);

            DistanceMatrix trix = req.origins(departure)
                    .destinations(arrivals)
                    .mode(TravelMode.DRIVING)
                    .language("en-uk")
                    .await();

            return trix;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}