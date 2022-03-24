package de.mome.javaprofis.oop.univ.tmp;

public class EnumClass implements Comparable<EnumClass> {

    public static final EnumClass ENUM_CLASS_1 = new EnumClass(1, "EnumClass 1");
    public static final EnumClass ENUM_CLASS_2 = new EnumClass(2, "EnumClass 2");
    public static final EnumClass ENUM_CLASS_3 = new EnumClass(3, "EnumClass 3");

    private int code;
    private String description;

    private EnumClass(final int code, final String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(EnumClass enumClass) {
        if (enumClass == null) {
            return 1;
        }
        return (this.getCode() - enumClass.code);
    }
}
