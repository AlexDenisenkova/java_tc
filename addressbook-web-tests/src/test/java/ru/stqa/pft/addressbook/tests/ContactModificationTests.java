package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification () {
    app.getNavigationHelper().gotoToHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Name", "Name2", "Nick", "Home", "Lunnaya st. 10", "1234456", "87981236655", "name@yandex.ru"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoToHomePage();
  }
}
