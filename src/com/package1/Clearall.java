package com.package1;
import javax.swing.*; 
public class Clearall {
	JPanel cjp;
	Clearall(JPanel jp){
		cjp = jp;
		int opt = JOptionPane.showConfirmDialog(null, "您真的要清空所有内容吗？（清空后所有内容无法恢复）", "清空所有内容", JOptionPane.YES_NO_OPTION);
		if(opt == JOptionPane.YES_OPTION)
		{
			int opt2=JOptionPane.showConfirmDialog(null, "您真的要清空所有内容吗？（清空后所有内容无法恢复）", "清空所有内容", JOptionPane.YES_NO_OPTION);
			if(opt2==JOptionPane.YES_OPTION)
			{
			  	GetSQL.Clearalldatas();
			    cjp.removeAll();
	             JTable cjt = GetSQL.ResultToJatable();
	             JScrollPane jsp = new JScrollPane(cjt);
	             cjp.add(jsp);
			  	 JOptionPane.showMessageDialog(null,"清除成功！","提示消息",JOptionPane.WARNING_MESSAGE);
			}
			
			
			
		}
		

}
}
