import javax.swing.*;

public class Zobrazeni extends JFrame{
    private JTextField textTXT;
    private JTextField vzorekTXT;
    private JButton hledatButton;
    private JButton krokDalButton;
    private JPanel Main;
    private JButton pripravitButton;
    private JLabel popisTXT;

    private String text;
    private String vzorek;

    private DemonstraceAlgoritmu demonstraceAlgoritmu;
    private DemonstraceAlgoritmu.Kroky Kroky;

    public Zobrazeni(){
        initcomponent();
        hledatButton.setEnabled(false);
        krokDalButton.setEnabled(false);
        pripravitButton.addActionListener(e -> pripravit());
        hledatButton.addActionListener(e -> posledniKrok());
        krokDalButton.addActionListener(e -> dalsiKrok());
        }

    private void initcomponent() {

        setContentPane(Main);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 200);
    }

    private void pripravit() {
        text = textTXT.getText();
        vzorek = vzorekTXT.getText();
        if (text == null) {
            JOptionPane.showMessageDialog(this, "Nebyl zadán text", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if(vzorek == null){
                JOptionPane.showMessageDialog(this, "Nebyl zadán vzorek", "ERROR", JOptionPane.ERROR_MESSAGE);
            }   else{
            hledatButton.setEnabled(true);
            krokDalButton.setEnabled(true);
            this.demonstraceAlgoritmu = new DemonstraceAlgoritmu(text, vzorek);
            this.demonstraceAlgoritmu.naZacatek();
            }
        }


    private void dalsiKrok() {
        demonstraceAlgoritmu.setPocetProvedenychKroku(demonstraceAlgoritmu.getPocetProvedenychKroku() + 1);
        popisTXT.setText(demonstraceAlgoritmu.getPopis());
        demonstraceAlgoritmu.provedKrok();
        if (demonstraceAlgoritmu.getAktualniKrok() == Kroky.KONEC) {
            if (DemonstraceAlgoritmu.konec == 1) {
                JOptionPane.showMessageDialog(this, "Vzorek '" + vzorek + "' byl nalezen v textu!");
                krokDalButton.setEnabled(false);
                popisTXT.setText("Konec hledání, vzorek byl nalezen.");
            } else {
                JOptionPane.showMessageDialog(this, "Vzorek '" + vzorek + "' nebyl nalezen v textu!");
                krokDalButton.setEnabled(false);
                popisTXT.setText("Konec hledání, vzorek nebyl nalezen.");
            }
        }
    }

    private void posledniKrok() {
        do{ demonstraceAlgoritmu.provedKrok();
        } while(demonstraceAlgoritmu.getAktualniKrok() != Kroky.KONEC);
            if (DemonstraceAlgoritmu.konec == 1){
                JOptionPane.showMessageDialog(this,"Vzorek '"+ vzorek +"' byl nalezen v textu!");
                hledatButton.setEnabled(false);
            }
            else{
                JOptionPane.showMessageDialog(this,"Vzorek '"+ vzorek +"' nebyl nalezen v textu!");
                hledatButton.setEnabled(false);
            }



    }



}
