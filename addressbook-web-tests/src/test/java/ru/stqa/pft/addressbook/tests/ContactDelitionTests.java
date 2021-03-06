package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Contacts beforeC = app.contact().all();
    ContactData deletedContact = beforeC.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(beforeC.size() - 1));
    Contacts afterC = app.contact().all();
    assertThat(afterC, equalTo(beforeC.without(deletedContact)));
  }
}
