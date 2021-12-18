package gr.hua.freepass.Entities;

import jdk.internal.instrumentation.TypeMapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="citizens")
public class Citizen {

    @Id
    @SequenceGenerator(
            name="citizen_sequence",
            sequenceName = "citizen_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="citizen_sequence"
    )
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="ssn")
    private String ssn;


    @Column(name="email")
    private String email;

    @Column(name="age")
    private int age;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name="unemployed_since")
    private Date unemployedSince;

    @Column(name="phone_number")
    private String phoneNumber;



}
