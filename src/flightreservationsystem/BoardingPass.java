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


        JTextField tfpnr;
        JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
        JButton fetchButton;

        public BoardingPass() {

            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel heading = new JLabel("AIR INDIA");
            heading.setBounds(380, 10, 450, 35);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
            add(heading);

            JLabel subheading = new JLabel("Boarding Pass");
            subheading.setBounds(360, 50, 300, 30);
            subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
            subheading.setForeground(Color.BLUE);
            add(subheading);

            JLabel lblaadhar = new JLabel("PNR DETAILS");
            lblaadhar.setBounds(60, 110, 150, 25);
            lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblaadhar);

            tfpnr = new JTextField();
            tfpnr.setBounds(220, 110, 150, 25);
            add(tfpnr);

            fetchButton = new JButton("ENTER");
            fetchButton.setBackground(Color.BLACK);
            fetchButton.setForeground(Color.WHITE);
            fetchButton.setBounds(390, 110, 100, 25);
            fetchButton.addActionListener(this);
            add(fetchButton);

            JLabel lblname = new JLabel("NAME");
            lblname.setBounds(60, 160, 150, 25);
            lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblname);

            tfname = new JLabel();
            tfname.setBounds(220, 160, 200, 25);
            add(tfname);

            JLabel lblnationality = new JLabel("NATIONALITY");
            lblnationality.setBounds(60, 200, 150, 25);
            lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblnationality);

            tfnationality = new JLabel();
            tfnationality.setBounds(220, 200, 200, 25);
            add(tfnationality);

            JLabel lbladdress = new JLabel("SRC");
            lbladdress.setBounds(60, 240, 150, 25);
            lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lbladdress);

            lblsrc = new JLabel();
            lblsrc.setBounds(220, 240, 150, 25);
            add(lblsrc);

            JLabel lblgender = new JLabel("DEST");
            lblgender.setBounds(400, 240, 100, 25);
            lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblgender);

            lbldest = new JLabel();
            lbldest.setBounds(550, 240, 150, 25);
            add(lbldest);

            JLabel lblfname = new JLabel("Flight Name");
            lblfname.setBounds(60, 280, 150, 25);
            lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblfname);

            labelfname = new JLabel();
            labelfname.setBounds(220, 280, 150, 25);
            add(labelfname);

            JLabel lblfcode = new JLabel("Flight Code");
            lblfcode.setBounds(400, 280, 150, 25);
            lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblfcode);

            labelfcode = new JLabel();
            labelfcode.setBounds(550, 280, 150, 25);
            add(labelfcode);

            JLabel lbldate = new JLabel("DATE");
            lbldate.setBounds(60, 320, 150, 25);
            lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lbldate);

            labeldate = new JLabel();
            labeldate.setBounds(220, 320, 200, 25);
            add(labeldate);


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
            if (e.getSource() == fetchButton) {
                String pnr = tfpnr.getText();

                try {
                    DBConnection conn = new DBConnection();

                    String query = "select * from reservation where PNR = '" + pnr + "'";

                    ResultSet rs = conn.s.executeQuery(query);
                    if (rs.next()) {
                        tfname.setText(rs.getString("name"));
                        tfnationality.setText(rs.getString("nationality"));
                        lblsrc.setText(rs.getString("src"));
                        lbldest.setText(rs.getString("des"));
                        labelfname.setText(rs.getString("flightname"));
                        labelfcode.setText(rs.getString("flightcode"));
                        labeldate.setText(rs.getString("ddate"));
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





