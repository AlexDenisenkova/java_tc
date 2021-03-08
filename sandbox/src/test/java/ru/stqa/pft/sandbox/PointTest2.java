package ru.stqa.pft.sandbox;

import org.testng.annotations.Test;

public class PointTest2 {
  @Test
  public void testdistance() {
    Point p1 = new Point(9, 100);
    Point p2 = new Point(49, 25);
    assert p1.distance(p2) == 85;
  }
}
