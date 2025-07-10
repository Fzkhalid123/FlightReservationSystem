   package flightreservationsystem;

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.sql.Connection;
   import java.sql.ResultSet;

   public class Login extends JFrame implements ActionListener {
            JButton btnSubmit, btnReset, btnClose;
            JTextField tfUsername;
            JPasswordField tfPassword;

            public Login() {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel lblUsername = new JLabel("Username");
            lblUsername.setBounds(20, 20, 100, 20);
            add(lblUsername);

            tfUsername = new JTextField();
            tfUsername.setBounds(130, 20, 200, 20);
            add(tfUsername);

            JLabel lblPassword = new JLabel("Password");
            lblPassword.setBounds(20, 60, 100, 20);
            add(lblPassword);

            tfPassword = new JPasswordField();
            tfPassword.setBounds(130, 60, 200, 20);
            add(tfPassword);

            btnReset = new JButton("Reset");
            btnReset.setBounds(40, 120, 120, 20);
            btnReset.addActionListener(this);
            add(btnReset);

            btnSubmit = new JButton("Submit");
            btnSubmit.setBounds(190, 120, 120, 20);
            btnSubmit.addActionListener(this);
            add(btnSubmit);

            btnClose = new JButton("Close");
            btnClose.setBounds(120, 160, 120, 20);
            btnClose.addActionListener(this);
            add(btnClose);

            setLocation(1000, 250);
            setSize(400, 250);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent actionevent) {
            if (actionevent.getSource() == btnSubmit) {

                String username = tfUsername.getText();
                String password = tfPassword.getText();

                try {
                    DBConnection c = new DBConnection();

                    String query = "select * from login where username = '" + username + "' and password = '" + password + "'";

                    ResultSet rs = c.s.executeQuery(query);

                    if (rs.next()) {
                       new Home();
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                        setVisible(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

           else if (actionevent.getSource() == btnClose) {
                setVisible(false);
            } else if (actionevent.getSource() == btnReset) {
                tfUsername.setText("");
                tfPassword.setText("");

            }
        }

        public static void main(String args[]) {
            new Login();

        }
    }





