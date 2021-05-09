package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Set<ContactData> beforeC = app.contact().all();
    ContactData contact = new ContactData().withName("NameN").withLastname("Name2").withNickname("Nick").withCompany("Home").withAddress("Lunnaya st. 10").withHomephone("1234456").withMobile("87981236655").withEmail("name@yandex.ru").withGroup("test1");
    app.contact().create(contact, true);
    Set<ContactData> afterC = app.contact().all();
    Assert.assertEquals(afterC.size(), beforeC.size() + 1);

    contact.withId(afterC.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    beforeC.add(contact);
    Assert.assertEquals(beforeC, afterC);
  }

}
