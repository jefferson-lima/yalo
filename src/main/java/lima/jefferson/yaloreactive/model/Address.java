package lima.jefferson.yaloreactive.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class Address {
  String street;
  String suite;
  String city;
  String zipcode;
  GeoLocation geo;

  @Data
  @Builder
  @Jacksonized
  static class GeoLocation {
    @JsonProperty("lat")
    String latitude;
    @JsonProperty("lng")
    String longitude;
  }
}
