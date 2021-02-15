import java.util.Scanner;

public class lab2{    
      static class Employee{
         String name,phone,address,salary;
         int age;
         Employee(String name,int age,String phone,String address,String salary){
             this.name = name;
             this.phone = phone;
             this.age = age;
             this.address = address;
             this.salary = salary;
         }
         void printSalary(){
             System.out.println(this.salary);
         }
     }
     class Officer extends Employee{
         String specialization;
         Officer(String name,int age,String phone,String address,String salary,String specialization){
             super(name,age,phone,address,salary);
             this.specialization = specialization;
         }
         
     }
       class Manager extends Employee{
         String department;
         Manager(String name,int age,String phone,String address,String salary,String diepartment){
             super(name,age,phone,address,salary);
             this.department = department;
         }
     }
     //http_proxy="http://test:test@172.16.0.3:3128/"
     abstract class Shape{
         int sides=0;
         void numberOfSides(){};
     }
      class Rectangle extends Shape{
         void numberOfSides(){
            sides = 4;
            System.out.println(this.sides);
         }
     }
      class Triangle extends Shape{
        Triangle(){
            sides = 3;
        }
        void numberOfSides(){
           System.out.println(this.sides);
        }
    }
     class Hexagon extends Shape{
        Hexagon(){
            sides=6;
        }
        void numberOfSides(){
           System.out.println(this.sides);
        }
    }
   

     public static void main(String []args){
          lab2 lab = new lab2();
    //   Employee emp1 = new Employee("hiro",14,"121323","weqwwe","112234");
    //   emp1.printSalary();
        // System.out.println("Officer's - name,age,phone,address,salary,specialization");
        // Scanner input = new Scanner(System.in);
        // String[] of1 = input.nextLine().split(" ", 0); //hiro 14 8948943 327 2832 Hacker
        // Officer of11 = lab.new Officer(of1[0],Integer.parseInt(of1[1]),of1[2],of1[3],of1[4],of1[5]);//"hiro,14,"121323","weqwwe","112234","SSdsd"
        // of11.printSalary();
        // System.out.println("Manager's - name,age,phone,address,salary,department ");
        // String[] mn1 = input.nextLine().split(" ", 0); //hiro 14 8948943 327 2832 CyberSecurity
        // Officer mn11 = lab.new Manager(mn1[0],Integer.parseInt(mn1[1]),mn1[2],mn1[3],mn1[4],mn1[5]);
        // mn11.printSalary();
         Rectangle rect = lab.new Rectangle();
         rect.numberOfSides();
     }
}