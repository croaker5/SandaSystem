package com.package1;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 

import java.util.Vector;
  
import javax.swing.JOptionPane; 
import javax.swing.*;  
import javax.swing.table.*;  

  
//写一个类，用来与数据库建立连接，并且查询数据  
class GetSQL {  
    // 设定用户名和密码  
    static String userword;  
    static String pwd;  
      
    static int rank;
    static int score;
    static String num;  
    static String name; 
    static String sex;
    static int weight;
    static String experience;
  
    static Connection ct = null;  
    static PreparedStatement ps = null;  
    static ResultSet rs = null;  
  
    // 用于连接数据库的方法，可用于子类的继承  
    public static void ConnectSQL() {  
        try {  
        	 Class.forName("com.mysql.jdbc.Driver");  
        	 ct=DriverManager.getConnection( "jdbc:mysql://localhost:3306/studentmanager?useUnicode=true&characterEncoding=UTF-8","root","6171951");
            System.out.println("The SQL is connected");  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
    }  
  
    // 用于向数据库进行查询的方法  
    public static void querystu(String username) {  
        // 创建火箭车  
        try {  
            ps = ct.prepareStatement("select * from studentusers where 用户名=? ");  
            // 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式    
            ps.setString(1, username);  
            // ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集  
            rs = ps.executeQuery();  
            // 循环取出  
            if (rs.next()) {  
                // 将教师的用户名和密码取出  
                userword = rs.getString(2);  
                pwd = rs.getString(3);  
                System.out.println("成功获取到密码和用户名from数据库");  
                System.out.println(userword + "\t" + pwd + "\t");  
            }else  
            {  
                JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);  
            }  
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
    }  
    //在教师表中进行查询  
    public static void querytea(String name ) {  
        // 创建火箭车  
        try {  
            ps = ct.prepareStatement("select * from teacherusers where 用户名=? ");  
            // 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式    
            ps.setString(1, name);  
            // ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集  
            rs = ps.executeQuery();  
            // 循环取出  
            if (rs.next()) {  
                // 将教师的用户名和密码取出  
                userword = rs.getString(2);  
                pwd = rs.getString(3);  
                System.out.println("成功获取到密码和用户名from数据库");  
                System.out.println(userword + "\t" + pwd + "\t");  
            }else  
            {
                JOptionPane.showMessageDialog(null, "没有此用户，请重新输入！", "提示消息", JOptionPane.WARNING_MESSAGE);  
            }  
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
    }  
  
    //从数据库中根据学号或者教工号来查询数据，并且填入表格。  
    public static void getdatastu(String s) {  
        // 创建火箭车  
        try {  
            ps = ct.prepareStatement("select * from students where  姓名 =? ");  
            // 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式  
            ps.setString(1, s);  
            // ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集  
            rs = ps.executeQuery();  
            if(rs.next())     
            {  
                // 将性别，体重级别，比赛经历取出  
            	name = s;
            	rank = rs.getInt(1);
            	score = rs.getInt(3);
                sex = rs.getString(4);  
                weight = rs.getInt(5);  
                experience = rs.getString(6);
                
            }else  
            {  
                JOptionPane.showMessageDialog(null, "沒有此学生，请重新输入", "提示消息", JOptionPane.WARNING_MESSAGE);  
            }  
      
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
    }  
   
   public static JTable ResultToJatable (){
	   try { 
		   Vector<Vector<Object>> list = new Vector<Vector<Object>>();
		   GetSQL.ConnectSQL();
           ps = ct.prepareStatement("select * from students order by 积分 desc");   
           // ResultSet结果集,大家可以把ResultSet理解成返回一张表行的结果集  
           rs = ps.executeQuery();  
           while(rs.next())     
           {  
               // 将性别，体重级别，比赛经历取出  
        	Vector<Object> vTemp = new Vector<Object>();
        	vTemp.add(rs.getInt(1));
        	vTemp.add(rs.getString(2));
        	vTemp.add(rs.getInt(3));
        	vTemp.add(rs.getString(4)); 
        	vTemp.add(rs.getInt(5));  
        	vTemp.add(rs.getString(6));
        	list.add(vTemp);
           }
           Vector<String> columns = new Vector<String>();
           columns.add("排名");
           columns.add("姓名");
           columns.add("积分");
           columns.add("性别");
           columns.add("体重级别（kg）");
           columns.add("比赛经历");
           
           DefaultTableModel model = new DefaultTableModel(list,columns); 
           JTable table = new JTable(model);
           return table;
     
       } catch (Exception e1) {  
           // TODO Auto-generated catch block  
           e1.printStackTrace();  
           return new JTable();
       } 
	   
   }
      
 
   public static Boolean InserttoTable(String name,int score,String sex,int weight,String experience){
	   try {  
           ps = ct.prepareStatement("insert into students values(?,?,?,?,?,?)");  
           // 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式   
           ps.setInt(1, 0);
           ps.setString(2, name);
           ps.setInt(3, score);
           ps.setString(4,sex);
           ps.setInt(5, weight);
           ps.setString(6, experience);
           ps.executeUpdate();
           ps = ct.prepareStatement("select * from students order by 积分 desc");
           rs = ps.executeQuery();
           int i = 1;
           ps = ct.prepareStatement("update students set 排名=? where 姓名=?");
           while(rs.next())     
           {  
        	   ps.setInt(1, i);
        	   ps.setString(2, rs.getString(2));
        	   ps.executeUpdate();
        	   i++;
           }
           return true;
         
       } catch (Exception e1) {  
           // TODO Auto-generated catch block  
           e1.printStackTrace(); 
           return false;
           
       }  
	   
	   
   } 
   public static Boolean Deletestudent (String name){
	   try {  
           ps = ct.prepareStatement("delete from students where 姓名 = ?");  
           // 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式   
           ps.setString(1, name);
           ps.executeUpdate();
           Sortstudent();
           return true;
         
       } catch (Exception e1) {  
           // TODO Auto-generated catch block  
           e1.printStackTrace(); 
           return false;
           
       }  
	   
   }
   public static Boolean Modifyscores(String name,int score,String experience){
	   try {  
           ps = ct.prepareStatement("update students set 积分 = 积分+?,比赛经历 = CONCAT(比赛经历,?) where 姓名 = ? ");  
           // 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式   
           ps.setInt(1, score);
           ps.setString(2, experience);
           ps.setString(3,name);
           ps.executeUpdate();
           Sortstudent();
           return true;
         
       } catch (Exception e1) {  
           // TODO Auto-generated catch block  
           e1.printStackTrace(); 
           return false;
           
       }  
	   
	   
   }
   public static void Sortstudent (){
	   try {
	   ps = ct.prepareStatement("select * from students order by 积分 desc");
       rs = ps.executeQuery();
       int i = 1;
       ps = ct.prepareStatement("update students set 排名=? where 姓名=?");
       while(rs.next())     
       {  
    	   ps.setInt(1, i);
    	   ps.setString(2, rs.getString(2));
    	   ps.executeUpdate();
    	   i++;
       }
	   }catch (Exception e)
	   {
		   e.printStackTrace(); 
   }
 }   
   public static void updatetable(JPanel jp){
	   jp.removeAll();
	   JTable jtb = ResultToJatable();
	   jp.add(jtb);
	   
	   
   }
 public static void Clearalldatas(){
	 try {  
         ps = ct.prepareStatement("delete from students");  
         // 给?赋值(可防止SQL注入漏洞问题)，不要直接使用拼接的方式   
         ps.executeUpdate();
     } catch (Exception e1) {  
         // TODO Auto-generated catch block  
         e1.printStackTrace(); 
  }
 }
	 
	   
   }
