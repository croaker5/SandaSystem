package com.package1;

import javax.swing.*;  
import javax.swing.table.DefaultTableModel;  
  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
  
public class Search extends JFrame  {  
  
    // �������  
    JLabel jl = null;  
    JButton jb= null;  
    JPanel jp1, jp2= null;
     
    DefaultTableModel model = null;  
    JTable table = null;  
    JScrollPane jsp = null;  
    
//  public static void main(String[] args) {  
        // TODO Auto-generated method stub  
//      Teacher6 t = new Teacher6();  
//  }  
  
    // ���캯��  
    public Search() {  
        // �������       
        jl = new JLabel("��ѧ��������");     
          
        // ���ñ�� 
        String[] colnames = { "����", "����", "����", "�Ա�", "���ؼ���kg��", "��������" };  
        model = new DefaultTableModel(colnames, 3);  
        table = new JTable(model);  
        jsp = new JScrollPane(table);  
       
        
        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(gbag);
        
     
        gbc.weightx = 20;
        gbc.weighty = 20;
        gbc.gridheight = 1;
    
        
        gbag.setConstraints(jl, gbc);
        
       
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridy = 3;
        gbc.gridheight = 100;
        gbc.fill = GridBagConstraints.VERTICAL;
  
        
        gbag.setConstraints(jsp, gbc);
       
      
    
        this.add(jl);  
        this.add(jsp);  
       
          
       
        this.setTitle("��ѯ���");  
        this.setSize(500, 500);  
        this.setLocation(150, 150);  
      
        this.setVisible(true);  
        this.setResizable(true);  
        table.setValueAt(GetSQL.rank, 0, 0);  
        table.setValueAt(GetSQL.name, 0, 1);  
        table.setValueAt(GetSQL.score, 0, 2);  
        table.setValueAt(GetSQL.sex, 0, 3);  
        table.setValueAt(GetSQL.weight, 0, 4);  
        table.setValueAt(GetSQL.experience, 0, 5); 
          
  
    }
}
  
   