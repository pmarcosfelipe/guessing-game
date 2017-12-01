package jogogourmet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcos Felipe
 */
public class ViewGourmet {

    public static JFrame getFramePrincipal(ControllerGourmet control) {
        JFrame frame;
        JLabel startLabel = new JLabel("Pense em um prato que você gosta.");
        startLabel.setBounds(55, 50, 280, 50);
        JButton startButton = new JButton("OK");
        startButton.setBounds(110, 100, 95, 30);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                control.iniciarRecursao();
            }
        });

        frame = new JFrame("Jogo Gourmet");
        frame.add(startButton);
        frame.add(startLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(330, 220);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        return frame;
    }

    public static void showAcertei() {
        JOptionPane.showMessageDialog(
                null,
                "Acertei!", 
                "Jogo Gourmet",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    public static int showPerguntaPrato(String descricao) {
        return JOptionPane.showConfirmDialog(
                null,
                "O prato que você pensou é " + descricao + "?",
                "Jogo Gourmet",
                JOptionPane.YES_NO_OPTION
        );
    }
    
    public static String showPerguntaNovoPrato(){
        return JOptionPane.showInputDialog(
                null,
                "Qual prato você pensou?", 
                "Jogo Gourmet",
                JOptionPane.QUESTION_MESSAGE
        );
    }
    
    public static String showPerguntaDiferenca(String novoDesc, String atualDesc){
        return JOptionPane.showInputDialog(
                null,
                novoDesc + " é ________ mas " + atualDesc + " não.", 
                "Jogo Gourmet",
                JOptionPane.QUESTION_MESSAGE
        );
    }
    
}
