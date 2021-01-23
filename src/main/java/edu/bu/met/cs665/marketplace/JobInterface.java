package edu.bu.met.cs665.marketplace;

/**
  * The interface for jobs/assignments.
  *
  * @author zhuo zhang
  * date 12/04/2020
  * course CS665
  * final project
  */

public interface JobInterface {
  String getLang();

  boolean isTaken();

  VendorInterface getAssignedTo();

}
