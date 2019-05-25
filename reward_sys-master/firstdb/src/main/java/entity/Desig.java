package entity;

import javax.persistence.Id;

public class Desig {
    private String emp_mail;
    @Id
    private int emp_id;
    private String desig;
    private int manager_id;

    public Emp_Desig(String emp_mail, int emp_id, String desig, int manager_id) {
        this.emp_mail = emp_mail;
        this.emp_id = emp_id;
        this.desig = desig;
        this.manager_id = manager_id;
    }

    public Emp_Desig() {
    }

    public String getEmp_mail() {
        return emp_mail;
    }

    public void setEmp_mail(String emp_mail) {
        this.emp_mail = emp_mail;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "Emp_Desig{" +
                "emp_mail='" + emp_mail + '\'' +
                ", emp_id=" + emp_id +
                ", desig='" + desig + '\'' +
                ", manager_id=" + manager_id +
                '}';
    }
}
