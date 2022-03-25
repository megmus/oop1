package de.mome.javaprofis.oop;

import de.mome.javaprofis.oop.univ.domain.IStaffRO;
import de.mome.javaprofis.oop.univ.tmp.EnumClass;
import de.mome.javaprofis.oop.univ.tmp.MySeasonEnum;

import java.nio.file.FileSystemNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EnumApplication {

    public static void main(final String[] ags) {
        final EnumClass enumClass1 = EnumClass.ENUM_CLASS_1;
        final EnumClass enumClass2 = EnumClass.ENUM_CLASS_2;

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

        System.out.println("Enum standard type sort");
        enumStatus.stream().sorted().toList().forEach(staffStatus -> System.out.println(staffStatus.ordinal()));


    }
}
