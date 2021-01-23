package edu.bu.met.cs665.marketplace;

import java.util.List;

/**
 * the vendor class that holds info about vendors and can take jobs.
 *
 * @author zhuo zhang
 * date 12/04/2020
 * course CS665
 * final project
 */

public class Vendor implements VendorInterface {

  private final String vendorName;
  private final String vendorEmail;
  private final String vendorTimezone;
  private final List<String> vendorLangs; // assuming all source documents are in EN
  private Job job;
  private MarketPlace market;

  Vendor(VendorBuilder vendorBuilder) {
    this.vendorName = vendorBuilder.vendorName;
    this.vendorEmail = vendorBuilder.vendorEmail;
    this.vendorLangs = vendorBuilder.vendorLangs;
    this.vendorTimezone = vendorBuilder.vendorTimezone;
  }

  @Override
  public String getVendorName() {
    return vendorName;
  }

  @Override
  public String getVendorEmail() {
    return vendorEmail;
  }

  public String getVendorTimezone() {
    return vendorTimezone;
  }

  @Override
  public List<String> getVendorLangs() {
    return vendorLangs;
  }

  @Override
  public Job getJob() {
    return job;
  }

  @Override
  public void setJob(Job job) {
    System.out.println("Job received");
    this.job = job;
  }

  @Override
  public MarketPlace getMarket() {
    return market;
  }

  @Override
  public void setMarket(MarketPlace market) {
    this.market = market;
  }

  /**
   * call the method in Job to assign it to self.
   */
  @Override
  public void acceptJob() {
    if (!this.job.isTaken()) {
      this.job.assignToVendor(this);
    } else {
      this.job.notifyVendor();
      this.job = null;
    }
  }

  /**
   * simply reject the job.
   */
  @Override
  public void rejectJob() {
    this.job = null;
  }

  @Override
  public String toString() {
    return String.format("Vendor: %s, email: %s", this.vendorName, this.vendorEmail);
  }
}
