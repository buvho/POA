 package view;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.BoldAction;

import control.OnibusThread;

@SuppressWarnings("serial")
public class Janela extends JFrame implements ActionListener {

    private JButton btnCorrida;
    private JButton btnCancel;
    private JLabel lblPista;
    private JLabel lblVelocimetro;
    private ImageIcon imgOnibus1;
    private ImageIcon imgOnibus2;
    private ImageIcon imgOnibus3;
    private ImageIcon pista;
    private ImageIcon velocimetro;
    private Boolean started = false;
    public Janela() {
        super();
               // ADICIONANDO ELEMENTOS AO FORMUL�RIO
        this.setLayout(null);
        this.setSize(1280, 650);
        this.setLocation(50, 50);
        this.setResizable(false);
        getContentPane().setBackground(Color.white);
       
        this.setTitle("Corrida de Threads");
        velocimetro = new ImageIcon("./src/imagens/velocimetro.gif");
        pista = new ImageIcon("./src/imagens/pista.png");
       
        this.lblPista = new JLabel(pista);
        this.lblVelocimetro = new JLabel(velocimetro);
        // POSICIONANDO OS ELEMENTOS DO FORM
        this.lblVelocimetro.setBounds(200, 490, 150, 150);
        this.lblPista.setBounds(0, 10, 1280, 650);
       
        this.add(lblPista);
        this.lblPista.add(lblVelocimetro);
       
        this.lblPista.setBackground(Color.BLACK);

        this.btnCorrida = new JButton("Começar");
        this.btnCancel = new JButton("Terminar");
                  // POSIONADO OS BOT�ES
        this.btnCorrida.setBounds(500, 550, 120, 50);
        this.btnCancel.setBounds(640, 550, 120, 50);
                    // INSERINDO AS IMAGENS DOS OnibusS
        imgOnibus1 = new ImageIcon("./imagens/b1.png");
        imgOnibus2 = new ImageIcon("./imagens/b2.png");
        imgOnibus3 = new ImageIcon("./imagens/b3.png");
       
        this.lblPista.add(btnCorrida);
        this.lblPista.add(btnCancel);

        this.setVisible(true);

        btnCorrida.addActionListener(this);
        btnCancel.addActionListener(this);

        JPanel jPanel = new JPanel();
        jPanel.setSize(300, 70);
        jPanel.setLayout(null);
        jPanel.setLocation(970, 510);
        jPanel.setBorder(BorderFactory.createTitledBorder("Caio e Derek"));
        jPanel.setVisible(true);

        this.repaint();

    }
     // INSERINDO AS JLABELS DOS OnibusS
     public JLabel JLabelOnibuss(String nome, ImageIcon img, int posX, int posY) {
        OnibusThread Onibus = new OnibusThread(nome, img, posX, posY);
        Onibus.setSize(256, 141);
        Onibus.setVisible(true);
        this.add(Onibus);
        return Onibus;
    }
          // PROGRAMANDO A A��O DOS BOT�ES
    @Override
    public void actionPerformed(ActionEvent dispara) {
        if (dispara.getSource() == this.btnCorrida && !started) {
            started = true;
            this.lblPista.add(JLabelOnibuss("Ônibus 1", imgOnibus1, 0, 50));
            this.lblPista.add(JLabelOnibuss("Ônibus 2", imgOnibus2, 0, 200));
            this.lblPista.add(JLabelOnibuss("Ônibus 3", imgOnibus3, 0, 350));
        }
        if (dispara.getSource() == this.btnCancel) {
            System.exit(0);
        }
    }
}