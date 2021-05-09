package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification () {
    app.goTo().gotoToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Name", "Name2", "Nick", "Home", "Lunnaya st. 10", "1234456", "87981236655", "name@yandex.ru", "test1"), true);
    }
    List<ContactData> beforeC = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(beforeC.size() - 1);
    app.getContactHelper().initContactModification(beforeC.size() - 1);
    ContactData contact = new ContactData(beforeC.get(beforeC.size() - 1).getId(), "ModName", "ModName2", "Nick", "Home", "Lunnaya st. 10", "1234456", "87981236655", "name@yandex.ru", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> afterC = app.getContactHelper().getContactList();
    Assert.assertEquals(afterC.size(), beforeC.size());

    beforeC.remove(beforeC.size() - 1);
    beforeC.add(contact);
    Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(), c2.getId());
    beforeC.sort(byId);
    afterC.sort(byId);
    Assert.assertEquals(beforeC, afterC);

  }
}
