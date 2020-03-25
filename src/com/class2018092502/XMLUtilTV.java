package com.class2018092502;

import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.*;
public class XMLUtilTV
{
    //�÷������ڴ�XML�����ļ�����ȡƷ�����ƣ������ظ�Ʒ������
	public static String getBrandName()
	{
		try
		{
			//�����ĵ�����
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;							
			doc = builder.parse(new File("D:\\790005IdeaJavaProject\\SpongeClass1.2\\src\\main\\java\\com\\class2018092502\\configTV.xml"));
		
			//��ȡ����Ʒ�����Ƶ��ı��ڵ�
			NodeList nl = doc.getElementsByTagName("brandName");
            Node classNode=nl.item(0).getFirstChild();
            String brandName=classNode.getNodeValue().trim();
            return brandName;
           }   
           	catch(Exception e)
           	{
           		e.printStackTrace();
           		return null;
           	}
		}
}
