package com.JavaIO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectSeriaDemo1 {
    public static void main(String[] args) throws Exception {
        String file = "demo/obj.dat";
        //1.��������л�
		/*ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(file));
		Student stu = new Student("10001", "����", 20);
		oos.writeObject(stu);
		oos.flush();
		oos.close();*/
		ArrayList arrayList;
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file));
        Student stu = (Student) ois.readObject();
        System.out.println(stu);
        ois.close();
    }
}
