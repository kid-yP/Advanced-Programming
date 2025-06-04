import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Calculator extends JFrame{
 JButton btn[]=new JButton[16];
 JTextField txtResult;
 Calculator(){
   String caption[]={"7", "8", "9", "/", "4", "5", "6", "*","1",
                     "2", "3", "-", "0", "=",".","+"};
 //setSize(200,200);
 for(int i=0;i<16;i++)
   btn[i]=new JButton(String.valueOf(caption[i]));
 txtResult=new JTextField();
 MyListener ml=new MyListener();
 for(int i=0;i<16;i++)
   btn[i].addActionListener(ml);
 Container cp=getContentPane();
 cp.setLayout(new BorderLayout());
 cp.add(txtResult,BorderLayout.NORTH);
 JPanel jp=new JPanel();
 cp.add(jp,BorderLayout.CENTER);
 jp.setLayout(new GridLayout(4,4));
 for(int i=0;i<16;i++)
   jp.add(btn[i]);
 pack(); //sizes the frame so that all its contents are at or
 //above their preferred sizes
 }
   public static void main(String args[]){
     Calculator cl=new Calculator();
     cl.setVisible(true);
   }
 }
class MyListener implements ActionListener{
 public void actionPerformed(ActionEvent ae){
 }
 }
