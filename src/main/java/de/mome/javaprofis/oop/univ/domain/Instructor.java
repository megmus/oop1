package de.mome.javaprofis.oop.univ.domain;

import org.apache.commons.lang3.RandomUtils;

import java.util.Date;

class Instructor extends UniMember {

    private final long persNumber;
    private String faculty;
    private String office;

    static final int MIN_AGE = 35;
    static final int MAX_AGE = 75;

    Instructor(final String firstname, final String lastname, final String birthdate, final String faculty, final String office) {
        super(firstname, lastname, birthdate);
        this.faculty = faculty;
        this.office = office;
        persNumber = RandomUtils.nextLong(99999, 999999);
    }

    public long id() {
        return personalNumber();
    }

    @Override
    public IStaffRO.Staffstatus currentStatus() {
        return IStaffRO.Staffstatus.PROFESSOR;
    }

    public boolean isApt(final String birthdate) {
        final Date originBD = birthdate();
        final int newAge = age(birthdate);
        if (newAge >= MIN_AGE && newAge <= MAX_AGE) {
            return Boolean.TRUE;
        }
        resetBirthdate(originBD);
        return Boolean.FALSE;
    }

    long personalNumber() {
        return this.persNumber;
    }

    String faculty() {
        return this.faculty;
    }

    String office() {
        return this.office;
    }

     public String toString() {
        return super.toString() + "\n" +
                "Personal number: " + personalNumber() + "\n" +
                "Faculty: " + faculty() + "\n" +
                "Office: " + office();
    }
}
