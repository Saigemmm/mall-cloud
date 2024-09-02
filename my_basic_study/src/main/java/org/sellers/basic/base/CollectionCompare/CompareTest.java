package org.sellers.basic.base.CollectionCompare;

import java.util.*;

public class CompareTest {

    public static void main(String[] args) {
        Student student1=new Student(118,"张三");
        Student student2=new Student(114,"李四");
        Student student3=new Student(119,"王五");
        Student student4=new Student(110,"赵六");
        List<Student> studentList=new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.forEach(student -> System.out.println("未排序的：" + student.getId() + student.getName()));
        studentList.sort((s1,s2)->{
            if(s1.getId()<s2.getId()){
                return -1;
            }else if(s1.getId()>s2.getId()){
                return 1;
            }
            return 0;
        });
        //此处可忽略，只作为与lambda表达式的参考用
        studentList.sort(new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getId()<o2.getId()){
                    return -1;
                }else if(o1.getId()>o2.getId()){
                    return 1;
                }
                return 0;
            }
        });
        studentList.forEach(student -> System.out.println("已排序的：" + student.getId() + student.getName()));
    }

}
