package com.an.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public  class Student {
private int id;
private String name;
private int marks1;
private int marks2;
private int marks3;
public Student() {
	super();
}
public Student(int id, String name, int marks1, int marks2, int marks3) {
	super();
	this.id = id;
	this.name = name;
	this.marks1 = marks1;
	this.marks2 = marks2;
	this.marks3 = marks3;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMarks1() {
	return marks1;
}
public void setMarks1(int marks1) {
	this.marks1 = marks1;
}
public int getMarks2() {
	return marks2;
}
public void setMarks2(int marks2) {
	this.marks2 = marks2;
}
public int getMarks3() {
	return marks3;
}
public void setMarks3(int marks3) {
	this.marks3 = marks3;
}
public int addResult() throws Exception{
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Info", "root", "Mehataj@0");
	
	String s="insert into student values(?,?,?,?,?)";
	PreparedStatement psmt=con.prepareStatement(s);
	psmt.setInt(1, id);
	psmt.setString(2, name);
	psmt.setInt(3, marks1);
	psmt.setInt(4, marks2);
	psmt.setInt(5, marks3);
	int row = psmt.executeUpdate();
	if(row==1) {
		return 1;
	}
	return 0;	
}
}
