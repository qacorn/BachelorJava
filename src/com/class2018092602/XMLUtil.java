package com.class2018092602;

import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.*;
public class XMLUtil
{
//�÷������ڴ�XML�����ļ�����ȡ������������������һ��ʵ������
	public static Object getBean()
	{
		try
		{
			//�����ĵ�����
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;							
			doc = builder.parse(new File("D:\\790005IdeaJavaProject\\SpongeClass1.2\\src\\main\\java\\com\\class2018092602\\config.xml"));
		
			//��ȡ�����������ı��ڵ�
			NodeList nl = doc.getElementsByTagName("className");
            Node classNode=nl.item(0).getFirstChild();
            String cName=classNode.getNodeValue();
            
            //ͨ����������ʵ�����󲢽��䷵��
			System.out.println("cName==" + cName);
            Class c=Class.forName(cName);
	  	    Object obj=c.newInstance();
            return obj;
           }   
           	catch(Exception e)
           	{
           		e.printStackTrace();
           		return null;
           	}
		}
}
