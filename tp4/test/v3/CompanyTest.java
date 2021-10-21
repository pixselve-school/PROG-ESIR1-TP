package v3;

import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyTest {

  @Test
  public void generateRegistration() {
    assertEquals("AA-000-AA", Company.generateRegistration(0));
    assertEquals("AA-000-AB", Company.generateRegistration(1));
    assertEquals("AA-000-AZ", Company.generateRegistration(25));
    assertEquals("AA-000-BA", Company.generateRegistration(26));
    assertEquals("AA-001-AA", Company.generateRegistration(676));
  }
}