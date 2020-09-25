package src.com.clone.shallow;

/*
* 浅拷贝 类似于引用传递
* */
public class ShallowClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        MajorShallow majorShallow = new MajorShallow("计算机科学",2015118054);
        StudentShallow studentShallow = new StudentShallow("zc",24, majorShallow);
        StudentShallow studentClone = (StudentShallow) studentShallow.clone();

        //输出信息
        System.out.println(studentShallow == studentClone);
        System.out.println(studentClone);
        System.out.println(studentShallow);

        //根据用户信息
        majorShallow.setMajorName("人工智能");
        majorShallow.setMajorId(2021118036);
        System.out.println(studentShallow);
        System.out.println(studentClone);
    }
}
