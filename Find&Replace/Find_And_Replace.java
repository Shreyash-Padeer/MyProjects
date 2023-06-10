// accept two words from user and perform find and replace operation

import java.lang.*;
import java.util.*;

class Find_And_Replace
{
    public static void main(String arg[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter a string");
        String str = sobj.nextLine();

        System.out.print("Find: ");
        String FWord = sobj.nextLine();

        System.out.print("Replace: ");
        String RWord = sobj.nextLine();

        String Arr[] = str.split(" ");

        for(int i=0 ; i< Arr.length ; i++)
        {
            if(Arr[i].equals(FWord))
            {
                Arr[i] = RWord;
            }
            System.out.print(Arr[i]+" ");
        }
    }
}



