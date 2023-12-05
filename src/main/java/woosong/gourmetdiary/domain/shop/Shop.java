package woosong.gourmetdiary.domain.shop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Shop {

    @Id
    @NotEmpty
    @Column(name = "shopName")
    private String shopName;

    @NotEmpty
    @Column(name = "shopAddress")
    private String shopAddress;

    @NotEmpty
    @Column(name = "shopPostalCode")
    private String shopPostalCode;

    @NotEmpty
    @Column(name = "shopJibun")
    private String shopJibun;

    @NotEmpty
    @Column(name = "shopWebsiteAddress")
    private String shopWebsiteAddress;

    @NotEmpty
    @Column(name = "shopImageAddress")
    private String shopImageAddress;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;





}
