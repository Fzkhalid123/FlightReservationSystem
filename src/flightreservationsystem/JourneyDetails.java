package flightreservationsystem;

import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

import java.sql.ResultSet;

public class JourneyDetails extends JFrame implements ActionListener {

        JTable table;
        JTextField  tfPnr;
        JButton btnShow;

        public JourneyDetails() {

            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel lblPnr = new JLabel("PNR Details");
            lblPnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblPnr.setBounds(50, 50, 100, 25);
            add(lblPnr);

            tfPnr = new JTextField();
            tfPnr.setBounds(160, 50, 120, 25);
            add(tfPnr);

            btnShow = new JButton("Show Details");
            btnShow.setBackground(Color.BLACK);
            btnShow.setForeground(Color.WHITE);
            btnShow.setBounds(290, 50, 120, 25);
            btnShow.addActionListener(this);
            add(btnShow);

            table = new JTable();

            JScrollPane jsp = new JScrollPane(table);
            jsp.setBounds(0, 100, 800, 150);
            jsp.setBackground(Color.WHITE);
            add(jsp);

            setSize(800, 600);
            setLocation(400, 150);
            setVisible(true);

        }

        public void actionPerformed(ActionEvent ae) {


            try {
                DBConnection connection = new DBConnection();

                ResultSet rs = connection.s.executeQuery("select * from reservation where PNR = '" + tfPnr.getText() + "'");

                if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Invalid PNR");
                return;
                }
              table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            new JourneyDetails();
        }
    }




