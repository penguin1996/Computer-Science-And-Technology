package src.com.clone.deep;

import src.com.clone.deep.MajorDeep;

public class StudentDeep implements Cloneable{

    private String name;

    private int age;

    private MajorDeep majorDeep;

    public MajorDeep getMajorDeep() {
        return majorDeep;
    }

    public void setMajorDeep(MajorDeep majorDeep) {
        this.majorDeep = majorDeep;
    }

    public StudentDeep(String name, int age, MajorDeep majorDeep) {
        this.name = name;
        this.age = age;
        this.majorDeep = majorDeep;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        StudentDeep studentDeep = (StudentDeep)super.clone();
        studentDeep.majorDeep = (MajorDeep) majorDeep.clone();
        return studentDeep;
    }

    @Override
    public String toString() {
        return "StudentDeep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", majorDeep=" + majorDeep +
                '}';
    }
}
