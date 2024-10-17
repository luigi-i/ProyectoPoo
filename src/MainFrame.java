import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(mainPanel);

        setTitle("Gestion Automovil");
        setBounds(100, 100, 1080, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }


}
