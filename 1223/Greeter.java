import javax.swing.JOptionPane;

public class Greeter {
    public void login(Account guest) {
        JOptionPane.showMessageDialog(null, getLoginMessage(guest));
    }

    private String getLoginMessage(Account guest) {
        switch (guest.getCountry()) {
            case JAPAN:
               return String.format("こんにちは, %sさん" , guest.getName());            case FRANCE:
                return String.format("Bonjour, monsieur/madame %s.", guest.getName());
            case GERMANY:
                return String.format("Guten Tag, Herr/Frau %s.", guest.getName());
            case USA:
            default:
                return String.format("Hello, Mr./Ms. %s.", guest.getName());
        }
    }

    public void logout (Account guest) {
        JOptionPane.showMessageDialog(null, getLogoutMessage(guest));
    }

    public String getLogoutMessage (Account guest) {
        switch (guest.getCountry()) {
            case JAPAN:
               return String.format("さようなら, %sさん" , guest.getName());            case FRANCE:
                return String.format("Au revoir, monsieur/madame %s.", guest.getName());
            case GERMANY:
                return String.format("Auf Wiedersehen, Herr/Frau %s.", guest.getName());
            case USA:
            default:
                return String.format("Goodbye, Mr./Ms. %s.", guest.getName());
        }

    }

}
