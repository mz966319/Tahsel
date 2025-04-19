
package Tahsel.Objects;


import java.util.Date;

public class NoReplyParent {

    private int parentID;
    private String updatedBy;
    private Date dateUpdated;
    private boolean noReplyFlag;

    // Constructors
    public NoReplyParent() {}
    
    public NoReplyParent(int parentID) {
        this.parentID = parentID;
        this.noReplyFlag=false;
    }

    public NoReplyParent(int parentID, String updatedBy, Date dateUpdated, boolean noReplyFlag) {
        this.parentID = parentID;
        this.updatedBy = updatedBy;
        this.dateUpdated = dateUpdated;
        this.noReplyFlag = noReplyFlag;
    }

    // Getters and Setters
    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public boolean isNoReplyFlag() {
        return noReplyFlag;
    }

    public void setNoReplyFlag(boolean noReplyFlag) {
        this.noReplyFlag = noReplyFlag;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NoReplyParent other = (NoReplyParent) obj;
        return this.parentID == other.parentID;
    }
}

