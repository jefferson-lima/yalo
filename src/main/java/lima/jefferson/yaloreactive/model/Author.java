package lima.jefferson.yaloreactive.model;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class Author {
  Integer id;
  String name;
  String username;
  String email;
  Address address;
  String phone;
  String website;
  Company company;
}
