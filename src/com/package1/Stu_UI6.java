package com.package1;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
public class Stu_UI6 extends JFrame implements ActionListener {
    JLabel jl,jl2 = null;
    JTextField jtf = null;
    JButton jb = null;
    JPanel jp1,jp2,jp5 =null;
   
    DefaultTableModel model = null;  
    JTable table = null;  
    JScrollPane jsp = null;

    
    // 构造函数  
    public Stu_UI6() {  
        // 创建组件       
    	  
        jl = new JLabel("请输入姓名：");     
          
        jl2=new JLabel("学生信息表：");  
          
        jtf = new JTextField(10);  
          
        jb = new JButton("查询");  
         
        // 设置监听  
        jb.addActionListener(this);  
        
        // 设置表格1  
        table = GetSQL.ResultToJatable();  
        jsp = new JScrollPane(table);  
        jp1 = new JPanel();  
        jp2 = new JPanel();  
        jp5 = new JPanel();  
        jp5.setLayout(new BorderLayout());   
  
        jp1.add(jl);  
        jp1.add(jtf);  
        jp1.add(jb);  
        jp1.setLayout(new FlowLayout(FlowLayout.LEFT));  
        jp1.setPreferredSize(new Dimension(20,20));  
        jp2.add(jsp);  
    
        jp5.add(jl2,BorderLayout.NORTH);  
    
        this.add(jp1);  
        this.add(jp5);  
        this.add(jp2);  
       
          
        this.setLayout(new GridLayout(3, 1));  
        this.setTitle("散打积分排名系统—学生");  
        this.setSize(500, 500);  
        this.setLocation(150, 150);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  
        this.setResizable(true);  
          
    }
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
  
        if (e.getActionCommand().equals("查询")  &&!jtf.getText().isEmpty()) {                         
            // 当点击查询按钮时，首先与数据库建立连接  
            GetSQL.ConnectSQL();  
            GetSQL.getdatastu(jtf.getText());  
            jtf.setText("");  
            Search tmp =new Search();              
        }else 
       {
            JOptionPane.showMessageDialog(null , "请输入要查询的学生姓名","提示消息",JOptionPane.WARNING_MESSAGE);  
        }  
  
    }  
}