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
        System.out.println("Hello World!" + "\n");

        /*final Student momeStd = new Student("Mostapha", "Megaiz", "20.02.2004");
        momeStd.createAddress("St-Wendel-Str. 42", "Munich", "81379");
        System.out.println("Student: " + momeStd);

        final Student angilaStd = new Student("Angila", "Paikar", "17.07.1976");
        System.out.println("\nStudent: " + angilaStd);
        try {
            momeStd.updateBirthdate("20.08.1952");
        } catch (Exception e) {
            System.out.println("Angila birhtdate update not possible; " + e);
        }
        System.out.println("\nstudent birthdate: " + new SimpleDateFormat(Member.BIRTHDATE_FORMATTER).format(momeStd.birthdate()));

        final Member schlichterProf = new Instructor("Johan", "Schlichter", "01.01.1950", "Angewandte Informatik", "13.0.1");
        System.out.println("\nProfessor: " + schlichterProf.toString() +"\n");*/

        /*momeStd.draw(2, 3);
        momeStd.draw((Integer) 2, (Integer) 3);*/
        //mome.draw(Integer.valueOf(2), 3);

        /*final Figure figure = new Figure();
        figure.draw(new Point());*/

        /*final Students students = new Students();
        students.addStudent(momeStd);
        students.addStudent(angilaStd);

        List<Student> studentsList = students.currentValues();
        System.out.println("Students list size before clear: " + studentsList.size());

        studentsList.add(new Student("ret","res", "12.05.1998"));
        System.out.println("Students list size after clear: " + students.currentValues().size());*/

        final IUniv tum = new Univ();
        final IStaffRO mome = tum.addNewStudent("Mostapha", "Megaiz", "20.08.1973");
        final IStaffRO angilae = tum.addNewStudent("Angila", "Paikar", "17.07.1976");
        final IStaffRO schlichter = tum.addNewInstructor("Johann", "Schlichter", "01.01.1950", IUniv.Faculty.COMPUTESC);


        final List<IStaffRO> uniStaff = tum.currentStaff();
        uniStaff.stream().forEach(univMember -> System.out.println(univMember.toString()));
/*
       uniStaff.clear();

       System.out.println("####################################");

       tum.currentStaff().forEach(univMember -> System.out.println(univMember.toString()));*/
    }

    class InternalApp {
        final long matriculation = 1234L;

        long getMatriculation() {
            return matriculation;
        }
    }
}
