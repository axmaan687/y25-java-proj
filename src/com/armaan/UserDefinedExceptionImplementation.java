package com.armaan;

public class UserDefinedExceptionImplementation extends Exception
{
	public static final long serialVersionUID = 1L;
	UserDefinedExceptionImplementation()
	{
		
	}
	UserDefinedExceptionImplementation(String ex)
	{
		super(ex);
	}
	public static void main(String[] args) 
	{
		String name[] = {"anu","balu","ramu","sita","ramya"};
		int accno[] = {1245,4567,5689,8975};
		int balance[] = {100000,200000,78000,5000,89000};
		try
		{
			for(int i=0;i<=5;i++)
			{
				System.out.println(name[i]+"\t"+accno[i]+"\t"+balance[i]);
				if(balance[i]<=10000)
				{
					UserDefinedExceptionImplementation obj = new UserDefinedExceptionImplementation("Balance Amount is less than Minimum Account Balance so your account will be suspended. ");
					throw obj;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("User Define Exception Implemented Successfully");
		}
	}

}
