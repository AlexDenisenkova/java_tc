package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDelitionTests extends TestBase {

  @Test
  public void testContactDelition() throws Exception {
    app.getNavigationHelper().gotoToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Name", "Name2", "Nick", "Home", "Lunnaya st. 10", "1234456", "87981236655", "name@yandex.ru", "test1"), true);
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().acceptDelitionContacts();
    app.getNavigationHelper().gotoToHomePage();
  }
}
