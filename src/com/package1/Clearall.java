package com.package1;
import javax.swing.*; 
public class Clearall {
	JPanel cjp;
	Clearall(JPanel jp){
		cjp = jp;
		int opt = JOptionPane.showConfirmDialog(null, "�����Ҫ������������𣿣���պ����������޷��ָ���", "�����������", JOptionPane.YES_NO_OPTION);
		if(opt == JOptionPane.YES_OPTION)
		{
			int opt2=JOptionPane.showConfirmDialog(null, "�����Ҫ������������𣿣���պ����������޷��ָ���", "�����������", JOptionPane.YES_NO_OPTION);
			if(opt2==JOptionPane.YES_OPTION)
			{
			  	GetSQL.Clearalldatas();
			    cjp.removeAll();
	             JTable cjt = GetSQL.ResultToJatable();
	             JScrollPane jsp = new JScrollPane(cjt);
	             cjp.add(jsp);
			  	 JOptionPane.showMessageDialog(null,"����ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			}
			
			
			
		}
		

}
}
