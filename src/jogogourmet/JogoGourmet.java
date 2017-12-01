package jogogourmet;

import javax.swing.JFrame;

/**
 *
 * @author Marcos Felipe
 */
public class JogoGourmet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControllerGourmet control = new ControllerGourmet();
        JFrame principal = ViewGourmet.getFramePrincipal(control);
        principal.setVisible(true);
    }
    
}
