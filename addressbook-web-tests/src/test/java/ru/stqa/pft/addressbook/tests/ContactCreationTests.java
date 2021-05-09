package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    List<ContactData> beforeC = app.contact().list();
    ContactData contact = new ContactData().withName("NameN").withLastname("Name2").withNickname("Nick").withCompany("Home").withAddress("Lunnaya st. 10").withHomephone("1234456").withMobile("87981236655").withEmail("name@yandex.ru").withGroup("test1");
    app.contact().create(contact, true);
    List<ContactData> afterC = app.contact().list();
    Assert.assertEquals(afterC.size(), beforeC.size() + 1);

    beforeC.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    beforeC.sort(byId);
    afterC.sort(byId);
    Assert.assertEquals(beforeC, afterC);
  }

}
