package de.mome.javaprofis.oop.univ.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class StaffVO implements Serializable {
    private String firstname;
    private String lastname;
    private String birthdate;

}
