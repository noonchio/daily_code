package lambda;

import java.util.*;

public class Main {

    public static void main(String[] args) {
       new Thread(() -> {
           System.out.println("Printing from the Runnable");
           System.out.println("Line 2");
           System.out.println("Line 3");
       }).start();
       // Each lambda expression has three parts: first one is the argument list, second is the arrow token , third the body
       // Functional Interfaces - An interface that contains exactly one abstract method i.e. SAM interfaces Single Abstract Method Interfaces.

    Employee john = new Employee("John Doe", 30);
    Employee tim  = new Employee("Timmy Doe", 30);
    Employee mat  = new Employee("Matty Doe", 30);
    Employee bob  = new Employee("Bobby Doe", 30);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(mat);
        employees.add(bob);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        });

        Collections.sort(employees, (o1, o2) -> o1.getName().compareTo(o2.getName()));

        for(Employee employee : employees) {
            System.out.println(employee.getName());
        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toLowerCase() + s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//
//        System.out.println(sillyString);

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();

        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());

        System.out.println(sillyString);

    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
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

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}

