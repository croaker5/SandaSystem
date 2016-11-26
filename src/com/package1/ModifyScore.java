package com.package1;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
  
public class ModifyScore extends JFrame implements ActionListener {  
  
    // 定义组件  
	JButton jb=null;
    JLabel jl1,jl2,jl3 = null;  
    JPanel jp1, jp2,jp3,jp4= null;
    JTextField jtf1,jtf2,jtf3;
    JPanel mjp;
     // 构造函数  
    public ModifyScore(JPanel jp) {  
        // 创建组件       
    	mjp =jp;
        jl1 = new JLabel("姓名：");     
        jl2 = new JLabel("积分：");
        jl3 = new JLabel("比赛经历：");
       
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
     
        jb = new JButton("添加");
        
        jb.addActionListener(this);
       
       
        jp1 = new JPanel();  
        jp2 = new JPanel(); 
        jp3 = new JPanel();  
        jp4 = new JPanel();  
        
      
        
        jp1.add(jl1);
        jp1.add(jtf1);
        jp2.add(jl2);
        jp2.add(jtf2);
        jp3.add(jl3);
        jp3.add(jtf3);
        jp4.add(jb);
       
        
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);
        this.add(jp4);
       
        this.setLayout(new GridLayout(4, 1));  
        this.setTitle("添加积分和比赛经历");  
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
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
  
        if (e.getActionCommand().equals("添加")  &&!jtf1.getText().isEmpty()
        		&&!jtf2.getText().isEmpty()&&!jtf3.getText().isEmpty()&&
        		GetSQL.Modifyscores(jtf1.getText(), Integer.parseInt(jtf2.getText()), jtf3.getText())) {                         
        	  mjp.removeAll();
              JTable mjt = GetSQL.ResultToJatable();
              JScrollPane jsp = new JScrollPane(mjt);
              mjp.add(jsp);
             JOptionPane.showMessageDialog(null,"添加成功！","提示消息",JOptionPane.WARNING_MESSAGE);
             clear();
                           
        }
        else if(!GetSQL.Modifyscores(jtf1.getText(), Integer.parseInt(jtf2.getText()), jtf3.getText())){  
            JOptionPane.showMessageDialog(null , "出现错误","提示消息",JOptionPane.WARNING_MESSAGE);  
        }  
        else
        	JOptionPane.showMessageDialog(null , "请输入完整信息","提示消息",JOptionPane.WARNING_MESSAGE);  
        }  
}