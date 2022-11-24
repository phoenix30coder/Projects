package tictactoe;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe extends JFrame implements ActionListener{
    
    private String player1,player2;
   
    private JButton start;
    private JTextArea name1,name2;
    private JLabel title,pl1,pl2;

    
    public TicTacToe(){
        setSize(400,300);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        getContentPane().setLayout(null);
        title = new JLabel();
        title.setText("Tic-Tac-Toe");
        title.setSize(400,50);
        title.setLocation(0,0);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("vedana",Font.ITALIC,20));
        add(title);
        
        pl1 = new JLabel("Player 1");
        pl1.setSize(200,50);
        pl1.setLocation(0,50);
        pl1.setHorizontalAlignment(JLabel.CENTER);
        pl1.setFont(new Font("vedana",Font.ITALIC,20));
        add(pl1);
        
        name1 = new JTextArea();
        name1.setSize(190,50);
        name1.setLocation(200,50);
        name1.setFont(new Font("vedana",Font.ITALIC,20));
        add(name1);
        
        pl2 = new JLabel("Player 2");
        pl2.setSize(200,50);
        pl2.setLocation(0,130);
        pl2.setHorizontalAlignment(JLabel.CENTER);
        pl2.setFont(new Font("vedana",Font.ITALIC,20));
        add(pl2);
        
        name2 = new JTextArea();
        name2.setSize(190,50);
        name2.setLocation(200,130);
        name2.setFont(new Font("vedana",Font.ITALIC,20));
        add(name2);
        
        start = new JButton("START");
        start.setSize(100,50);
        start.setFocusable(false);
        start.setLocation(150,200);
        start.setFont(new Font("vedana",Font.ITALIC,20));
        start.addActionListener(this);
        add(start);
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start){
            player1 = name1.getText();
            player2 = name2.getText();
            System.out.println(player1+"  "+player2);
            setVisible(false);
            Game game = new Game(player1,player2);
            game.setVisible(true);
           
        }
    }    
}
