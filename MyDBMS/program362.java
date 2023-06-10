package CustomizedDBMS;
import java.lang.*;
import java.util.*;

class program362
{
    public static void main(String arg[])
    {
        Student obj1 = new Student("Shreyash",1000);
        Student obj2 = new Student("Piyush",2000);
        Student obj3 = new Student("Vishal",5000);
        Student obj4 = new Student("Shubham",16500);

        System.out.printf("%3s" ,"-");

        for(int i=0 ; i < 28 ; i++)
        {
            System.out.printf("%s", "--");
        }

        System.out.println();

        obj1.DisplayData();
        obj2.DisplayData();
        obj3.DisplayData();
        obj4.DisplayData();

        System.out.printf("%3s" ,"-");

        for(int i=0 ; i < 28 ; i++)
        {
            System.out.printf("%s", "--");
        }

        System.out.println();
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

    public void DisplayData()
    {
//        System.out.println(this.RID + "\t" + this.Name + "\t" + this.Salary);
        System.out.printf("  %-5s %-5d %-5s %-20s %-5s %-10d %-5s\n","|" ,this.RID , "|" , this.Name , "|" ,this.Salary, "|");
    }
}