package com.package1;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
  
public class ModifyScore extends JFrame implements ActionListener {  
  
    // �������  
	JButton jb=null;
    JLabel jl1,jl2,jl3 = null;  
    JPanel jp1, jp2,jp3,jp4= null;
    JTextField jtf1,jtf2,jtf3;
    JPanel mjp;
     // ���캯��  
    public ModifyScore(JPanel jp) {  
        // �������       
    	mjp =jp;
        jl1 = new JLabel("������");     
        jl2 = new JLabel("���֣�");
        jl3 = new JLabel("����������");
       
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
     
        jb = new JButton("���");
        
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
        this.setTitle("��ӻ��ֺͱ�������");  
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
  
        if (e.getActionCommand().equals("���")  &&!jtf1.getText().isEmpty()
        		&&!jtf2.getText().isEmpty()&&!jtf3.getText().isEmpty()&&
        		GetSQL.Modifyscores(jtf1.getText(), Integer.parseInt(jtf2.getText()), jtf3.getText())) {                         
        	  mjp.removeAll();
              JTable mjt = GetSQL.ResultToJatable();
              JScrollPane jsp = new JScrollPane(mjt);
              mjp.add(jsp);
             JOptionPane.showMessageDialog(null,"��ӳɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
             clear();
                           
        }
        else if(!GetSQL.Modifyscores(jtf1.getText(), Integer.parseInt(jtf2.getText()), jtf3.getText())){  
            JOptionPane.showMessageDialog(null , "���ִ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }  
        else
        	JOptionPane.showMessageDialog(null , "������������Ϣ","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }  
}