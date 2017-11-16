package hello;

import com.google.maps.model.DistanceMatrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CardController {

    @Autowired
    DistanceService distanceService;

    @RequestMapping(value = "/distance", method = RequestMethod.GET)
    public DistanceMatrix distance(
            @RequestParam("startLat") Double startLat,
            @RequestParam("startLng") Double startLng,
            @RequestParam("endLat") Double endLat,
            @RequestParam("endLng") Double endLng
    ) {
        return distanceService.getDistanceBetween2Points(startLat, startLng, endLat, endLng);
    }
}