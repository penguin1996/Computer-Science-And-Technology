package src.com.clone.shallow;

public class StudentShallow implements Cloneable{

    private String name;

    private int age;

    private MajorShallow majorShallow;

    public MajorShallow getMajorShallow() {
        return majorShallow;
    }

    public void setMajorShallow(MajorShallow majorShallow) {
        this.majorShallow = majorShallow;
    }

    public StudentShallow(String name, int age, MajorShallow majorShallow) {
        this.name = name;
        this.age = age;
        this.majorShallow = majorShallow;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }

    @Override
    public String toString() {
        return "StudentDeep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", majorDeep=" + majorShallow +
                '}';
    }
}
