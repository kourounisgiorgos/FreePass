package gr.hua.freepass.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Citizen")
public class Citizen {

    private String userName;
    private String ssn;
    private String email;
    private String phoneNumber;
    private Date unemployedSince;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int citizen_id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getUnemployedSince() {
        return unemployedSince;
    }

    public void setUnemployedSince(Date unemployedSince) {
        this.unemployedSince = unemployedSince;
    }

    public void setId(int id) {
        this.citizen_id = id;
    }

    public int getId() {
        return citizen_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
