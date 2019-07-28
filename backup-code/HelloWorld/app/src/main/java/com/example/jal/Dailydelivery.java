package com.example.jal;

public class Dailydelivery {

    private Integer id;

  //  private Date trans_date;

    private Integer customerId;

    private Integer returnCanCount;

    private Integer deliveredCanCount;

    private Integer employeeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   /* public Date getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(Date trans_date) {
        this.trans_date = trans_date;
    }*/

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getReturnCanCount() {
        return returnCanCount;
    }

    public void setReturnCanCount(Integer returnCanCount) {
        this.returnCanCount = returnCanCount;
    }

    public Integer getDeliveredCanCount() {
        return deliveredCanCount;
    }

    public void setDeliveredCanCount(Integer deliveredCanCount) {
        this.deliveredCanCount = deliveredCanCount;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

}
