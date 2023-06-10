package CustomizedDBMS;
import java.lang.*;
import java.util.*;

class program370
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();
        dobj.StartDBMS();

        dobj.InsertData("Shreyash",1000);
        dobj.InsertData("Sachin",10000);
        dobj.InsertData("Shruti",5000);
        dobj.InsertData("Aishwarya",100000);
        dobj.InsertData("Janhavi",50000);

        dobj.DisplayAll();

        System.out.println();
        dobj.AggregateMax();
        dobj.AggregateMin();
        dobj.AggregateSum();
        dobj.AggregateAvg();
        dobj.AggregateCount();
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

    //  static block
    static      // executes before the constructor
    {
        Generator = 0;
    }

    //  Constuctor
    public Student(String str, int value)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }

    public void DisplayData()
    {
        System.out.println(this.RID + "\t" + this.Name + "\t\t" + this.Salary);
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

    public void InsertData(String str,int value)
    {
        Student sobj = new Student(str,value);
        lobj.add(sobj);
    }

    //  Display all without condition
    public void DisplayAll()
    {
        for(Student sref : lobj)
        {
            sref.DisplayData();
        }
    }

    //  Display by RID
    public void DisplaySpecific(int rid)
    {
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.DisplayData();
                break;
            }
        }
    }

    //  Display by Name
    public void DisplaySpecific(String str)
    {
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
            }
        }
    }

    //  Delete bt RID
    public void DeleteSpecific(int rid)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    //  Delete by Name
    public void DeleteSpecific(String str)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                lobj.remove(index);
            }
            index++;
        }
    }

    public void AggregateMax()
    {
        int iMax = 0;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary >= iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of the student having max salary :");
        temp.DisplayData();
    }

    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary <= iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of the student having min salary :");
        temp.DisplayData();
    }

    public void AggregateSum()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Summation of salaries is : "+iSum);
    }

    public void AggregateAvg()
    {
        int iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Average salary of Students is : " + iSum/(lobj.size()));
    }

    public void AggregateCount()
    {
        System.out.println("Count of students is : " + lobj.size());
    }
}