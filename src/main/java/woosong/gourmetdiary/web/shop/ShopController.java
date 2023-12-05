package woosong.gourmetdiary.web.shop;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import woosong.gourmetdiary.domain.shop.Shop;
import woosong.gourmetdiary.domain.shop.ShopRepository;
import woosong.gourmetdiary.domain.shop.ShopService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ShopController {

    private final ShopRepository shopRepository;
    private final ShopService shopService;

    @PostMapping("/map")
    public ResponseEntity<String> shopRequest(@RequestBody Shop shop) {
        log.info("shop = {}", shop);

        String apikey = "AIzaSyAc19-YkAH79mZTZpc81l8bLX2wuiEE3Kw";

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apikey)
                .build();

        String address = shop.getShopAddress();

        try {
            // Make the geocoding request
            GeocodingResult[] results = GeocodingApi.geocode(context, address).await();

            // Extract the latitude and longitude from the first result
            if (results != null && results.length > 0) {
                LatLng location = results[0].geometry.location;
                double latitude = location.lat;
                double longitude = location.lng;

                log.info("latitude ={}", latitude);
                log.info("longitude ={}", longitude);
                shop.setLatitude(latitude);
                shop.setLongitude(longitude);

            } else {
                System.out.println("No results found for the address.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        shopService.saveShop(shop);
        return ResponseEntity.ok("ok");
    }

//    @GetMapping("/map")
//    public ResponseEntity<List<Shop>> getMapData() {
//        List<Shop> shops = shopService.getAllShops();
//        return ResponseEntity.ok(shops);
//    }


    @GetMapping("/map")
    public String map() {
        return "index.html";
    }

}
