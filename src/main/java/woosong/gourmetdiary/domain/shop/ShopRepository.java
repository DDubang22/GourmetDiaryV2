package woosong.gourmetdiary.domain.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {


}




//    private final List<Shop> shopList = new ArrayList<>();
//
//    public List<Shop> getAllShops() {
//        return shopList;
//    }
//
//    public void saveShop(Shop shop) {
//        shopList.add(shop);
//    }