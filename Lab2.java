/**
  
  (B) Object Oriented Programming Concepts: Problem on the use of constructors,
  inheritance, method overloading & overriding, polymorphism and garbage
  collection:
  
  4) Write a Java program which creates a class named 'Employee' having the
  following members: Name, Age, Phone number, Address, Salary. It also has a
  method named 'printSalaryegg' which prints the salary of the Employee. Two
  classes 'Officer' and 'Manager' inherits the 'Employee' class. The 'Officer'
  and 'Manager' classes have data members 'specialization' and 'department'
  respectively. Now, assign name, age, phone number, address and salary to an
  officer and a manager by making an object of both of these classes and print
  the same. (Exercise to understand inheritance). 
  
  5) Write a java program to create an abstract class named Shape that contains
  an empty method named numberOfSidesegg. Provide three classes named
  Rectangle, Triangle and Hexagon such that each one of the classes extends the
  class Shape. Each one of the classes contains only the method
  numberOfSidesegg that shows the number of sides in the given geometrical
  structures. (Exercise to understand polymorphism). 
  
  6) Write a Java program to demonstrate the use of garbage collector.
  
  Garbage Collection is process of reclaiming the runtime unused memory
  automatically. In other words, it is a way to destroy the unused objects.
 
  
  How can an object be unreferenced? There are many ways:
  
  By nulling the reference By assigning a reference to another By anonymous
  object etc. Note- 1.The finalize() method is invoked each time before the
  object is garbage collected. This method can be used to perform cleanup
  processing. 2.gc() method The gc() method is used to invoke the garbage collector to perform cleanup processing.
  The gc() is found in System and Runtime classes.
 
 **/

import java.util.*;
public class Lab2 {

	protected abstract class Shape {
		protected int sides;

		void numberOfSides() {
			System.out.println(sides);
		}
	}

	class Rectangle extends Shape {
		Rectangle() {
			sides = 4;
		}
	}

	class Triangle extends Shape {
		Triangle() {
			sides = 3;
		}
	}

	class Hexagon extends Shape {
		Hexagon() {
			sides = 6;
		}
	}

	class Employee {
		String name, phoneNumber, address, salary;
		int age;

		Employee(String name, int age, String phoneNumber, String address, String salary) {
			this.name = name;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.age = age;
			this.salary = salary;
		}

		void printSalary() {
			System.out.println(salary);
		}

		void getData() {
			System.out.printf("\n %s %n %s %s %s \n", name, age, phoneNumber, address, salary);
		}

	}

	class Manager extends Employee {
		String department;
         Manager(String name,int age,String phone,String address,String salary,String diepartment){
             super(name,age,phone,address,salary);
             this.department = department;
         }
	}

	class Officer extends Employee {
		String specialization;
         Officer(String name,int age,String phone,String address,String salary,String specialization){
             super(name,age,phone,address,salary);
             this.specialization = specialization;
         }
	}

	public class TestGarbage {
		public void finalize() {
			System.out.println("object is garbage collected");
		}
	}

	public static void main(String[] args) {
		Lab2 lab = new Lab2();
        // System.out.println("Officer's - name,age,phone,address,salary,specialization");
        // Scanner input = new Scanner(System.in);
        // String[] of1 = input.nextLine().split(" "); //hiro 14 8948943 327 2832 Hacker
        // Officer of11 = lab.new Officer(of1[0],Integer.parseInt(of1[1]),of1[2],of1[3],of1[4],of1[5]);//"hiro,14,"121323","weqwwe","112234","SSdsd"
        // of11.printSalary();
        // System.out.println("Manager's - name,age,phone,address,salary,department ");
        // String[] mn1 = input.nextLine().split(" "); //hiro 14 8948943 327 2832 CyberSecurity
        // Manager mn11 = lab.new Manager(mn1[0],Integer.parseInt(mn1[1]),mn1[2],mn1[3],mn1[4],mn1[5]);
        // mn11.printSalary();
		Rectangle rect = lab.new Rectangle();
		rect.numberOfSides();
		Triangle tria = lab.new Triangle();
		tria.numberOfSides();
		Hexagon hexa = lab.new Hexagon();
		hexa.numberOfSides();
		// Manager mng = lab.new Manager("Nas", 12, "2032323", "Nowhere", "12229222");
		// mng.printSalary();
		// mng.getData();
		// Officer ofc = lab.new Officer("Inspector IPS", 26, "999", "Thrissur", "50K");
		// ofc.getData();
		// TestGarbage s1 = lab.new TestGarbage();
		// TestGarbage s2 = lab.new TestGarbage();
		// s1 = null;
		// s2 = null;
		// System.gc();
	}

}
