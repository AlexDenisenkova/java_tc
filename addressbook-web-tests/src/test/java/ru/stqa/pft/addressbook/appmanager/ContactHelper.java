package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
  public WebDriver wd;

  public ContactHelper(WebDriver wd) {
    super(wd);
    this.wd = wd;
  }

  public void returnToHomePage() { click(By.linkText("home")); }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation ) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomephone());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void acceptDelitionContacts() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void selectContact(int indexC) {
    wd.findElements(By.name("selected[]")).get(indexC).click();
  }

  public void initContactModification(int indexC) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(indexC).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, b);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(int indexC, ContactData contact) {
    selectContact(indexC);
    initContactModification(indexC);
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(int indexC) {
    selectContact(indexC);
    deleteSelectedContacts();
    acceptDelitionContacts();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
   return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath(".//*[@id='maintable']/tbody/tr"));
    elements.remove(0);
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firstName = cells.get(2).getText();
      String lastName =  cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withName(firstName).withLastname(lastName));
    }
    return contacts;
  }
}
