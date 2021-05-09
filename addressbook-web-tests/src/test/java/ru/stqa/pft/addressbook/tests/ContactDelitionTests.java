package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDelitionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Name", "Name2", "Nick", "Home", "Lunnaya st. 10", "1234456", "87981236655", "name@yandex.ru", "test1"), true);
    }
  }

  @Test
  public void testContactDelition() throws Exception {
    List<ContactData> beforeC = app.contact().list();
    int indexC = beforeC.size() - 1;
    app.contact().delete(indexC);
    List<ContactData> afterC = app.contact().list();
    Assert.assertEquals(afterC.size(), beforeC.size() - 1);

    beforeC.remove(indexC);
    Assert.assertEquals(beforeC, afterC);
  }
}
