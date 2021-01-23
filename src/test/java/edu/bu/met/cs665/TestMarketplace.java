package edu.bu.met.cs665;

import edu.bu.met.cs665.marketplace.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestMarketplace {

  // create a new marketplace for testing
  MarketPlace market = MarketPlace.getInstance();

  // create a set of vendors for the market
  VendorInterface v1, v2, v3, v4;

  {
    v1 = new VendorBuilder("vendor1", "vendor1@gmail.com")
        .withLangs(new ArrayList<>(Arrays.asList("ES", "FR")))
        .withTimezone("EST").build();

    v2 = new VendorBuilder("vendor2", "vendor2@gmail.com")
        .withLangs(new ArrayList<>(Arrays.asList("DE", "FR", "IT")))
        .withTimezone("CET").build();

    v3 = new VendorBuilder("vendor3", "vendor3@gmail.com")
        .withLangs(new ArrayList<>(Arrays.asList("PT", "ES")))
        .withTimezone("GMT").build();

    v4 = new VendorBuilder("vendor4", "vendor4@gmail.com")
        .withLangs(new ArrayList<>(Arrays.asList("EL", "TR")))
        .withTimezone("PST").build();
  }

  Job job = new Job(1, "ES", "Dec 20");

  /**
   * test if vendor can be correctly instantiated.
   */
  @Test
  public void testVendorCreation() {

    assertEquals("Vendor: vendor1, email: vendor1@gmail.com", v1.toString());

  }


  /**
   * test if the marketplace can correctly register vendors.
   */
  @Test
  public void testVendorRegistration() {

    market.registerVendor(v1);
    market.registerVendor(v2);
    assertNotNull(market.getVendorList().get(0));

  }

  /**
   * test if vendors can get notification of a new job.
   */
  @Test
  public void testNotifyingJob() {

    market.registerVendor(v1);
    market.registerVendor(v2);
    market.registerVendor(v3);
    market.registerVendor(v4);

    market.sendJobToVendor(job);
    assertNotNull(v1.getJob());
  }


  /**
   * test if vendors can correctly accept a job, and get assigned.
   * a vendor accepting the job would make other vendors unable to accept it again.
   */
  @Test
  public void testAcceptingJob() {
    market.registerVendor(v1);
    market.registerVendor(v2);
    market.registerVendor(v3);
    market.registerVendor(v4);

    market.sendJobToVendor(job);

    v1.acceptJob();
    v3.acceptJob();

    assertSame(v1, job.getAssignedTo());
  }


}
