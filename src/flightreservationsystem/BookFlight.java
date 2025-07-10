package flightreservationsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {


    JTextField tfAadhar;
    JLabel lblName, lblNationality, lblAddress, lblGender, lblFlightName, lblFlightCode;
    JButton btnBookFlight, btnFetchButton, btnFlight;
    Choice source, destination;
    JDateChooser dcdate;

    public BookFlight() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfAadhar = new JTextField();
        tfAadhar.setBounds(220, 80, 150, 25);
        add(tfAadhar);

        btnFetchButton = new JButton("Fetch User");
        btnFetchButton.setBackground(Color.BLACK);
        btnFetchButton.setForeground(Color.WHITE);
        btnFetchButton.setBounds(380, 80, 120, 25);
        btnFetchButton.addActionListener(this);
        add(btnFetchButton);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        lblName = new JLabel();
        lblName.setBounds(220, 130, 150, 25);
        add(lblName);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        lblNationality = new JLabel();
        lblNationality.setBounds(220, 180, 150, 25);
        add(lblNationality);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        lblAddress = new JLabel();
        lblAddress.setBounds(220, 230, 150, 25);
        add(lblAddress);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        lblGender = new JLabel("Gender");
        lblGender.setBounds(220, 280, 150, 25);
        add(lblGender);

        JLabel lblSource = new JLabel("Source");
        lblSource.setBounds(60, 330, 150, 25);
        lblSource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblSource);

        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);

        JLabel lblDestination = new JLabel("Destination");
        lblDestination.setBounds(60, 380, 150, 25);
        lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDestination);

        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);

        try {
            DBConnection connection = new DBConnection();
            ResultSet rs = connection.s.executeQuery("select * from flight");

            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        btnFlight = new JButton("Fetch Flights");
        btnFlight.setBackground(Color.BLACK);
        btnFlight.setForeground(Color.WHITE);
        btnFlight.setBounds(380, 380, 120, 25);
        btnFlight.addActionListener(this);
        add(btnFlight);

        JLabel lblflightname = new JLabel("Flight Name");
        lblflightname.setBounds(60, 430, 150, 25);
        lblflightname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblflightname);

        lblFlightName = new JLabel();
        lblFlightName.setBounds(220, 430, 150, 25);
        add(lblFlightName);

        JLabel lblflightcode = new JLabel("Flight Code");
        lblflightcode.setBounds(60, 480, 150, 25);
        lblflightcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblflightcode);

        lblFlightCode = new JLabel();
        lblFlightCode.setBounds(220, 480, 150, 25);
        add(lblFlightCode);

        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("FlightReservationSystem/icons1/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);

        btnBookFlight = new JButton("Book Flight");
        btnBookFlight.setBackground(Color.BLACK);
        btnBookFlight.setForeground(Color.WHITE);
        btnBookFlight.setBounds(220, 580, 150, 25);
        btnBookFlight.addActionListener(this);
        add(btnBookFlight);


        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnFetchButton) {
            String aadhar = tfAadhar.getText();

            try {
                DBConnection connection = new DBConnection();

                String query = "select * from passenger where aadhar = '" + aadhar + "'";

                ResultSet rs = connection.s.executeQuery(query);
                if (rs.next()) {
                    lblName.setText(rs.getString("Name"));
                    lblNationality.setText(rs.getString("Nationality"));
                    lblAddress.setText(rs.getString("Address"));
                    lblGender.setText(rs.getString("Gender"));
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnFlight) {
            String src = source.getSelectedItem();
            String dest = destination.getSelectedItem();
            try {
                DBConnection connection = new DBConnection();

                String query = "select * from flight where source = '" + src + "' and destination = '" + dest + "'";

                ResultSet rs = connection.s.executeQuery(query);

                if (rs.next()) {
                    lblFlightName.setText(rs.getString("Flight_Name"));
                    lblFlightCode.setText(rs.getString("Flight_Code"));
                } else {
                    JOptionPane.showMessageDialog(null, "No Flights Found");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == btnBookFlight) {
            Random random = new Random();
            String aadhar = tfAadhar.getText();
            String name = lblName.getText();
            String nationality = lblNationality.getText();
            String flightname = lblFlightName.getText();
            String flightcode = lblFlightCode.getText();
            String src =  source.getSelectedItem();
            String dest =  destination.getSelectedItem();
            String ddate =  ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();

            String price = "";

            try {
                DBConnection connection = new DBConnection();
                String priceQuery = "SELECT price FROM flight WHERE Flight_Code = '" + flightcode + "'";
                ResultSet rsPrice = connection.s.executeQuery(priceQuery);
                if (rsPrice.next()) {
                    price = "Rs " +rsPrice.getString("price");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }


            try {
                DBConnection connection = new DBConnection();

                String query = "INSERT INTO reservation VALUES (" +
                        "'" + "PNR-" + random.nextInt(1000000) + "', " +
                        "'" + "TIC-" + random.nextInt(10000) + "', " +
                        "'" + aadhar + "', " +
                        "'" + name + "', " +
                        "'" + nationality + "', " +
                        "'" + flightname + "', " +
                        "'" + flightcode + "', " +
                        "'" + src + "', " +
                        "'" + dest + "', " +
                        "'" + ddate + "', " +
                        "'" + price + "'" +
                        ")";


                connection.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                    setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
}

        public static void main (String[]args){

            new BookFlight();
        }
    }



