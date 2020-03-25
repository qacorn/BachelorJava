package com.class2018092605.lazySingleton;

public class IdentityCardNo
{
	private static IdentityCardNo instance=null;
	private String no;
	
	private IdentityCardNo()
	{	
	}
	
	public static IdentityCardNo getInstance()
	{
		if(instance==null)
		{
			System.out.println("???????????????????????");
		    instance=new IdentityCardNo();
		    instance.setIdentityCardNo("No400011112222");		
		}
		else
		{
			System.out.println("?????????????????????");  
		}
		return instance;
	}
	
	private void setIdentityCardNo(String no)
	{
	    this.no=no;
	}
	
	public String getIdentityCardNo()
	{
		return this.no;
	}
	
}