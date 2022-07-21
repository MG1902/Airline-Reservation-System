package airline;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Ticket extends JFrame { //Sixth
    
    private JTextField textField,textField_1,textField_2,textField_3;

    public static void main(String[] args) {
        new Ticket();
    }
    
    public Ticket() {
        initialize();
    }
    
    private void initialize() {
        setTitle("Ticket Booking");
	getContentPane().setBackground(Color.WHITE);
	setBounds(100, 100, 801, 472);
	setLayout(null);
		
	JLabel Cancellation = new JLabel("Booking");
	Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Cancellation.setBounds(185, 24, 259, 38);
	add(Cancellation);
		
	
        ImageIcon i1 = new ImageIcon(getClass().getResource("/Images/unnamed.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 300, 300);
	add(NewLabel);
		

		
	JLabel CancellationNo = new JLabel("Customer id");
	CancellationNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
	CancellationNo.setBounds(60, 150, 150, 27);
	add(CancellationNo);
		
	JLabel CancellationDate = new JLabel("Customer name");
	CancellationDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
	CancellationDate.setBounds(60, 200, 180, 27);
	add(CancellationDate);
		
	JLabel Ticketid = new JLabel("Amount");
	Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Ticketid.setBounds(60, 250, 150, 27);
	add(Ticketid);
		
	JLabel Flightcode = new JLabel("FLIGHT_Details");
	Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Flightcode.setBounds(60, 300, 150, 27);
	add(Flightcode);
		
	JButton Cancel = new JButton("Book");
	Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
	Cancel.setBounds(250, 350, 150, 30);
	add(Cancel);
		
	
	
        textField_1 = new JTextField();
	textField_1.setBounds(250, 150, 150, 27);
	add(textField_1);
		
	textField_2 = new JTextField();
	textField_2.setBounds(250, 200, 150, 27);
	add(textField_2);
	
        textField_3 = new JTextField();
	textField_3.setBounds(250, 250, 150, 27);
	add(textField_3);
		String list[]={"Banglore-delhi","delhi-hyderabad","chennai-delhi","goa-delhi"};;
	JComboBox cb=new JComboBox(list);
	cb.setBounds(250, 300, 150, 27);
	add(cb);
	
        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                String passenger_no = textField_1.getText();
		String cancellation_no = textField_2.getText();
		String cancellation_date = textField_3.getText();
	
		String flight_code = (String) cb.getSelectedItem();
					
					
		try{	
                    Conn c = new Conn();
                    String str = "INSERT INTO APP.TICKET values('"+passenger_no+"', '"+cancellation_no+"', '"+cancellation_date+"', '"+flight_code+"')";
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Ticket Booked");
                    setVisible(false);
						
		}catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
			
	setSize(860,500);
	setVisible(true);
        setLocation(400,200);
    }
}