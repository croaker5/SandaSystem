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

  
//дһ���࣬���������ݿ⽨�����ӣ����Ҳ�ѯ����  
class GetSQL {  
    // �趨�û���������  
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
  
    // �����������ݿ�ķ���������������ļ̳�  
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
  
    // ���������ݿ���в�ѯ�ķ���  
    public static void querystu(String username) {  
        // ���������  
        try {  
            ps = ct.prepareStatement("select * from studentusers where �û���=? ");  
            // ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ    
            ps.setString(1, username);  
            // ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����  
            rs = ps.executeQuery();  
            // ѭ��ȡ��  
            if (rs.next()) {  
                // ����ʦ���û���������ȡ��  
                userword = rs.getString(2);  
                pwd = rs.getString(3);  
                System.out.println("�ɹ���ȡ��������û���from���ݿ�");  
                System.out.println(userword + "\t" + pwd + "\t");  
            }else  
            {  
                JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);  
            }  
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
    }  
    //�ڽ�ʦ���н��в�ѯ  
    public static void querytea(String name ) {  
        // ���������  
        try {  
            ps = ct.prepareStatement("select * from teacherusers where �û���=? ");  
            // ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ    
            ps.setString(1, name);  
            // ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����  
            rs = ps.executeQuery();  
            // ѭ��ȡ��  
            if (rs.next()) {  
                // ����ʦ���û���������ȡ��  
                userword = rs.getString(2);  
                pwd = rs.getString(3);  
                System.out.println("�ɹ���ȡ��������û���from���ݿ�");  
                System.out.println(userword + "\t" + pwd + "\t");  
            }else  
            {
                JOptionPane.showMessageDialog(null, "û�д��û������������룡", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);  
            }  
        } catch (Exception e1) {  
            // TODO Auto-generated catch block  
            e1.printStackTrace();  
        }  
    }  
  
    //�����ݿ��и���ѧ�Ż��߽̹�������ѯ���ݣ�����������  
    public static void getdatastu(String s) {  
        // ���������  
        try {  
            ps = ct.prepareStatement("select * from students where  ���� =? ");  
            // ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ  
            ps.setString(1, s);  
            // ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����  
            rs = ps.executeQuery();  
            if(rs.next())     
            {  
                // ���Ա����ؼ��𣬱�������ȡ��  
            	name = s;
            	rank = rs.getInt(1);
            	score = rs.getInt(3);
                sex = rs.getString(4);  
                weight = rs.getInt(5);  
                experience = rs.getString(6);
                
            }else  
            {  
                JOptionPane.showMessageDialog(null, "�]�д�ѧ��������������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);  
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
           ps = ct.prepareStatement("select * from students order by ���� desc");   
           // ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����  
           rs = ps.executeQuery();  
           while(rs.next())     
           {  
               // ���Ա����ؼ��𣬱�������ȡ��  
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
           columns.add("����");
           columns.add("����");
           columns.add("����");
           columns.add("�Ա�");
           columns.add("���ؼ���kg��");
           columns.add("��������");
           
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
           // ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ   
           ps.setInt(1, 0);
           ps.setString(2, name);
           ps.setInt(3, score);
           ps.setString(4,sex);
           ps.setInt(5, weight);
           ps.setString(6, experience);
           ps.executeUpdate();
           ps = ct.prepareStatement("select * from students order by ���� desc");
           rs = ps.executeQuery();
           int i = 1;
           ps = ct.prepareStatement("update students set ����=? where ����=?");
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
           ps = ct.prepareStatement("delete from students where ���� = ?");  
           // ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ   
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
           ps = ct.prepareStatement("update students set ���� = ����+?,�������� = CONCAT(��������,?) where ���� = ? ");  
           // ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ   
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
	   ps = ct.prepareStatement("select * from students order by ���� desc");
       rs = ps.executeQuery();
       int i = 1;
       ps = ct.prepareStatement("update students set ����=? where ����=?");
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
         // ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ   
         ps.executeUpdate();
     } catch (Exception e1) {  
         // TODO Auto-generated catch block  
         e1.printStackTrace(); 
  }
 }
	 
	   
   }
