package edu.bu.met.cs665.marketplace;

import java.util.ArrayList;
import java.util.List;

/**
 * the marketplace accepts requests and sends notifications to the vendors.
 *
 * @author zhuo zhang
 * date 12/04/2020
 * course CS665
 * final project
 */

public class MarketPlace implements Mediator {

  List<VendorInterface> vendorInterfaceList; // the list of vendors
  private static MarketPlace instance;

  /**
   * private constructor, called by getInstance if needed.
   */
  private MarketPlace() {
    vendorInterfaceList = new ArrayList<>();
  }

  /**
   * returns a single and static instance of Marketplace.
   *
   * @return the unique static instance of Marketplace
   */
  public static MarketPlace getInstance() {
    if (instance == null) {
      instance = new MarketPlace();
    }
    return instance;
  }

  public List<VendorInterface> getVendorList() {
    return vendorInterfaceList;
  }

  /**
   * adds vendor to vendor list.
   *
   * @param v vendor to add
   */
  @Override
  public void registerVendor(VendorInterface v) {
    this.vendorInterfaceList.add(v);
    v.setMarket(this);
  }

  /**
   * removes the vendor.
   *
   * @param v vendor to remove
   */
  @Override
  public void unregisterVendor(VendorInterface v) {
    this.vendorInterfaceList.remove(v);
  }

  /**
   * send job to all vendors that are eligible.
   *
   * @param job job to send to vendors
   */
  @Override
  public void sendJobToVendor(Job job) {
    System.out.println(String.format("Sending job %s to vendors.", job.toString()));
    for (VendorInterface v : vendorInterfaceList) {
      // if vendor works with lang, then send to vendor
      if (v.getVendorLangs().contains(job.getLang())) {
        v.setJob(job);
        System.out.println(String.format("Job sent to %s", v.getVendorName()));
      }
    }
  }
}
