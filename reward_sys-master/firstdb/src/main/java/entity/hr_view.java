package com.example.reward_system.Model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Hr_view{


//    @GeneratedValue(strategy= GenerationType.AUTO)

    @Id
    private int row_id;
    private String recipient_email;
    private String proposer_email;
    private String approver_email;
    private Date approved_date;
    private String salutation;
    private int status;

    public Hr_view() {
    }
    public Hr_view(int row_id, String recipient_email, String proposer_email, String approver_email, Date approved_date, String salutation, int status) {
        this.row_id = row_id;
        this.recipient_email = recipient_email;
        this.proposer_email = proposer_email;
        this.approver_email = approver_email;
        this.approved_date = approved_date;
        this.salutation = salutation;
        this.status = status;
    }

    public int getRow_id() {
        return row_id;
    }

    public void setRow_id(int row_id) {
        this.row_id = row_id;
    }

    public String getRecipient_email() {
        return recipient_email;
    }

    public void setRecipient_email(String recipient_email) {
        this.recipient_email = recipient_email;
    }

    public String getProposer_email() {
        return proposer_email;
    }

    public void setProposer_email(String proposer_email) {
        this.proposer_email = proposer_email;
    }

    public String getApprover_email() {
        return approver_email;
    }

    public void setApprover_email(String approver_email) {
        this.approver_email = approver_email;
    }

    public Date getApproved_date() {
        return approved_date;
    }

    public void setApproved_date(Date approved_date) {
        this.approved_date = approved_date;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
