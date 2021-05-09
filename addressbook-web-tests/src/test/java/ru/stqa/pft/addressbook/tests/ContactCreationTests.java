package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoToHomePage();
    List<ContactData> beforeC = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("Name", "Name2", "Nick", "Home", "Lunnaya st. 10", "1234456", "87981236655", "name@yandex.ru", "test1"), true);
    List<ContactData> afterC = app.getContactHelper().getContactList();
    Assert.assertEquals(afterC.size(), beforeC.size() + 1);
  }

}
