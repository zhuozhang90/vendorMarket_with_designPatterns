package edu.bu.met.cs665.marketplace;

import java.util.List;

/**
 * the vendorbuilder builds vendors from the basic object.
 *
 * @author zhuo zhang
 * date 12/04/2020
 * course CS665
 * final project
 */

public class VendorBuilder {

  final String vendorName;
  final String vendorEmail;
  String vendorTimezone;
  List<String> vendorLangs; // assuming all source documents are in EN

  /**
   * the basic constructor.
   *
   * @param vendorName name of vendor, required
   * @param vendorEmail email of vendor, also required
   */
  public VendorBuilder(String vendorName, String vendorEmail) {
    if (vendorName == null || vendorEmail == null) {
      throw new IllegalArgumentException("vendor name and email can not be null.");
    }

    this.vendorName = vendorName;
    this.vendorEmail = vendorEmail;
  }

  /**
   * adds working languages of the vendor.
   *
   * @param vendorTimezone langs the vendor works with
   * @return vendor, but with langs.
   */
  public VendorBuilder withTimezone(String vendorTimezone) {
    this.vendorTimezone = vendorTimezone;
    return this;
  }

  /**
   * adds working languages of the vendor.
   *
   * @param vendorlangs langs the vendor works with
   * @return vendor, but with langs.
   */
  public VendorBuilder withLangs(List<String> vendorlangs) {
    this.vendorLangs = vendorlangs;
    return this;
  }


  /**
   * returns the vendor after building.
   *
   * @return vendor object with all info added.
   */
  public VendorInterface build() {
    return new Vendor(this);
  }

}
