package phanmemchat;


import java.awt. *;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;


public class loginform extends JFrame implements ActionListener{
     private JLabel titlelb,gtlb,anhlb;
     private JButton batdau,dangnhap,bia,sodoban,nhap;
     private JMenuBar bar;
     private JMenu menu,thongtin;
     private JMenuItem quanli,thoat,giupdo,author;
    private JPanel panel;
    private JTextArea textbox,content;
    private JTextField textfield,toName;
     
    public loginform(String s){
    	 super(s);
    	 
    	 this.add(createMain1());	
    	 setSize(700,500);
    	 setVisible(true);
         setLocationRelativeTo(null);
     
     }
     JPanel createMain1() {
    	 panel=new JPanel();
    	 panel=new JPanel();
  		panel.setLayout(null);
  		panel.setBackground(Color.PINK);
  	  Font f = new Font("Arial",Font.BOLD,20);  // Font chữ
  		
  		 content = new JTextArea(); // Nội dung chat
         content.setFont(f); // Định nghĩa font cho nội dung
         content.setBackground(Color.cyan); // Đặt hình nền
  		JScrollPane sp = new JScrollPane(content); // Cho phép scrolling khi nội dung quá dài
        content.setEditable(false); // Không cho phép chỉnh sửa nội dung
        panel.add(content);
  		content.setBounds(20, 100, 500, 250);
        
        textfield=new JTextField(30);
  		textfield.setBounds(20,400,500,25); 
  		panel.add(textfield);
  		
  		 toName = new JTextField("Nhập tên bạn"); // Định nghĩa nội dung mặc định cho khung
         toName.setFont(f); // Đặt font cho khung
        
  		toName.setBounds(20, 360, 200, 25);
  	     panel.add(toName);
  	
  		
  	  nhap =new JButton("Gửi");
		 nhap.setBackground(Color.LIGHT_GRAY);
		 nhap.addActionListener(this);
		 panel.add(nhap);
		 nhap.setBounds(530, 400, 70, 25);
  		
  		anhlb=new JLabel("PHẦN MỀM  CHAT TEAM SECRET");
 		anhlb.setFont(new Font("Arial",Font.PLAIN,20));
 		anhlb.setForeground(Color.RED);
 		anhlb.setBounds(120, 40, 400, 30);
  		panel.add(anhlb);
  		
  		return panel;
     }
 	
 	
     
public static void main(String[]args) throws ClassNotFoundException {
	     new loginform("Bắt đầu") ;
  }



public void actionPerformed(ActionEvent ae) {
	  if(ae.getSource()==bia){
	    	new loginform("adf");
	    	this.setVisible(false);
	    	
	    }
	  if(ae.getSource()==sodoban){
	    	
	    	this.setVisible(false);
	    	
	    }
	    if(ae.getActionCommand().equals("Quản lí hồ sơ")){
	    	//new MenuDemo();
	    	this.setVisible(false);
	    	
	    	
	    }
	
	    if(ae.getActionCommand().equals("Tác giả")){
	    	//new thongtin("Th�ng tin t�c gi? v� li�n h?");
	    	
	    	
	    }
	    if(ae.getActionCommand().equals("Thoát")){
	    	System.exit(0);
	    	
	    	
	    }
	  
	}
     
}


