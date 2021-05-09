package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().gotoToHomePage();
    List<ContactData> beforeC = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("NameN", "Name2", "Nick", "Home", "Lunnaya st. 10", "1234456", "87981236655", "name@yandex.ru", "test1");
    app.getContactHelper().createContact(contact, true);
    List<ContactData> afterC = app.getContactHelper().getContactList();
    Assert.assertEquals(afterC.size(), beforeC.size() + 1);

    contact.setId(afterC.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    beforeC.add(contact);
    Assert.assertEquals(new HashSet<Object>(beforeC), new HashSet<Object>(afterC));
  }

}
