package model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ZIPCODE")
@Data
public class Zipcode {

    private String zipcode;

    private String sido;

    private String gugun;

    private String dong;

    private String ri;

    private String bunji;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
}
