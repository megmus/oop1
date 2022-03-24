package de.mome.javaprofis.oop.univ.domain;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Univ implements IUniv {

    private final static List<IUniMember> UNI_MEMBERS = new ArrayList<>();

    @Override
    public IStaffRO addNewStudent(final String firstname, final String lastname, final String birthdate) {
        final Student newStudent = new Student(firstname, lastname, birthdate);
        UNI_MEMBERS.add(newStudent);
        return new UniStaff(newStudent);
    }

    @Override
    public IStaffRO addNewInstructor(final String firstname, final String lastname, final String birthdate, final Faculty faculty) {
        final Instructor newInstructor = new Instructor(firstname, lastname, birthdate, faculty.value(), office(faculty));
        UNI_MEMBERS.add(newInstructor);
        return new UniStaff(newInstructor);
    }

    @Override
    public List<IStaffRO> currentStaff() {
        final List<IStaffRO> staff = new ArrayList<>(UNI_MEMBERS.size());
        final Iterator<IUniMember> iterator = UNI_MEMBERS.iterator();
        while(iterator.hasNext()){
            staff.add(new UniStaff(iterator.next())) ;
        }
        return staff;
    }

    @Override
    public List<IStaffRO> staffByStat(IStaffRO.Staffstatus status) {
        return null;
    }

    public String office(final Faculty faculty) {
        return new StringBuilder(faculty.code()).append("-").append(RandomUtils.nextInt()).toString();
    }

}
