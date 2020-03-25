package com.class2018092602;

public class HisenseTVFactory implements TVFactory
{
    public TV produceTV()
    {
    	System.out.println("���ŵ��ӻ������������ŵ��ӻ���");
    	return new HisenseTV();
    }
}