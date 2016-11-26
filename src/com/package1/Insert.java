package com.package1;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
  
public class Insert extends JFrame implements ActionListener {  
  
    // 定义组件  
	JButton jb=null;
    JLabel jl1,jl2,jl3,jl4,jl5,jl6 = null;  
    JPanel jp1, jp2,jp3,jp4,jp5,jp6,jp7= null;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5;
    JPanel jp;
  
     // 构造函数  
    public Insert(JPanel ijp) {  
        // 创建组件     
    	
    	jp = ijp;
        jl1 = new JLabel("姓名：");     
        jl2 = new JLabel("积分：");
        jl3 = new JLabel("性别：");
        jl4 = new JLabel("体重级别：");
        jl5 = new JLabel("比赛经历：");   
        jl6 = new JLabel("请输入：");  
        
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        jtf4 = new JTextField(10);
        jtf5 = new JTextField(10);
        
        jb = new JButton("添加");
        
        jb.addActionListener(this);
       
       
        jp1 = new JPanel();  
        jp2 = new JPanel(); 
        jp3 = new JPanel();  
        jp4 = new JPanel();
        jp5 = new JPanel();  
        jp6 = new JPanel();  
        jp7 = new JPanel(); 
        
        jp1.add(jl6);
        jp2.add(jl1);
        jp2.add(jtf1);
        jp3.add(jl2);
        jp3.add(jtf2);
        jp4.add(jl3);
        jp4.add(jtf3);
        jp5.add(jl4);
        jp5.add(jtf4);
        jp6.add(jl5);
        jp6.add(jtf5);
        jp7.add(jb);
        
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        this.add(jp7);
        
        this.setLayout(new GridLayout(7, 1));  
        this.setTitle("添加学生");  
        this.setSize(500, 500);  
        this.setLocation(150, 150);  
        
        this.setVisible(true);  
        this.setResizable(true);  
       
    }
    public void clear()  
    {  
        jtf1.setText("");  
        jtf2.setText(""); 
        jtf3.setText(""); 
        jtf4.setText(""); 
        jtf5.setText(""); 
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
  
        if (e.getActionCommand().equals("添加")  &&!jtf1.getText().isEmpty()
        		&&!jtf2.getText().isEmpty()&&!jtf3.getText().isEmpty()&&!jtf4.getText().isEmpty()
        		&&!jtf5.getText().isEmpty()&&
        		GetSQL.InserttoTable(jtf1.getText(), Integer.parseInt(jtf2.getText()), jtf3.getText(), Integer.parseInt(jtf4.getText()), jtf5.getText())) {                         
        	
             jp.removeAll();
             JTable ijt = GetSQL.ResultToJatable();
             JScrollPane jsp = new JScrollPane(ijt);
             jp.add(jsp);
             JOptionPane.showMessageDialog(null,"添加成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            
             clear();
                           
        }
        else if(! GetSQL.InserttoTable(jtf1.getText(), Integer.parseInt(jtf2.getText()), jtf3.getText(), Integer.parseInt(jtf4.getText()), jtf5.getText())){  
            JOptionPane.showMessageDialog(null , "出现错误","提示消息",JOptionPane.WARNING_MESSAGE);  
        }  
        else
        	JOptionPane.showMessageDialog(null , "请输入完整信息","提示消息",JOptionPane.WARNING_MESSAGE);  
        }  
}