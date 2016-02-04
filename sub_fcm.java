import javax.swing.*;
import java.awt.*;
import java.awt.event.*; import java.awt.FlowLayout;  
  
class sub_fcm extends JFrame implements ActionListener
 {
  JButton SUBMIT;String ss1,ss2,ss3;
  JPanel panel;
  JLabel label1;JLabel label2;JLabel label3;JLabel label4;JLabel label5;JLabel label6;  JLabel jl1=new JLabel(""); 
  final JTextField  text1;
   sub_fcm(String s,String lll,String qqq)
   {
ss1=s;ss2=lll;ss3=qqq;
   label1 = new JLabel();ss1="Negative="+ss1;ss2="Primary_hypothyroid="+ss2;ss3="Compensated_hypothyroid="+ss3;
   label1.setText("Dataset");
   text1 = new JTextField(15);
   label2 = new JLabel();label3 = new JLabel();label4 = new JLabel();label5 = new JLabel();label6 = new JLabel();
 label2.setText("Fuzzy C-Means Clustering                                                                         ");
   
    label6.setText("              ");

  
   SUBMIT=new JButton("SUBMIT");
   
   panel=new JPanel(new FlowLayout());
panel.add(label2);
   panel.add(label1);
   panel.add(text1);
 panel.add(SUBMIT);panel.add(label6);
panel.add(label3);
panel.add(label4);
panel.add(label5);
   
  
   add(panel,BorderLayout.CENTER);
   SUBMIT.addActionListener(this);
   setTitle("FUZZY C-MEANS CLUSTERING");
   }
  public void actionPerformed(ActionEvent ae)
   {
   String value1=text1.getText();
 if (value1.equals(""))
 {
 
   JOptionPane.showMessageDialog(this,"enter dataset",
   "Error",JOptionPane.ERROR_MESSAGE);
 }
 else{ if(!value1.equals("thyroid"))
{
JOptionPane.showMessageDialog(this,"Thyroid Dataset",
   "Error",JOptionPane.ERROR_MESSAGE);
}
else
{

label3.setText(ss1);
   label4.setText(ss2);
   label5.setText(ss3);
}
}
   
 
   
 }
 }
  
