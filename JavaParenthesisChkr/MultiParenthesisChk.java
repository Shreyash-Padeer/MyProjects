// Check whether the given expression contains balanced parenthesis.

import java.lang.*;
import java.util.*;

class MultiParenthesisChk
{
    public static void main(String arg[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter the expression : ");
        String str = sobj.nextLine();

        Solution s1 = new Solution();

        boolean bRet = false;

        bRet = s1.Check(str);

        if(bRet == false)
        {
            System.out.println("Expression Imbalanced");
        }
        else
        {
            System.out.println("Expression Balanced");
        }

    }
}

class Solution
{
    public boolean Check(String str)
    {
        char crr[] = str.toCharArray();

        Stack<Character> stack = new Stack<Character>();

        int i=0;
        for(i=0 ; i<crr.length ; i++)
        {
            if(crr[i] == '(' || crr[i] == '[' || crr[i] == '{')
            {
                stack.push(crr[i]);
            }
            else if(crr[i] == ')')
            {
                if(stack.empty())
                {
                    break;
                }
                if(stack.peek() != '(')
                {
                    break;
                }
                stack.pop();
            }
            else if(crr[i] == ']')
            {
                if(stack.empty())
                {
                    break;
                }
                if(stack.peek() != '[')
                {
                    break;
                }
                stack.pop();
            }
            else if(crr[i] == '}')
            {
                if(stack.empty())
                {
                    break;
                }
                if(stack.peek() != '{')
                {
                    break;
                }
                stack.pop();
            }
        }

        if(i == crr.length && stack.empty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}