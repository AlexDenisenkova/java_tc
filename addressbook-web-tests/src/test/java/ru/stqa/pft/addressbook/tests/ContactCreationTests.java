package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoToHomePage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("Name", "Name2", "Nick", "Home", "Lunnaya st. 10", "1234456", "87981236655", "name@yandex.ru", "test1"), true);
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoToHomePage();
  }

}
