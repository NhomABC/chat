package bida;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ketnoicsdl.connection;

public class dangnhap extends JFrame implements ActionListener{
       
    private PreparedStatement stmt;
    Connection con;
    ResultSet rs;
	 private JLabel userlb,passlb,titlelb;
     private JButton dangnhap,dangki;
     private JTextField txtuser;
     private JPasswordField txtpass;
	 
     private JPanel panel;
     
     
     public dangnhap(String s){
     	 super(s);
     	 
     	 
     	 try{
   		  con=connection.getConnection();
     }catch(Exception e){
   		  
   	  }
     	 
     	 
     	 this.add(createMain());	
     	 setSize(500,300);
     	 setVisible(true);
          setLocationRelativeTo(null);
      
      }
     JPanel createMain(){
    	 
    	 panel=new JPanel();
  		panel.setLayout(null);
  		panel.setBackground(Color.white);
     ///create
  		 titlelb=new JLabel("Xin vui lòng đăng nhập để tiếp tục");
  		
    	 userlb=new JLabel("Username");
    	 ImageIcon iconuser = new ImageIcon("anh/user.png");
		  userlb.setIcon(iconuser);
		  
    	 passlb=new JLabel("Password");
    	 ImageIcon iconpass = new ImageIcon("anh/key.png");
		 passlb.setIcon(iconpass);
		  
    	 txtuser=new JTextField("");
    	 txtpass=new JPasswordField("");
    	 //buttuon
    	 dangnhap=new JButton("Login");
    	 ImageIcon iconlogin = new ImageIcon("anh/login.png");
		  dangnhap.setIcon(iconlogin);
    	 dangnhap.addActionListener(this);
    	 dangki=new JButton("Register");
    	 ImageIcon iconregister = new ImageIcon("anh/register.png");
		  dangki.setIcon(iconregister);
    	 dangki.addActionListener(this);
    	 
    	 ///panel add
    	 panel.add(titlelb);
    	 panel.add(userlb);
    	 panel.add(passlb);
    	 panel.add(txtuser);
    	 panel.add(txtpass);
    	 panel.add(dangnhap);
    	 panel.add(dangki);
    	 
    	 ///set bound
    	  titlelb.setBounds(20, 10, 300, 20);
    	 userlb.setBounds(100, 70, 100, 30);
    	 passlb.setBounds(100, 120, 100, 30);
         
    	 txtuser.setBounds(200, 70, 150, 30);
    	 txtpass.setBounds(200, 120, 150, 30);
    	 
    	 dangnhap.setBounds(90, 180, 150, 50);
    	 dangki.setBounds(270, 180, 150, 50);
    	 
		return panel;
    	 
    	 
    	 
    	 
     }
     
     public static void main(String[]args) throws ClassNotFoundException {
	     new dangnhap("Login") ;
  }
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==dangnhap){
			String sql="Select * from login where name=? and password=?";
			
			try{
				stmt= con.prepareStatement(sql);
				stmt.setString(1,txtuser.getText());
				stmt.setString(2,txtpass.getText());
				
				rs=stmt.executeQuery();
				
				if(rs.next()){
					JOptionPane.showMessageDialog(null,"Thành công");
					new cuasodangnhap("");
					this.setVisible(false);
				     }
				else{
					JOptionPane.showMessageDialog(null,"Lỗi");
				}
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			
		}
		
		///dang ki
		
		
		
		if(ae.getSource()==dangki){
			String sqlquery="Select * from login where name=? ";
			
			try{
				stmt= con.prepareStatement(sqlquery);
				stmt.setString(1,txtuser.getText());
				
				
				rs=stmt.executeQuery();
				
				if(rs.next()){
					JOptionPane.showMessageDialog(null,"Tài khoản đã bị trùng");
					
				     }
				else{
					JOptionPane.showMessageDialog(null,"Thành công");
					String sql="INSERT INTO login(name,password)  VALUES (?,?)";
					stmt=con.prepareStatement(sql);
					stmt.setString(1,txtuser.getText());
					stmt.setString(2,txtpass.getText());
					stmt.executeUpdate();
				}
				
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
			
		}
		
		
	}
}

