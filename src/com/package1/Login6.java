package com.package1;

import javax.swing.*;  

import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.sql.*;  
  
public class Login6 extends JFrame implements ActionListener {  
  
    //�����¼��������  
    JButton jb1,jb2,jb3=null;  
    JRadioButton jrb1,jrb2=null;  
    JPanel jp1,jp2,jp3,jp4=null;  
    JTextField jtf=null;  
    JLabel jlb1,jlb2,jlb3=null;  
    JPasswordField jpf=null;  
    ButtonGroup bg=null;      
      
    //�˵���  
    JMenuBar jmb=null;    
    JMenu jm=null;  
    JMenuItem jmi1,jmi2=null;  
      
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Login6  ms=new Login6();  
          
                          
    }  
    //���캯��  
    public Login6()  
    {  
         //�������  
        jb1=new JButton("��¼");  
        jb2=new JButton("����");  
        jb3=new JButton("�˳�");  
        //���ü���  
        jb1.addActionListener(this);  
        jb2.addActionListener(this);  
        jb3.addActionListener(this);  
          
        jmb=new JMenuBar(); //JMenuBarָ�˵���  
        jm=new JMenu("ѡ��"); //JMenu�ǲ˵����е�ѡ����  
        jmi1=new JMenuItem("��ʼ"); //JMenuItemָѡ�����е�ѡ��  
        jmi2=new JMenuItem("�˳�ϵͳ");  
        jm.add(jmi1);  
        jm.add(jmi2);  
        jmb.add(jm);  
          
          
        jrb1=new JRadioButton("��ʦ",true);  
        jrb2=new JRadioButton("ѧ��");  
        bg=new ButtonGroup();  
        bg.add(jrb1);  
        bg.add(jrb2);  
//      jrb2.setSelected(true);  
          
        jp1=new JPanel();  
        jp2=new JPanel();  
        jp3=new JPanel();  
        jp4=new JPanel();                 
          
        jlb1=new JLabel("�û�����");  
        jlb2=new JLabel("��    �룺");  
        jlb3=new JLabel("Ȩ    �ޣ�");  
          
        jtf=new JTextField(10);  
        jpf=new JPasswordField(10);  
        //���뵽JPanel��  
        jp1.add(jlb1);  
        jp1.add(jtf);  
          
        jp2.add(jlb2);  
        jp2.add(jpf);  
          
        jp3.add(jlb3);  
        jp3.add(jrb1);  
        jp3.add(jrb2);  
          
        jp4.add(jb1);  
        jp4.add(jb2);  
        jp4.add(jb3);  
          
        //����JFrame��  
        this.setJMenuBar(jmb);  
        this.add(jp1);  
        this.add(jp2);  
        this.add(jp3);  
        this.add(jp4);  
        //���ò��ֹ�����  
        this.setLayout(new GridLayout(4,1));  
        //���������ñ���  
        this.setTitle("ɢ���������ϵͳ");  
        //���ô����С  
        this.setSize(300,250);  
        //���ô����ʼλ��  
        this.setLocation(200, 150);  
        //���õ��رմ���ʱ����֤JVMҲ�˳�  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        //��ʾ����  
        this.setVisible(true);  
        this.setResizable(true);  
          
    }  
    @Override  
    public void actionPerformed(ActionEvent e) {  
  
        if(e.getActionCommand()=="�˳�")  
        {  
            System.exit(0);  
        }else if(e.getActionCommand()=="��¼")  
        {  
            if(!jtf.getText().isEmpty() && !jpf.getText().isEmpty())  
            {  
                //�������¼��ťʱ�����������ݿ⽨������  
                GetSQL.ConnectSQL();  
                //���ѡ�н�ʦ��¼  
                if(jrb1.isSelected())  
                {  
                    GetSQL.querytea(jtf.getText());  
                    //�����ж��Ƿ���ڸ��û������Ƿ�õ�������  
                      //���õ�¼����  
                        this.tealogin();
                        this.clear();
                     
                }else if(jrb2.isSelected()) //ѧ���ڵ�¼ϵͳ  
                {  
                    GetSQL.querystu(jtf.getText());  
                    //�����ж��Ƿ���ڸ��û������Ƿ�õ�������  
                     //���õ�¼����  
                        this.stulogin();  
                        this.clear();
                     
                }  
            }else if(jtf.getText().isEmpty())  
            {  
                JOptionPane.showMessageDialog(null,"�������û���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                this.clear();  
            }else if(jpf.getText().isEmpty())     
            {  
                JOptionPane.showMessageDialog(null,"����������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                this.clear();  
            }  
        }else if(e.getActionCommand()=="����")  
        {  
            this.clear();  
        }             
          
    }  
                  
        //����ı���������  
    public  void clear()  
        {  
            jtf.setText("");  
            jpf.setText("");  
        }  
            //ѧ����¼�жϷ���  
    public void stulogin()  
            {  
                if(GetSQL.pwd.equals(jpf.getText()))  
                {  
//                  System.out.println("��¼�ɹ�");  
                    JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                    this.clear();  
                    //�رյ�ǰ����  
                     dispose();  
                     //����һ���½���  
                     Stu_UI6 ui=new Stu_UI6();  
                }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                }else if(jtf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                }else if(jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                }else  
                {  
                    JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
                    //��������  
                    this.clear();  
                }  
            }  
              
            //��ʦ��¼�жϷ���  
    public void tealogin()  
            {  
                if(GetSQL.pwd.equals(jpf.getText()))  
                {  
//                  System.out.println("��¼�ɹ�");  
                     JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                     this.clear();    
                    //�رյ�ǰ����  
                     dispose();  
                     //����һ���½��棬�����ڽ�ʦ������ѧ��  
                    Teacher6 t=new Teacher6();                                    
                }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                }else if(jtf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                }else if(jpf.getText().isEmpty())  
                {  
                    JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);  
                }else  
                {  
                    JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);  
                    //��������  
                    this.clear();  
                }  
            }  
          
}
