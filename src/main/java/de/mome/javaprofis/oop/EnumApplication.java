package de.mome.javaprofis.oop;

import de.mome.javaprofis.oop.univ.domain.IStaffRO;
import de.mome.javaprofis.oop.univ.tmp.EnumClass;

import java.nio.file.FileSystemNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EnumApplication {

    public static void main(final String[] ags) {
        final EnumClass enumClass1 = EnumClass.ENUM_CLASS_1;
        final EnumClass enumClass2 = EnumClass.ENUM_CLASS_2;

        boolean comparing1 = enumClass1 == EnumClass.ENUM_CLASS_1;
        System.out.println("Enum Class 1");
        System.out.println("hashCode - refenrece/variable: " + enumClass1.hashCode());
        System.out.println("hashCode - orginal: "+ EnumClass.ENUM_CLASS_1.hashCode());
        System.out.println("compareTo - not direct: " + comparing1);
        System.out.println("compareTo - direct: " + enumClass1.compareTo(EnumClass.ENUM_CLASS_1));
        System.out.println("compareTo 3 - direct: " + enumClass1.compareTo(EnumClass.ENUM_CLASS_3));

        boolean comparing2 = enumClass2.equals(EnumClass.ENUM_CLASS_2);


        System.out.println("Enum Class 2");
        System.out.println("hashCode - refenrece/variable: " + enumClass2.hashCode());
        System.out.println("hashCode - orginal: "+ EnumClass.ENUM_CLASS_2.hashCode());
        System.out.println("compareTo - no direct: " + comparing2);
        System.out.println("compareTo - direct: " + enumClass2.compareTo(EnumClass.ENUM_CLASS_2));

        final Set<EnumClass> enumClassSet = new TreeSet<>();
        enumClassSet.add(EnumClass.ENUM_CLASS_3);
        enumClassSet.add(enumClass1);
        enumClassSet.add(EnumClass.ENUM_CLASS_2);

        List<EnumClass> enumClassesSorted = enumClassSet.stream().sorted().toList();
        System.out.println("Enum Class sort");
        enumClassesSorted.stream().forEach(myEnum -> System.out.println(myEnum.getCode()));

        final Set<IStaffRO.Staffstatus> enumStatus = new TreeSet<>();
        IStaffRO.Staffstatus tutor = IStaffRO.Staffstatus.TUTOR;
        enumStatus.add(tutor);
        enumStatus.add(IStaffRO.Staffstatus.STUDENT);
        enumStatus.add(IStaffRO.Staffstatus.PROFESSOR);

        System.out.println("Enum standard type tutor");
        System.out.println("hashCode - refenrece/variable" + tutor.hashCode());
        System.out.println("hashCode - orginal: "+ IStaffRO.Staffstatus.TUTOR.hashCode());
        System.out.println("compareTo - direct: " + tutor.compareTo(IStaffRO.Staffstatus.TUTOR));
//        System.out.println("compareTo null- direct: " + tutor.compareTo(null));
        System.out.println("name: " + tutor.name());
        System.out.println("ordinal of tutor: " + tutor.ordinal() + " - code of tutor: " + tutor.getCode());
        System.out.println("ordinal of professor: " + IStaffRO.Staffstatus.PROFESSOR.ordinal() + " - code of professor: " + IStaffRO.Staffstatus.PROFESSOR.getCode());
        System.out.println("ordinal of student: " + IStaffRO.Staffstatus.STUDENT.ordinal() + " - code of student: " + IStaffRO.Staffstatus.STUDENT.getCode());
        System.out.println("Constable name: " + tutor.describeConstable().get().constantName());

        System.out.println("Enum standard type sort");
        enumStatus.stream().sorted().toList().forEach(staffStatus -> System.out.println(staffStatus.getCode()));
    }
}
