package Pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// yukaridaki'leri lombok'tan aldik, POM'a dependency'ler ekleyerek

public class PojoHerokuappBookingDates {

    /*
        "checkin":"2021-06-01",
        "checkout":"2021-06-10"
     */

    private String checkin;
    private String checkout;

}
