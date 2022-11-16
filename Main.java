package tictactoe;

//importing necessary modules
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args){
        new TicTacToe(500,500).setVisible(true);
    }
}

class TicTacToe  extends JFrame{
    
    private JPanel title,mode;
    private JLabel title_name;
    private JButton mode1,mode2;
    
    
    public TicTacToe(int width,int height){
        setSize(width,height);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        
        
        title = new JPanel();
        title.setLayout(new BorderLayout());
	title.setBounds(0,0,500,63);

        title_name = new JLabel();
        title_name.setBackground(new Color(20,25,0));
        title_name.setForeground(new Color(0,250,20));
        title_name.setFont(new Font("vedana",Font.ITALIC,50));
        title_name.setHorizontalAlignment(JLabel.CENTER);
        title_name.setText("Tic-Tac-Toe");
        title_name.setOpaque(true);
        
        
        mode = new JPanel();
        mode.setLayout(new GridLayout(2,1,5,5));
        
        mode.setBounds(0,0,250,(500-63));
        
        mode1 = new JButton();
        mode1.setText("Offline");
        mode1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new Offline().setVisible(true);
                System.out.println("clicked   ");
                
            }
    });
        //mode1.setSize(80,80);
        mode2 = new JButton();
        mode2.setText("Online");
        mode2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        title.add(title_name);

        mode.add(mode1);
        mode.add(mode2);
        
        
        
        add(title,BorderLayout.NORTH);
        add(mode);
        
    
}
    
}
