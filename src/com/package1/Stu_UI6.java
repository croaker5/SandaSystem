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

    
    // ���캯��  
    public Stu_UI6() {  
        // �������       
    	  
        jl = new JLabel("������������");     
          
        jl2=new JLabel("ѧ����Ϣ��");  
          
        jtf = new JTextField(10);  
          
        jb = new JButton("��ѯ");  
         
        // ���ü���  
        jb.addActionListener(this);  
        
        // ���ñ��1  
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
        this.setTitle("ɢ���������ϵͳ��ѧ��");  
        this.setSize(500, 500);  
        this.setLocation(150, 150);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setVisible(true);  
        this.setResizable(true);  
          
    }
  
    @Override  
    public void actionPerformed(ActionEvent e) {  
  
        if (e.getActionCommand().equals("��ѯ")  &&!jtf.getText().isEmpty()) {                         
            // �������ѯ��ťʱ�����������ݿ⽨������  
            GetSQL.ConnectSQL();  
            GetSQL.getdatastu(jtf.getText());  
            jtf.setText("");  
            Search tmp =new Search();              
        }else 
       {
            JOptionPane.showMessageDialog(null , "������Ҫ��ѯ��ѧ������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }  
  
    }  
}