package de.mome.javaprofis.oop;

import de.mome.javaprofis.oop.univ.domain.IStaffRO;
import de.mome.javaprofis.oop.univ.domain.IUniv;
import de.mome.javaprofis.oop.univ.domain.Univ;

import java.util.List;

/**
 * Hello world!
 */
public class UniApplication {

    public static void main(String[] args) {

        final IUniv tum = new Univ();
        final IStaffRO mome = tum.addNewStudent("Mostapha", "Megaiz", "20.08.1973");
        final IStaffRO angilae = tum.addNewStudent("Angila", "Paikar", "17.07.1976");
        final IStaffRO schlichter = tum.addNewInstructor("Johann", "Schlichter", "01.01.1950", IUniv.Faculty.COMPUTESC);


        final List<IStaffRO> uniStaff = tum.currentStaff();
        uniStaff.stream().forEach(univMember -> System.out.println(univMember.toString()));

        System.out.println("\n###################\nThe list of tum stundents");
        final List<IStaffRO> students = tum.staffByStat(IStaffRO.Staffstatus.STUDENT);
        students.stream().forEach(student -> System.out.println(student));

        System.out.println("\n+++++++++++++++++++\nThe list of tum professors");
        final List<IStaffRO> professorts = tum.staffByStat(IStaffRO.Staffstatus.PROFESSOR);
        professorts.stream().forEach(student -> System.out.println(student));
    }

}
