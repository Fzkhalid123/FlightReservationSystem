package flightreservationsystem;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

    public class BoardingPass extends JFrame implements ActionListener {


        JTextField tfPnr;
        JLabel lblName, lblNationality, lblSource, lblDestination, lblFlightName, lblFlightCode, lblDate, lblPrice;
        JButton btnFetchButton;

        public BoardingPass() {

            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel heading = new JLabel("AIR INDIA");
            heading.setBounds(380, 10, 450, 35);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
            add(heading);

            JLabel subheading = new JLabel("Boarding Pass");
            subheading.setBounds(380, 50, 300, 30);
            subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
            subheading.setForeground(Color.BLUE);
            add(subheading);

            JLabel lblpnr = new JLabel("PNR DETAILS");
            lblpnr.setBounds(60, 110, 150, 25);
            lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblpnr);

            tfPnr = new JTextField();
            tfPnr.setBounds(220, 110, 150, 25);
            add(tfPnr);

            btnFetchButton = new JButton("ENTER");
            btnFetchButton.setBackground(Color.BLACK);
            btnFetchButton.setForeground(Color.WHITE);
            btnFetchButton.setBounds(390, 110, 100, 25);
            btnFetchButton.addActionListener(this);
            add(btnFetchButton);

            JLabel lblname = new JLabel("NAME");
            lblname.setBounds(60, 160, 150, 25);
            lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblname);

            lblName = new JLabel();
            lblName.setBounds(220, 160, 200, 25);
            add(lblName);

            JLabel lblnationality = new JLabel("NATIONALITY");
            lblnationality.setBounds(60, 200, 150, 25);
            lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblnationality);

            lblNationality = new JLabel();
            lblNationality.setBounds(220, 200, 200, 25);
            add(lblNationality);

            JLabel lblsource = new JLabel("SRC");
            lblsource.setBounds(60, 240, 150, 25);
            lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblsource);

            lblSource = new JLabel();
            lblSource.setBounds(220, 240, 150, 25);
            add(lblSource);

            JLabel lbldestination = new JLabel("DEST");
            lbldestination.setBounds(400, 240, 100, 25);
            lbldestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lbldestination);

            lblDestination = new JLabel();
            lblDestination.setBounds(550, 240, 150, 25);
            add(lblDestination);

            JLabel lblflightname = new JLabel("Flight Name");
            lblflightname.setBounds(60, 280, 150, 25);
            lblflightname.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblflightname);

            lblFlightName = new JLabel();
            lblFlightName.setBounds(220, 280, 150, 25);
            add(lblFlightName);

            JLabel lblflightcode = new JLabel("Flight Code");
            lblflightcode.setBounds(400, 280, 150, 25);
            lblflightcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblflightcode);

            lblFlightCode = new JLabel();
            lblFlightCode.setBounds(550, 280, 150, 25);
            add(lblFlightCode);

            JLabel lbldate = new JLabel("DATE");
            lbldate.setBounds(60, 320, 150, 25);
            lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lbldate);

            lblDate = new JLabel();
            lblDate.setBounds(220, 320, 200, 25);
            add(lblDate);

            JLabel lblprice = new JLabel("PRICE");
            lblprice.setBounds(60, 360, 150, 25);
            lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblprice);

            lblPrice = new JLabel();
            lblPrice.setBounds(220, 360, 200, 25);
            add(lblPrice);


            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("FlightReservationSystem/icons1/icons/airindia.png"));
            Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
            ImageIcon image = new ImageIcon(i2);
            JLabel lblimage = new JLabel(image);
            lblimage.setBounds(600, 0, 300, 300);
            add(lblimage);

            setSize(1000, 450);
            setLocation(300, 150);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnFetchButton) {
                String pnr = tfPnr.getText();

                try {
                    DBConnection conn = new DBConnection();

                    String query = "select * from reservation where PNR = '" + pnr + "'";

                    ResultSet rs = conn.s.executeQuery(query);
                    if (rs.next()) {
                        lblName.setText(rs.getString("name"));
                        lblNationality.setText(rs.getString("nationality"));
                        lblSource.setText(rs.getString("source"));
                        lblDestination.setText(rs.getString("destination"));
                        lblFlightName.setText(rs.getString("flightname"));
                        lblFlightCode.setText(rs.getString("flightcode"));
                        lblDate.setText(rs.getString("date"));
                        lblPrice.setText(rs.getString("price"));
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        public static void main (String[]args){

            new BoardingPass();
        }
    }





