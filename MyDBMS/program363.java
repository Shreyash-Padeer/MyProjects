package CustomizedDBMS;
import java.lang.*;
import java.util.*;

class program363
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();
        dobj.StartDBMS();
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
        System.out.println(this.RID + "\t" + this.Name + "\t" + this.Salary);
    }
}

class DBMS
{
    public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }

    public void StartDBMS()
    {
        System.out.println("Marvellous Customized DBMS started successfully...");
    }
}