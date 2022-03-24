package de.mome.javaprofis.oop.univ.domain;

import org.apache.commons.lang3.RandomUtils;

import java.util.Date;

final class Student extends UniMember {
    private final long matriculation;
    private int semester;

    static final int MIN_SEMESTER = 1;
    static final int MAX_SEMESTER = 15;
    static final int MIN_AGE = 18;
    static final int MAX_AGE = 65;

    Student(final String firstname, final String lastname, final String birthdate) {
        super(firstname, lastname, birthdate);
        //changeMatriculation();
        this.matriculation = RandomUtils.nextLong(1, 99999);
        this.semester = MIN_SEMESTER;
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

    long matriculation() {
        return matriculation;
    }

    public long id() {
        return matriculation();
    }

    public IStaffRO.Staffstatus currentStatus() {
        return IStaffRO.Staffstatus.PROFESSOR;
    }

    int currentSemester() {
        return semester;
    }

    void incrementSemester() {
        if (semester - MAX_SEMESTER == 0) {
            exmatriculate();
        }
        semester++;
    }

    private void exmatriculate() {

    }

    public String toString() {
        return super.toString() + "\n" +
                "Matriculation: " + matriculation() + "\n" +
                "Semester: " + currentSemester();
    }
}
