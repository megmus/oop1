package de.mome.javaprofis.oop.univ.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public interface IUniv {

    IStaffRO addNewStudent(final String firstname, final String lastname, final String birthdate);

    IStaffRO addNewInstructor(final String firstname, final String lastname, final String birthdate, final Faculty faculty);

    List<IStaffRO> currentStaff();

    List<IStaffRO> staffByStat(IStaffRO.Staffstatus status);

    enum Faculty {
        CHEMISTRY("CH") {
            @Override
            public String value() {
                return "CHEMIE";
            }
        },
        ELECT("ET") {
            @Override
            public String value() {
                return "ELEKTROTECHNICK";
            }
        },
        COMPUTESC("INF") {
            @Override
            public String value() {
                return "INFORMATIK";
            }
        },
        PHYSICS("PHY") {
            @Override
            public String value() {
                return "PHYSIK";
            }
        };
        private final String code;

        private Faculty(String code) {
            this.code = code;
        }

        public String code() {
            return code;
        }

        public String value() {
            return StringUtils.EMPTY;
        }
    }

}

