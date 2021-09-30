package framework.models;

import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserProfileModel {

  public String id;
  public String title;
  public String firstName;
  public String lastName;
  public String picture;
  public String gender;
  public String email;
  public Date dateOfBirth;
  public String phone;
  public Location location;
  public Date registerDate;
  public Date updatedDate;

  @Getter
  @Setter
  public static class Location{
    public String street;
    public String city;
    public String state;
    public String country;
    public String timezone;
  }

}
