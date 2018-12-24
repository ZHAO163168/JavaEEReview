package com.zhao.xml.dao;

import java.util.List;

import org.dom4j.Element;

import com.zhao.xml.bean.Student;

/**
 * 对xml文档的操作。增删改查
 */
public interface OperateXML {
	/**
	 *  给定位置，创建xml文档。
	 * @param path
	 */
	public void writeXml(String path,Student stu); 
	/**
	 *  删除xml中的某个节点
	 * @param path
	 * @param node
	 */
	public void deleteNode(String path,String node );
	/**
	 *  根据学生信息修改xml
	 * @param path
	 * @param stu
	 * @throws Exception 
	 */
	public void updateXml(String path,Student stu) throws Exception;
	
	/**
	 *  遍历xml文档
	 * @param path
	 * @return
	 * @throws Exception 
	 */
	public List<Student> listXml(String path) throws Exception;
	/**
	 *   查找节点。
	 * @param path
	 * @param name
	 * @return
	 * @throws Exception 
	 */
	public Element findNode(String path,String name) throws Exception;
}
