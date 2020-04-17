package com.JDK8.old.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/27 12:20
 * @Desc:
 */
public class TestFilter {
    public static void main(String[] args) {
        Person p1 = new Person("zhangsan",12);
        Person p2 = new Person("lisi",52);
        Person p3 = new Person("liuzi",22);
        Person p4 = new Person("lisi",19);

        List<Person> personList = Arrays.asList(p1,p2,p3,p4);
//       List<Person> res =  fillter("lisi",personList);
//        System.out.println(res.size());
//       res.forEach(person -> {
//           System.out.println(person.getAge()+"-"+person.getName());
//       });

       List<Person> res2 = getPersonByAge(19,personList);
       res2.forEach(person -> System.out.println(person.getName()));

       List<Person> res3 = getPersonByCondition(19,personList,(age,persons)->{
           return  persons.stream().filter(person -> person.getAge() > age).collect(Collectors.toList());
       });

        res3.forEach(person -> System.out.println(person.getName()));

    }

    //写一个方法用来，根据name 筛选 list中符合条件的元素，组成一个新的集合
    public static  List<Person> fillter(String userName, List<Person> personList){
        return personList.stream().filter(person -> {return  userName.equalsIgnoreCase(person.getName());})
                .collect(Collectors.toList());
    }

    public static List<Person> getPersonByAge(int age,List<Person> persons){
        BiFunction<Integer,List<Person>,List<Person>> biFunction = (ageTemp,personList)->{
            return  personList.stream().filter(person -> person.getAge() > ageTemp).collect(Collectors.toList());
        };
        return biFunction.apply(age,persons);
    }

    public  static  List<Person> getPersonByCondition(int age, List<Person>personList,
                                                      BiFunction<Integer,List<Person>,List<Person>> biFunctio) {
        return biFunctio.apply(age,personList);
    }
}

class Person {
    private String name;
    private  int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}