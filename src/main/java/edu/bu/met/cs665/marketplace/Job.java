package edu.bu.met.cs665.marketplace;

/**
 * The Job class for new job requests.
 *
 * @author zhuo zhang
 * date 12/04/2020
 * course CS665
 * final project
 */

public class Job implements JobInterface {

  int id;
  String lang;
  String dueDate; // change to datetime objects in the future

  boolean isTaken; // if taken then sets to true
  VendorInterface assignedTo; // links to the vendor who took the job

  /**
   *  Job constructor.
   *
   * @param id job id
   * @param lang job language
   * @param dueDate due date of job
   */
  public Job(int id, String lang, String dueDate) {
    this.id = id;
    this.lang = lang;
    this.dueDate = dueDate;
  }

  @Override
  public String getLang() {
    return lang;
  }

  @Override
  public boolean isTaken() {
    return isTaken;
  }

  @Override
  public VendorInterface getAssignedTo() {
    return assignedTo;
  }

  /**
   * assigns the job to a vendor and notify the vendor as well as the marketplace.
   *
   * @param v vendor that takes the job
   */
  void assignToVendor(VendorInterface v) {
    this.isTaken = true;
    this.assignedTo = v;
    System.out.println(String.format("Job taken by %s.", v.getVendorName()));
  }

  /**
   * notify vendor of the status upon inquiry if taken.
   */
  void notifyVendor() {
    System.out.println("Job already taken.");
  }

  @Override
  public String toString() {
    return String.format("Job %d with %s due %s", this.id, this.lang, this.dueDate);
  }
}
