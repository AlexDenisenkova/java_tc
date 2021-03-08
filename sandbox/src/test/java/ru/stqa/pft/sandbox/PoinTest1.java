package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PoinTest1 {

  @Test
  public void testdistance() {
    Point p1 = new Point(9, 100);
    Point p2 = new Point(49, 25);
    Assert.assertEquals(p1.distance(p2), 85);
  }

}
