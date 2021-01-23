package edu.bu.met.cs665.marketplace;

import java.util.List;

/**
 * The interface for vendors.
 *
 * @author zhuo zhang
 * date 12/04/2020
 * course CS665
 * final project
 */


public interface VendorInterface {
  String getVendorName();

  String getVendorEmail();

  List<String> getVendorLangs();

  Job getJob();

  void setJob(Job job);

  MarketPlace getMarket();

  void setMarket(MarketPlace market);

  void acceptJob();

  void rejectJob();

  @Override
  String toString();
}
