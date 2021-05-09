package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData().withName("Name").withLastname("Name2").withNickname("Nick").withCompany("Home").withAddress("Lunnaya st. 10").withHomephone("1234456").withMobile("87981236655").withEmail("name@yandex.ru").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactModification () {
    List<ContactData> beforeC = app.contact().list();
    int indexC = beforeC.size() - 1;
    ContactData contact = new ContactData()
            .withId(beforeC.get(indexC).getId()).withName("ModName").withLastname("ModName2").withNickname("Nick").withCompany("Home").withAddress("Lunnaya st. 10").withHomephone("1234456").withMobile("87981236655").withEmail("name@yandex.ru");
    app.contact().modify(indexC, contact);
    List<ContactData> afterC = app.contact().list();
    Assert.assertEquals(afterC.size(), beforeC.size());

    beforeC.remove(indexC);
    beforeC.add(contact);
    Comparator<? super ContactData> byId = (c1,c2) -> Integer.compare(c1.getId(), c2.getId());
    beforeC.sort(byId);
    afterC.sort(byId);
    Assert.assertEquals(beforeC, afterC);

  }


}
