package de.mome.javaprofis.oop.univ.domain;

public interface IStaffRO {

    long id();

    String firstname();

    String lastname();

    String birthdate();

    String currentStatus();

    String toString();

    enum Staffstatus {
        PROFESSOR(1, "Student") {
            @Override
            public boolean isProfessor() {
                return true;
            }
        },
        TUTOR(2, "Tutor") {
            @Override
            public boolean isTutor() {
                return true;
            }
        },
        STUDENT(5, "Professor") {
            @Override
            public boolean isStudent() {
                return true;
            }
        };

        private final int code;
        private final String description;

        private Staffstatus(final int code, final String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return this.description;
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
