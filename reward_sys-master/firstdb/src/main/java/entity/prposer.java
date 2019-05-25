package entity;

import javax.persistence.Id;

public class prposer {
    public int getRow_id() {
        return row_id;
    }

    public void setRow_id(int row_id) {
        this.row_id = row_id;
    }

    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
    private int row_id;
    private int Recipient_Id;
    private String proposer_email;
    private String recipient_email;
    private String salutation;
    private int status;
    private int manager_id;
    private Date Proposal_Date;

    public proposer(int row_id, int recipient_Id, String proposer_email, String recipient_email, String salutation, int status, int manager_id, Date proposal_Date) {
        this.row_id = row_id;
        this.Recipient_Id = recipient_Id;
        this.proposer_email = proposer_email;
        this.recipient_email = recipient_email;
        this.salutation = salutation;
        this.status = status;
        this.manager_id = manager_id;
        this.Proposal_Date = proposal_Date;
    }

    public proposer(String proposer_email, String recipient_email, String salutation) {
        this.proposer_email = proposer_email;
        this.recipient_email = recipient_email;
        this.salutation = salutation;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public proposer() {
    }



    public String getProposer_email() {
        return proposer_email;
    }

    public void setProposer_email(String proposer_email) {
        this.proposer_email = proposer_email;
    }



    public String getRecipient_email() {
        return recipient_email;
    }

    public void setRecipient_email(String recipient_email) {
        this.recipient_email = recipient_email;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public int getRecipient_Id() {
        return Recipient_Id;
    }

    public void setRecipient_Id(int recipient_Id) {
        Recipient_Id = recipient_Id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getProposal_Date() {
        return Proposal_Date;
    }

    public void setProposal_Date(Date proposal_Date) {
        Proposal_Date = proposal_Date;
    }

    @Override
    public String toString() {
        return "proposer{" +
                "row_id=" + row_id +
                ", Recipient_Id=" + Recipient_Id +
                ", proposer_email='" + proposer_email + '\'' +
                ", recipient_email='" + recipient_email + '\'' +
                ", salutation='" + salutation + '\'' +
                ", status=" + status +
                ", manager_id=" + manager_id +
                ", Proposal_Date=" + Proposal_Date +
                '}';
    }
}
