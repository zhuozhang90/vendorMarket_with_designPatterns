package edu.bu.met.cs665.marketplace;

/**
 * the mediator interface.
 *
 * @author zhuo zhang
 * date 10/14/2020
 * course CS665
 * final project
 */

public interface Mediator {

  void registerVendor(VendorInterface v);

  void unregisterVendor(VendorInterface v); // not used in this project but can be used.

  void sendJobToVendor(Job j);
}
