package com.package1;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
  
public class Delete extends JFrame implements ActionListener {  
  
    // 定义组件  
	JButton jb=null;
    JLabel jl1 = null;
    JPanel jp1= null;
    JTextField jtf1;
    JPanel djp;
     // 构造函数  
    public Delete(JPanel jp) {  
    	djp = jp;
        // 创建组件       
        jl1 = new JLabel("请输入要删除的学生的姓名：");     
        
        jtf1 = new JTextField(10);
      
        jb = new JButton("删除");
        
        jb.addActionListener(this);
       
       
        jp1 = new JPanel();  
        
        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jb);
        
        this.add(jp1);  
       
        
        this.setLayout(new GridLayout(1, 1));  
        this.setTitle("删除学生");  
        this.setSize(500, 100);  
        this.setLocation(200, 200);  
        this.setVisible(true);  
        this.setResizable(true);  
       
    }
    public void clear()  
    {  
        jtf1.setText("");  
       
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
  
        if (e.getActionCommand().equals("删除")  &&!jtf1.getText().isEmpty()
        		&&
        		GetSQL.Deletestudent(jtf1.getText())) {                         
        	  djp.removeAll();
              JTable djt = GetSQL.ResultToJatable();
              JScrollPane jsp = new JScrollPane(djt);
              djp.add(jsp);
             JOptionPane.showMessageDialog(null,"删除成功！","提示消息",JOptionPane.WARNING_MESSAGE);
             clear();
                           
        }
        else if(!GetSQL.Deletestudent(jtf1.getText())){  
            JOptionPane.showMessageDialog(null , "出现错误","提示消息",JOptionPane.WARNING_MESSAGE);  
        }  
        else
        	JOptionPane.showMessageDialog(null , "请输入学生姓名","提示消息",JOptionPane.WARNING_MESSAGE);  
        }  
}