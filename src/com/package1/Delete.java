package com.package1;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
  
public class Delete extends JFrame implements ActionListener {  
  
    // �������  
	JButton jb=null;
    JLabel jl1 = null;
    JPanel jp1= null;
    JTextField jtf1;
    JPanel djp;
     // ���캯��  
    public Delete(JPanel jp) {  
    	djp = jp;
        // �������       
        jl1 = new JLabel("������Ҫɾ����ѧ����������");     
        
        jtf1 = new JTextField(10);
      
        jb = new JButton("ɾ��");
        
        jb.addActionListener(this);
       
       
        jp1 = new JPanel();  
        
        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jb);
        
        this.add(jp1);  
       
        
        this.setLayout(new GridLayout(1, 1));  
        this.setTitle("ɾ��ѧ��");  
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
  
        if (e.getActionCommand().equals("ɾ��")  &&!jtf1.getText().isEmpty()
        		&&
        		GetSQL.Deletestudent(jtf1.getText())) {                         
        	  djp.removeAll();
              JTable djt = GetSQL.ResultToJatable();
              JScrollPane jsp = new JScrollPane(djt);
              djp.add(jsp);
             JOptionPane.showMessageDialog(null,"ɾ���ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
             clear();
                           
        }
        else if(!GetSQL.Deletestudent(jtf1.getText())){  
            JOptionPane.showMessageDialog(null , "���ִ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }  
        else
        	JOptionPane.showMessageDialog(null , "������ѧ������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }  
}