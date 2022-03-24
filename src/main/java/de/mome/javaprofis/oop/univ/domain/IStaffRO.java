package de.mome.javaprofis.oop.univ.domain;

public interface IStaffRO {

    long id();

    String firstname();

    String lastname();

    String birthdate();

    String currentStatus();

    String toString();

    enum Staffstatus {
        PROFESSOR(1) {
            @Override
            public boolean isProfessor() {
                return true;
            }
        },
        TUTOR(2) {
            @Override
            public boolean isTutor() {
                return true;
            }
        },
        STUDENT(5) {
            @Override
            public boolean isStudent() {
                return true;
            }
        };

        private int statusCode;

        private Staffstatus(final int statusCode) {
            this.statusCode = statusCode;
        }

        public boolean isProfessor() {
            return false;
        }

        public boolean isTutor() {
            return false;
        }

        public boolean isStudent() {
            return false;
        }
    }
}
