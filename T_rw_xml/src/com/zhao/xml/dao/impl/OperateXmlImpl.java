package com.zhao.xml.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import com.zhao.xml.bean.Student;
import com.zhao.xml.dao.OperateXML;

public class OperateXmlImpl implements OperateXML {

	@Override
	public void writeXml(String path, Student stu) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteNode(String path, String node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateXml(String path, Student stu) throws Exception {
		Document doc = getDoc(path);
		
		Element node = this.findNode(path, stu.getName()); 
	//	if(node ==null)
		//	return false ;
		
		
	}

	@Override
	public List<Student> listXml(String path) throws Exception {
		Document doc = getDoc(path);
		Element rootElement = doc.getRootElement();
		List<Element> list = rootElement.elements("student");
		List<Student> stuList = new ArrayList<>() ;
		for(Element e:list) {
			String name = e.attributeValue("name");  
			String sex = e.elementText("sex"); // 获取子元素
			String age = e.elementText("age");
			Student stu = new Student() ;
			stu.setName(name); stu.setAge(age); stu.setSex(sex); 
			stuList.add(stu) ;
		}
		return stuList;
	}

	@Override
	public Element findNode(String path, String name)  throws Exception{
		
		Document doc =getDoc(path) ;
		
		String xpath = "//students[@name='"+name+"']";
		Element nameNode = (Element)doc.selectSingleNode(xpath);
		
		return nameNode;
	}
	
	private  Document getDoc(String path) throws Exception{
		InputStream in = new FileInputStream(new File(path));
		SAXReader reader = new SAXReader();
		Document doc = reader.read(in);
		return doc ;
	}

}
