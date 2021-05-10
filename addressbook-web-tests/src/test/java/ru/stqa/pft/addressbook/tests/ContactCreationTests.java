package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.goTo().homePage();
    Contacts beforeC = app.contact().all();
    ContactData contact = new ContactData().withName("NameN").withLastname("Name2").withNickname("Nick").withCompany("Home").withAddress("Lunnaya st. 10").withHomephone("1234456").withMobile("87981236655").withEmail("name@yandex.ru").withGroup("test1");
    app.contact().create(contact, true);
    Contacts afterC = app.contact().all();
    assertThat(afterC.size(), equalTo(beforeC.size() + 1));

    assertThat(afterC, equalTo(
            beforeC.withAdded(contact.withId(afterC.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
