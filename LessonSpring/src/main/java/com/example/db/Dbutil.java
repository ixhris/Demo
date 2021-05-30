package com.example.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.LogInfo;
import com.example.demo.Score;
import com.example.demo.Student;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;;

public class Dbutil {
	
    public Connection getDbConnection() {
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/animal?characterEncoding=utf-8", "root", "zhenxi1127");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
    
//    public LogInfo getLogInfo() {
//    	
//    	LogInfo loginfo = null;
//    	try {
//    		Connection conn = getDbConnection();
//			Statement stmt = (Statement) conn.createStatement();
//			ResultSet rSet = stmt.executeQuery("select * from t_loginInfo ");
//			if(rSet.next()) {
//				loginfo = new LogInfo();
//				loginfo.setLoginId(rSet.getString("loginId"));
//				loginfo.setPassword(rSet.getString("password"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//    	
//    	return loginfo;
//    }
    
  //按条件获取学生信息
    public List<Student> stuList(String where) {
    	List<Student> students = new ArrayList<Student>();
    	try {
    		Connection conn = getDbConnection();
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rSet = stmt.executeQuery("select * from t_student " + where);
			while(rSet.next()) {
				Student student = new Student();
				student.setId(rSet.getInt("id"));
				student.setName(rSet.getString("name"));
				student.setAge(rSet.getInt("age"));
				student.setSex(rSet.getString("sex").toCharArray()[0]);
				student.setGrade(rSet.getInt("grade"));
				student.setClassId(rSet.getInt("classId"));
				students.add(student);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    	return students;
    }
    
    
    
    //获取学生信息
    public List<Student> getStudent() {
    	List<Student> students = new ArrayList<Student>();
    	try {
    		Connection conn = getDbConnection();
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rSet = stmt.executeQuery("select * from t_student ");
			while(rSet.next()) {
				Student student = new Student();
				student.setId(rSet.getInt("id"));
				student.setName(rSet.getString("name"));
				student.setAge(rSet.getInt("age"));
				student.setSex(rSet.getString("sex").toCharArray()[0]);
				student.setGrade(rSet.getInt("grade"));
				student.setClassId(rSet.getInt("classId"));
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return students;
    }
    //获取表中是登录信息
    public List<LogInfo> getLogInfos(){
    	List<LogInfo> logInfos = new ArrayList<LogInfo>();
    	
    	try {
    		Connection conn = getDbConnection();
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rSet = stmt.executeQuery("select * from t_loginInfo ");
			while(rSet.next()) {
				LogInfo logInfo = new LogInfo();
				
				logInfo.setLoginId(rSet.getString("loginId"));
				logInfo.setPassword(rSet.getString("password"));
				logInfos.add(logInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return logInfos;
    }
    //添加登录信息
    public void addLogInfo(String username,String password) {
    	
    	try {
			Connection connection = getDbConnection();
			Statement statement = (Statement) connection.createStatement();
			statement.execute("insert into t_loginInfo(loginId,password) "
					                         + "values('"+username+"','"+password+"')");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    //查询学生信息
    public Student searchStu(String id) {
    	Student student = null;
    	try {
			Connection conn = getDbConnection();
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rSet = stmt.executeQuery("select * from t_student,t_score "
					                           + "where t_student.id=t_score.id and t_student.id=" + id);
    	if (rSet.next()) {
    		student = new Student();
    		Score score = new Score();
    		student.setId(rSet.getInt("id"));
    		student.setName(rSet.getString("name"));
    		student.setAge(rSet.getInt("age"));
			student.setSex(rSet.getString("sex").toCharArray()[0]);
			student.setGrade(rSet.getInt("grade"));
			student.setClassId(rSet.getInt("classId"));
			score.setPeriod(rSet.getInt("period"));
			score.setMath(rSet.getInt("math"));
			score.setEng(rSet.getInt("eng"));
			score.setPhy(rSet.getInt("phy"));
			student.setScore(score);
		   }
    	}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	return student;
    }
    //添加学生信息
    public void insertStu(int id,String name,int age,char sex,int grade,int classId) {
    	try {
			Connection connection = getDbConnection();
			Statement statement = (Statement) connection.createStatement();
			statement.execute("insert into t_student(id,name,age,sex,grade,classId) "
					                         + "values('"+id+"','"+name+"','"+age+"','"+sex+"','"+grade+"','"+classId+"')");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    //添加学生成绩
    public void insertScore(int id,int period,int math,int eng,int phy) {
    	try {
			Connection connection = getDbConnection();
			Statement statement = (Statement) connection.createStatement();
			statement.execute("insert into t_score(id,period,math,eng,phy) "
					                         + "values('"+id+"','"+period+"','"+math+"','"+eng+"','"+phy+"')");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    //更改学生信息
    public void updateStu(int id,String name,int age,char sex,int grade,int classId) {
    	try {
			Connection connection = getDbConnection();
			Statement statement = (Statement) connection.createStatement();
			statement.execute("update t_student set name='"+name+"',age='"+age+"',"
					                         + "sex='"+sex+"',grade='"+grade+"',classId='"+classId+"' where id='"+id+"'");
        } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
  //更改学生成绩
    public void updateScore(int id,int period,int math,int eng,int phy) {
    	try {
			Connection connection = getDbConnection();
			Statement statement = (Statement) connection.createStatement();
			statement.execute("update t_score set period='"+period+"',math='"+math+"',eng='"+eng+"',phy='"+phy+"' "
					                         + "where id='"+id+"'");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    //删除学生数据
    public void deleteStu(int id) {
    	try {
			Connection connection = getDbConnection();
			Statement statement = (Statement) connection.createStatement();
			statement.execute("delete from t_student,t_score using t_student, t_score "
					+ "where t_student.id=t_score.id and t_student.id="+id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }





}
