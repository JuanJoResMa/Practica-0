import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaJuego extends JFrame {
    protected JPanel panelCoche;
    protected JLabel label;
    protected CocheVentana coche;
    protected JPanel panelBotones;
    protected JButton acelerar;
    protected JButton frenar;
    protected JButton giroIzq;
    protected JButton giroDer;
    protected Thread MiHilo;

    public VentanaJuego() {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800, 800);
        this.setLayout(new BorderLayout());

        //Panel Coche
        this.panelCoche = new JPanel();
        panelCoche.setPreferredSize(new Dimension(800, 700));
        this.coche = new CocheVentana(0, 0, 150, 100, "piloto0");
        this.label = coche.getSpriteCoche();
        panelCoche.add(label);

        //Acelerar
        this.acelerar = new JButton("Acelerar");
        acelerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coche.acelerar(5);
            }
        });

        //Frenar
        this.frenar = new JButton("Frenar");
        frenar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (coche.getMiVelocidad() > 0 ) {
                    coche.acelerar(-5);
                }
            }
        });

        //Girar izquierda
        this.giroIzq = new JButton("Izquierda");
        giroIzq.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coche.girar(-10);
            }
        }));

        //Girar derecha
        this.giroDer = new JButton("Derecha");
        giroDer.addActionListener((new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coche.girar(10);
            }
        }));

        //Panel botones
        this.panelBotones = new JPanel();
        panelBotones.add(acelerar);
        panelBotones.add(frenar);
        panelBotones.add(giroIzq);
        panelBotones.add(giroDer);

        //Pocicion paneles
        this.add(panelCoche, BorderLayout.NORTH);
        this.add(panelBotones, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true);

        //Hilo
        this.MiHilo = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    coche.mover();
                    label.setLocation((int) coche.getPosX(), (int) coche.getPosY());
                    try {
                        Thread.sleep(40);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        });
        MiHilo.run();
    }
    public static void main(String[] args) {
    new VentanaJuego();
    }
}

