package CustomizedDBMS;
import java.lang.*;
import java.util.*;

class program372
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
        System.out.printf("%3s" ,"-");
        for(int i=0 ; i < 28 ; i++)
        {
            System.out.printf("%s", "--");
        }
        System.out.println();

        System.out.printf("  %-5s %-5d %-5s %-20s %-5s %-10d %-5s\n","|" ,this.RID , "|" , this.Name , "|" ,this.Salary, "|");

        System.out.printf("%3s" ,"-");
        for(int i=0 ; i < 28 ; i++)
        {
            System.out.printf("%s", "--");
        }
        System.out.println();
    }

    public void DisplayRID()
    {
        System.out.println(this.RID);
    }

    public void DisplayName()
    {
        System.out.println(this.Name);
    }

    public void DisplaySalary()
    {
        System.out.println(this.Salary);
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
        Scanner scanobj = new Scanner(System.in);

        System.out.println("SP Customized DBMS started successfully...");

        while(true)
        {
            System.out.print("SP DBMS console > ");
            String Query = scanobj.nextLine();
            Query = Query.toLowerCase();

            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            if(QuerySize == 1)
            {
                if("help".equals(tokens[0]))
                {
                    System.out.println("This application is used to demonstrates the customised DBMS");
                    System.out.println("Exit : Terminates the DBMS");
                    System.out.println("Display all data : Select * from Student");
                    System.out.println("Insert data : Insert into Student Name Salary");
                }
                else if("exit".equals(tokens[0]))
                {
                    System.out.println("Thank you for using SP DBMS");
                    break;
                }
            }
            else if(QuerySize == 2)
            {

            }
            else if(QuerySize == 3)
            {

            }
            else if(QuerySize == 4)
            {
                // Select * from Student
                if("select".equals(tokens[0]))
                {
                    if("*".equals(tokens[1]))
                    {
                        DisplayAll();
                    }
                    else if("salary".equals(tokens[1]))
                    {
                        DisplayCol(tokens[1]);
                    }
                    else if("name".equals(tokens[1]))
                    {
                        DisplayCol(tokens[1]);
                    }

                }
            }
            else if(QuerySize == 5)
            {
                // Insert into student Krutika 100000;
                if("insert".equals(tokens[0]))
                {
                    InsertData(tokens[3],Integer.parseInt(tokens[4]));
                }
            }

            // Select * from Student where name = shreyash
            else if(QuerySize == 8)
            {
                if("=".equals(tokens[6]) && "where".equals(tokens[4]))
                {
                    if("select".equals(tokens[0]))
                    {
                        if("*".equals(tokens[1]))
                        {
                            if("rid".equals(tokens[5]))
                            {
                                DisplaySpecific(Integer.parseInt(tokens[7]));
                            }
                            else if("name".equals(tokens[5]))
                            {
                                DisplaySpecific(tokens[7]);
                            }
                            else if("salary".equals(tokens[5]))
                            {
                                DisplaySpecificSal(Integer.parseInt(tokens[7]));
                            }
                        }
                        else if("name".equals(tokens[1]))
                        {

                        }
                    }
                }
            }

        }
    }

    // Insert data
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

    public void DisplaySpecificSal(int salary)
    {
        for(Student sref : lobj)
        {
            if(sref.Salary == salary)
            {
                sref.DisplayData();
            }
        }
    }

    public void DisplayCol(String str)
    {
        for(Student sref : lobj)
        {
            if(str.equals("name"))
            {
                System.out.println(sref.Name);
            }
            else if(str.equals("salary"))
            {
                System.out.println(sref.Salary);
            }
        }
    }

//    public void DisplaySpecific(String str)
//    {
//        for(Student sref : lobj)
//        {
//            if(str.equals(sref.Name))
//            {
//                sref.DisplayData();
//            }
//        }
//    }

    public void DisplayName(String str)
    {
        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
            }
        }
    }

    //  Delete by RID
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