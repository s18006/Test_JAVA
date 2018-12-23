import javax.swing.JOptionPane;


public class Main {
    public static void main (String args[]) {
        String name = JOptionPane.showInputDialog("Name");
        Country home = Country.valueOf(JOptionPane.showInputDialog("Country"));
        Account guest = new Account(name, home);
        Greeter greeter = new Greeter();
        greeter.login(guest);
        greeter.logout(guest);
    }

}
