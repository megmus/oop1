package de.mome.javaprofis.oop.univ.domain;

public interface IStaffRO {

    long id();

    String firstname();

    String lastname();

    String birthdate();

    String currentStatus();

    String toString();

    enum Staffstatus {

        PROFESSOR,
        TUTOR,
        STUDENT;
    }
}
