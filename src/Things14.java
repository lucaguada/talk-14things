public class Things14 {
  static class ContactInfo {
    String getEmail() { return "email@email.it"; }
  }

  static class Details {
    ContactInfo getContactInfo() { return null; }
  }

  static class Person {
    Details getDetails() { return new Details(); }
  }

  public static void main(String[] args) {
    var person = new Person();

    var email = person.getDetails().getContactInfo().getEmail();
  }

}
