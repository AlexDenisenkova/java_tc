package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDelitionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Name").withLastname("Name2").withNickname("Nick").withCompany("Home").withAddress("Lunnaya st. 10").withHomephone("1234456").withMobile("87981236655").withEmail("name@yandex.ru").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactDelition() throws Exception {
    Set<ContactData> beforeC = app.contact().all();
    ContactData deletedContact = beforeC.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContactData> afterC = app.contact().all();
    Assert.assertEquals(afterC.size(), beforeC.size() - 1);

    beforeC.remove(deletedContact);
    Assert.assertEquals(beforeC, afterC);
  }
}
