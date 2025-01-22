package Tahsel.Objects;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Parent {

    private int parentID;
    private String parentName;
    private String grades;
    private String childrensNames;
    private Date lastPaidDate;
    private double lastPaidMoney;
    private double totalOwed;
    private double remaining;
    private int numberOfChildren;
    private double totalPaied;
    private Date lastDateToCollect;
    private String comment;
    private double remainingOldFees;

    public Parent() {
    }

    public Parent(int parentID, String parentName, String grades, String childrensNames, Date lastPaidDate, double lastPaidMoney, double totalOwed, double remaining,double remainingOldFees) {
        this.parentID = parentID;
        this.parentName = parentName;
        this.grades = grades;
        this.childrensNames = childrensNames;
        this.lastPaidDate = lastPaidDate;
        this.lastPaidMoney = lastPaidMoney;
        this.totalOwed = totalOwed;
        this.remaining = remaining;
        this.numberOfChildren = 1;
        this.totalPaied = totalOwed - remaining;
        this.lastDateToCollect = null;
        this.comment="";
        this.remainingOldFees =remainingOldFees;
        
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRemainingOldFees() {
        return this.remainingOldFees;
    }

    public void setRemainingOldFees(double remainingOldFees) {
        this.remainingOldFees = remainingOldFees;
    }

    public Date getLastDateToCollect() {
        return lastDateToCollect;
    }

    public void setLastDateToCollect(Date latsDateToCollect) {
        this.lastDateToCollect = latsDateToCollect;
    }

    public void setTotalPaied(double totalPaied) {
        this.totalPaied = totalPaied;
    }

    
    public double getTotalPaied() {
        
//        return Double.parseDouble(new DecimalFormat("#.00").format(totalPaied));
        return Math.round(totalPaied * 100.0) / 100.0;
    }

    public int getPaymentStatusPercentage() {
        return (int) ((this.totalPaied / this.totalOwed) * 100);
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public String getChildrensNames() {
        return childrensNames;
    }

    public void setChildrensNames(String childrensNames) {
        this.childrensNames = childrensNames;
    }

    public Date getLastPaidDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(lastPaidDate);
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(formattedDate);
        } catch (ParseException ex) {
            Logger.getLogger(Parent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parsedDate;
    }

    public void setLastPaidDate(Date lastPaidDate) {
        this.lastPaidDate = lastPaidDate;
    }

    public double getLastPaidMoney() {
        return lastPaidMoney;
    }

    public void setLastPaidMoney(double lastPaidMoney) {
        this.lastPaidMoney = lastPaidMoney;
    }

    public double getTotalOwed() {
        return totalOwed;
    }

    public void setTotalOwed(double totalOwed) {
        this.totalOwed = totalOwed;
    }

    public double getRemaining() {
        return remaining;
    }

    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public void increaseNumberOfChildrenByOne() {
        this.numberOfChildren++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Parent parent = (Parent) o;
        return parentID == parent.parentID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parentID);
    }

    @Override
    public String toString() {
        return parentID + "";
    }
}
