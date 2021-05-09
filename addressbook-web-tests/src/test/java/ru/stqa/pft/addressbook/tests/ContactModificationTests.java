package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Name").withLastname("Name2").withNickname("Nick").withCompany("Home").withAddress("Lunnaya st. 10").withHomephone("1234456").withMobile("87981236655").withEmail("name@yandex.ru").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactModification () {
    Set<ContactData> beforeC = app.contact().all();
    ContactData modifiedContact = beforeC.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withName("ModName").withLastname("ModName2").withNickname("Nick").withCompany("Home").withAddress("Lunnaya st. 10").withHomephone("1234456").withMobile("87981236655").withEmail("name@yandex.ru");
    app.contact().modify(contact);
    Set<ContactData> afterC = app.contact().all();
    Assert.assertEquals(afterC.size(), beforeC.size());

    beforeC.remove(modifiedContact);
    beforeC.add(contact);
    Assert.assertEquals(beforeC, afterC);

  }


}
