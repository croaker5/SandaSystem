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

    // ���캯��  
    public Teacher6() {  
        // �������       
    	    jmb=new JMenuBar(); //JMenuBarָ�˵���  
    	    jm=new JMenu("�˵�"); //JMenu�ǲ˵����е�ѡ����  
    	    jmi2=new JMenuItem("����");
    	    jmi3=new JMenuItem("ɾ��");
    	    jmi4=new JMenuItem("�޸ı��������ͻ���");
    	    jmi5=new JMenuItem("�����������");
    	    
    	    jmi2.addActionListener(this);
    	    jmi3.addActionListener(this);
    	    jmi4.addActionListener(this);
    	    jmi5.addActionListener(this);
    	    
    	    jm.add(jmi2);
    	    jm.add(jmi3);
    	    jm.add(jmi4);
    	    jm.add(jmi5);
    	    jmb.add(jm);  
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
        
        
       
          
 
        this.setTitle("ɢ���������ϵͳ����ʦ");  
        this.setSize(500, 700);  
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
          
        }else if(e.getActionCommand().equals("����")) {
        	Insert ins = new Insert(jp2);
        	
          	
        }
        else if (e.getActionCommand().equals("ɾ��")){
        	Delete del = new Delete(jp2);
     
        	
        }
        else if(e.getActionCommand().equals("�޸ı��������ͻ���")){
        	ModifyScore mod = new ModifyScore(jp2);
        	
        	
        }
        else if(e.getActionCommand().equals("�����������")){
        	Clearall clr = new Clearall(jp2);
        
        }else
        {
            JOptionPane.showMessageDialog(null , "������Ҫ��ѯ��ѧ������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
        }  
  
    }  
}