   package flightreservationsystem;

   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.sql.Connection;
   import java.sql.ResultSet;

   public class Login extends JFrame implements ActionListener {
            JButton submit, reset, close;
            JTextField textforusername;
            JPasswordField textforpassword;

            public Login() {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel labelusername = new JLabel("Username");
            labelusername.setBounds(20, 20, 100, 20);
            add(labelusername);

            textforusername = new JTextField();
            textforusername.setBounds(130, 20, 200, 20);
            add(textforusername);

            JLabel labelpassword = new JLabel("Password");
                labelpassword.setBounds(20, 60, 100, 20);
            add(labelpassword);

            textforpassword = new JPasswordField();
            textforpassword.setBounds(130, 60, 200, 20);
            add(textforpassword);

            reset = new JButton("Reset");
            reset.setBounds(40, 120, 120, 20);
            reset.addActionListener(this);
            add(reset);

            submit = new JButton("Submit");
            submit.setBounds(190, 120, 120, 20);
            submit.addActionListener(this);
            add(submit);

            close = new JButton("Close");
            close.setBounds(120, 160, 120, 20);
            close.addActionListener(this);
            add(close);

            setLocation(1000, 250);
            setSize(400, 250);
            setVisible(true);
        }

        public void actionPerformed(ActionEvent actionevent) {
            if (actionevent.getSource() == submit) {

                String username = textforusername.getText();
                String password = textforpassword.getText();

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

           else if (actionevent.getSource() == close) {
                setVisible(false);
            } else if (actionevent.getSource() == reset) {
                textforusername.setText("");
                textforpassword.setText("");

            }
        }

        public static void main(String args[]) {
            new Login();

        }
    }





