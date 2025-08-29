package control;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class OnibusThread extends JLabel implements Runnable {
    private Thread OnibusThread = null;
    private int posX;
    private int posY;
    private ImageIcon imagem;
    private static int pos=0;
    private String nome;
    // CONSTRUTOR DEFAULT
    public OnibusThread() {
       
    }
    // CONSTRUTOR SOBRECARREGADO
    public OnibusThread(String nome, ImageIcon img, int posX, int posY){
    super(img);
    this.imagem = img;
    this.posX = posX;
    this.posY = posY;
    this.nome = nome;
 
    OnibusThread = new Thread(this, nome);
    OnibusThread.start();
   
    }
    // M�TODO RUN() DA INTERFACE RUNNABLE
    @Override
    public void run() {
        posX += new Random().nextInt(3) * 5;
        this.setLocation(posX, posY);

        if (posX >= 1280) {
        	pos++;
        	 JOptionPane.showMessageDialog(null, pos + ")" + nome);
        	return;

        }
            
        try {
            Thread.sleep(new Random().nextInt(5) * 5);
            run();
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}