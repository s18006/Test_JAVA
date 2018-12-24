import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class ValueCalc extends JFrame implements KeyListener, ItemListener, MouseListener {
    private static final long serialVersionUID = 1L;
    JLabel firstLabel = new JLabel("  ");
    JLabel basicCurrencyLabel = new JLabel(" ");
    JTextField textField = new JTextField(5);
    JLabel label = new JLabel("     ");
    JComboBox<String> selectField = new JComboBox<>();

    NumberFormat currencyYEN = NumberFormat.getCurrencyInstance();
    NumberFormat currencyEUR = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    //NumberFormat currencyYEN = NumberFormat.getCurrencyInstance(Locale.JAPAN);

    public ValueCalc() {
        setLayout(new FlowLayout());
        add(firstLabel);
        String firstLabelString = "換算";
        firstLabel.setText(firstLabelString);

        add(basicCurrencyLabel); //kiindulo penzcimke
        add(textField);
        selectField.addItem("円からユーロへ換算しよう");
        selectField.addItem("ユーロから円へ換算しよう");
        add(label);
        add(selectField);

        textField.addKeyListener(this);
        selectField.addItemListener(this);
        label.addMouseListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(300, 120);
        setVisible(true);
    }

    void setLabelText() {
        String sumString = "";
        String basicCurrency = "";

        try {
            double  amount = Double.parseDouble(textField.getText());

            if (selectField.getSelectedItem().equals("円からユーロへ換算しよう")) {
                sumString = " = " + currencyEUR.format(amount * 0.0079);
                basicCurrency = "円";
            }

            if (selectField.getSelectedItem().equals("ユーロから円へ換算しよう")) {
                sumString = " = " + currencyYEN.format(amount * 125.93);
                basicCurrency = "\u20AC";
            }
        } catch (NumberFormatException e) {
        }
        label.setText(sumString);
        basicCurrencyLabel.setText(basicCurrency);
    }


    @Override
    public void keyReleased(KeyEvent k) {
        setLabelText();
    }

    @Override
    public void keyPressed(KeyEvent k) {
    }

    @Override
    public void keyTyped(KeyEvent k) {
    }

    @Override
    public void itemStateChanged(ItemEvent i) {
        setLabelText();
    }

    @Override
    public void mouseEntered(MouseEvent m) {
        label.setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent m) {
        label.setForeground(Color.black);
    }

    @Override
    public void mouseClicked(MouseEvent m) {
    }

    @Override
    public void mousePressed(MouseEvent m) {
    }

    @Override
    public void mouseReleased(MouseEvent m) {
    }
}
