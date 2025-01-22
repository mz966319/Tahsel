/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tahsel.Objects;

import java.util.Date;

/**
 *
 * @author Bat
 */
public class Comment {

    private int commentID;
    private int parentID;
    private String comment;
    private double toGetCollected;
    private Date dateToCollect;
    private Date dateCreated;
    private double totalOwed;
    private double remaining;
    private String createdBy;

    public Comment(int parentID, String comment, double toGetCollected, Date dateToCollect, Date dateCreated, double totalOwed, double remaining, String createdBy) {
        this.parentID = parentID;
        this.comment = comment;
        this.toGetCollected = toGetCollected;
        this.dateToCollect = dateToCollect;
        this.dateCreated = dateCreated;
        this.totalOwed = totalOwed;
        this.remaining = remaining;
        this.createdBy = createdBy;
    }

    public Comment() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getToGetCollected() {
        return toGetCollected;
    }

    public void setToGetCollected(double toGetCollected) {
        this.toGetCollected = toGetCollected;
    }

    public Date getDateToCollect() {
        return dateToCollect;
    }

    public void setDateToCollect(Date dateToCollect) {
        this.dateToCollect = dateToCollect;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    @Override
    public String toString() {
        return "Comment{" + "commentID=" + commentID + ", parentID=" + parentID + ", comment=" + comment + ", toGetCollected=" + toGetCollected + ", dateToCollect=" + dateToCollect + ", dateCreated=" + dateCreated + ", totalOwed=" + totalOwed + ", remaining=" + remaining + ", createdBy=" + createdBy + '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
