package src.com.clone.deep;

/*
* 深拷贝类似于值传递
* */
public class DeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        MajorDeep majorDeep = new MajorDeep("计算机科学",2015118054);
        StudentDeep studentDeep = new StudentDeep("zc",24,majorDeep);
        StudentDeep studentClone = (StudentDeep) studentDeep.clone();

        //输出信息
        System.out.println(studentDeep == studentClone);
        System.out.println(studentDeep);
        System.out.println(studentClone);

        //根据用户信息
        majorDeep.setMajorName("人工智能");
        majorDeep.setMajorId(2021118036);
        System.out.println(studentDeep);
        System.out.println(studentClone);
    }
}
