package com.package1;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.awt.Dimension;
public class Teacher6 extends JFrame implements ActionListener {
    JLabel jl,jl2 = null;
    JTextField jtf = null;
    JButton jb = null;
    JPanel jp1,jp2,jp5 =null;
    JMenuBar jmb=null;    
    JMenu jm=null;  
    JMenuItem jmi2,jmi3,jmi4,jmi5=null;
    
    
  
    DefaultTableModel model = null;  
    JTable table = null;  
    JScrollPane jsp = null;

    // 构造函数  
    public Teacher6() {  
        // 创建组件       
    	    jmb=new JMenuBar(); //JMenuBar指菜单栏  
    	    jm=new JMenu("菜单"); //JMenu是菜单栏中的选项栏  
    	    jmi2=new JMenuItem("插入");
    	    jmi3=new JMenuItem("删除");
    	    jmi4=new JMenuItem("修改比赛经历和积分");
    	    jmi5=new JMenuItem("清空所有内容");
    	    
    	    jmi2.addActionListener(this);
    	    jmi3.addActionListener(this);
    	    jmi4.addActionListener(this);
    	    jmi5.addActionListener(this);
    	    
    	    jm.add(jmi2);
    	    jm.add(jmi3);
    	    jm.add(jmi4);
    	    jm.add(jmi5);
    	    jmb.add(jm);  
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

  
       GridBagLayout gbag = new GridBagLayout();
       GridBagConstraints gbc = new GridBagConstraints();
       this.setLayout(gbag);
       
    
       gbc.weightx = 20;
       gbc.weighty = 20;
       gbc.gridheight = 1;
   
       
       gbag.setConstraints(jp1, gbc);
       
      
       gbc.weightx = 5;
       gbc.weighty = 5;
       gbc.gridy = 2;
       gbc.gridheight = 1;
       gbc.anchor = GridBagConstraints.BELOW_BASELINE;
       gbag.setConstraints(jl2, gbc);
       
       gbc.anchor = GridBagConstraints.NORTH;
       gbc.gridy = 3;
       gbc.gridheight = 100;
       gbc.fill = GridBagConstraints.VERTICAL;
 
       
       gbag.setConstraints(jp2, gbc);
       
       
       
       
        jp1.add(jl);  
        jp1.add(jtf);  
        jp1.add(jb);
        jp1.add(jl2);
        jp2.add(jsp);  
        
    
       
        jp1.setLayout(new FlowLayout(FlowLayout.LEFT));  
       
       
      
        
        
      
        this.setJMenuBar(jmb); 
        this.add(jp1);  
        this.add(jl2);  
        this.add(jp2);  
        
        
       
          
 
        this.setTitle("散打积分排名系统—教师");  
        this.setSize(500, 700);  
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
          
        }else if(e.getActionCommand().equals("插入")) {
        	Insert ins = new Insert(jp2);
        	
          	
        }
        else if (e.getActionCommand().equals("删除")){
        	Delete del = new Delete(jp2);
     
        	
        }
        else if(e.getActionCommand().equals("修改比赛经历和积分")){
        	ModifyScore mod = new ModifyScore(jp2);
        	
        	
        }
        else if(e.getActionCommand().equals("清空所有内容")){
        	Clearall clr = new Clearall(jp2);
        
        }else
        {
            JOptionPane.showMessageDialog(null , "请输入要查询的学生姓名","提示消息",JOptionPane.WARNING_MESSAGE);  
        }  
  
    }  
}