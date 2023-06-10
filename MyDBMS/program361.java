package CustomizedDBMS;
import java.lang.*;
import java.util.*;

class program361
{
    public static void main(String arg[])
    {
        Student obj1 = new Student("Shreyash",1000);
        System.out.println(obj1.RID);
        System.out.println(obj1.Name);
        System.out.println(obj1.Salary);

        Student obj2 = new Student("Piyush",1000);
        System.out.println(obj2.RID);
        System.out.println(obj2.Name);
        System.out.println(obj2.Salary);
    }
}

// create table student(RID int, Name varchar(255), Salary int);
// Database Table / schema
class Student
{
    public int RID;
    public String Name;
    public int Salary;

    private static int Generator;

    static      // static block executes before the constructor
    {
        Generator = 0;
    }

    public Student(String str, int value)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }
}