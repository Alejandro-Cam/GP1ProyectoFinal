package Vistas;

import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

public class EscritorioFondo extends JDesktopPane {

    private Image imagen;

    public EscritorioFondo() {

        imagen = new ImageIcon(
            getClass().getResource("/imagenes/fondo.jfif")
        ).getImage();

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawImage(
            imagen,
            0,
            0,
            getWidth(),
            getHeight(),
            this
        );
    }
}
