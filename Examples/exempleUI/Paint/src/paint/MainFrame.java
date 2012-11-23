package paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Omar Rifi
 * Commentaires ajoute Pascal Fares
 */
public class MainFrame extends JFrame{
    JToolBar nord = new JToolBar();
    /**
     * La zone de dessin
     */
    JPanel canvas;
    /**
     * La ligne de status du bas (sud)
     */
    JPanel sud = new JPanel();
    /**
     * La barre du menu du haut dans la tool bar nord
     */
    JMenuBar bar = new JMenuBar();
    JMenu file=new JMenu("Fichier");
    JMenu aide =new JMenu("Aide");
    JMenuItem nouveau = new JMenuItem ("Nouveau");
    JMenuItem sortir = new JMenuItem("Sortir");

    String[] nomCouleur ={"Bleue","Rouge","Vert","Jaune"};
    Color[] couleurs ={Color.blue,Color.red,Color.green,Color.yellow};

    /**
     * Menu des couleurs dans une combo
     */
    JComboBox listeCouleur = new JComboBox(nomCouleur);

    /**
     * revenir en arriire (suprimer la derniere ligne)
     */
    JButton defaire = new JButton("Defaire");
    /**
     * Quiter l'application
     */
    JButton quitter = new JButton("Quitter");
    /**
     * initialisation du graphique
     */
    JButton effacer = new JButton("Tout Effacer");

    /**
     * Les 2 labels de la zone d'etat (en bas)
     */
    JLabel message=new JLabel("Cliquer pour initier");
    JLabel coord = new JLabel("x: 0, y: 0");

    int x, y;
    Color currentColor=Color.blue;
    /**
     * La listes des Droites
     */
    ArrayList<Droite> liste=new ArrayList<Droite>();
    Droite dc ;
    
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Paint");
        this.setLocation(200,200);
        this.setSize(400,300);

        nord.setLayout(new FlowLayout());

        canvas=new JPanel(){
            /**
             * Redessiner toutes les droites definis
             */
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                for(Droite d:liste)
                    d.dessiner(g);
            }
        };
        canvas.setBackground(Color.white);

        bar.add(file);
        bar.add(aide);
        file.add(nouveau);
        file.addSeparator();
        file.add(sortir);
        this.setJMenuBar(bar);

        nord.add(listeCouleur);
        nord.add(defaire);
        nord.add(effacer);
        nord.add(quitter);
        this.add(nord,BorderLayout.NORTH);

        this.add(canvas,BorderLayout.CENTER);

        sud.setLayout(new GridLayout(1,2));
        sud.add(message);
        sud.add(coord);
        this.add(sud,BorderLayout.SOUTH);
        
        sortir.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               System.exit(0);
           }
        });

        quitter.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               System.exit(0);
           }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e){
               setCoord(e.getX(), e.getY());
               //dessinerDroite(x,y,e.getX(),e.getY());
               //canvas.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e){
                //dessinerDroite(x,y,e.getX(),e.getY());
                dc.setOtherPoint(e.getX(), e.getY());
                canvas.repaint();
            }
        });

        canvas.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                canvas.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e){
                x=e.getX();
                y=e.getY();
                message.setText("Relacher pour dessiner");
                dc=new Droite(x,y,0,0,currentColor);
                liste.add(dc);
            }

            @Override
            public void mouseReleased(MouseEvent e){
                //dessinerDroite(x,y,e.getX(),e.getY());
                //liste.add(new Droite(x,y,e.getX(),e.getY(),currentColor));
                dc.setOtherPoint(e.getX(), e.getY());
                canvas.repaint();
                message.setText("Cliquer pour initier");
            }
        });

        listeCouleur.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int i=listeCouleur.getSelectedIndex();
                currentColor = couleurs[i];
            }
        });

        defaire.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                liste.remove(liste.size()-1);
                canvas.repaint();
            }
        });

        effacer.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                liste.clear();
                canvas.repaint();
            }
        });

    }

    
    private void setCoord(int x, int y){
        coord.setText("x: "+x+", y: "+y);
    }

    public static void main(String[] arg){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        new MainFrame().setVisible(true);
    }

}
