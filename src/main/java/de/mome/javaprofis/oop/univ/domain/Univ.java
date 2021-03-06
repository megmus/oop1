package de.mome.javaprofis.oop.univ.domain;

import de.mome.javaprofis.oop.univ.data.StaffVO;
import lombok.NonNull;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Univ implements IUniv {

    private final static List<IUniMember> UNI_MEMBERS = new ArrayList<>();

    @Override
    public IStaffRO addNewStudent(@NonNull final StaffVO staffVO) {
        final Student newStudent = new Student(staffVO.getFirstname(), staffVO.getLastname(), staffVO.getBirthdate());
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
        while (iterator.hasNext()) {
            staff.add(new UniStaff(iterator.next()));
        }
        return staff;
    }

    @Override
    public List<IStaffRO> staffByStat(final IStaffRO.Staffstatus status) {
        final List<IStaffRO> staffWithStatus = new ArrayList<>();
        final Iterator<IUniMember> iterator = UNI_MEMBERS.stream().filter(areStudents(status)).toList().iterator();
        while (iterator.hasNext()) {
            staffWithStatus.add(new UniStaff(iterator.next()));
        }
        return staffWithStatus;
    }

    private Predicate<? super IUniMember> areStudents(final IStaffRO.Staffstatus status) {
        return iUniMember -> iUniMember.currentStatus() == status;
    }

    public String office(final Faculty faculty) {
        return new StringBuilder(faculty.code()).append("-").append(RandomUtils.nextInt()).toString();
    }

}
