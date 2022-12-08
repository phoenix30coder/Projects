
package tictactoe;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;

public class Game extends JFrame implements ActionListener{
    private String name1,name2;
    private JPanel boardpanel,statuspanel,titlepanel,scorepanel;
    private JButton[] buttons;
    private JLabel title,status,playername1,playername2,score1,score2;
    private JButton reset_btn,exit_btn;
    private Border black = BorderFactory.createLineBorder(Color.BLACK,4);
    private Border red = BorderFactory.createLineBorder(Color.RED,8);
    private Font myFont = new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,20);
    
    private boolean draw;
    private boolean player1;
    private int count=0;
    private Random random = new Random();
    private int score_x = 0,score_o=0;
    private boolean exit = false;
    

    public Game(String player1,String player2){
        if(player1.length() == 0 && player2.length() == 0){
            this.name1 = "Player 1";
            this.name2 = "Player 2";
            
        }
        else{
        this.name1 = player1;
        this.name2 = player2;
        }
        setSize(800,700);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new BorderLayout(5,5));
        start();
        firstTurn();
    }
    private void start(){
        titlepanel = new JPanel();
        titlepanel.setSize(900,50);
        titlepanel.setBackground(Color.GRAY);
        titlepanel.setBorder(black);
        
        title = new JLabel("Tic-Tac-Toe");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(myFont);
        
        titlepanel.add(title);
        add(titlepanel,BorderLayout.NORTH);
        
        statuspanel = new JPanel();
        statuspanel.setSize(900,50);
        statuspanel.setBackground(Color.GRAY);
        statuspanel.setBorder(black);
        
        status = new JLabel(".........");
        status.setHorizontalAlignment(JLabel.CENTER);
        status.setFont(myFont);
        
        
        statuspanel.add(status);
        add(statuspanel,BorderLayout.SOUTH);
        
        buttons = new JButton[9];
        boardpanel = new JPanel(new GridLayout(3,3,5,5));
        boardpanel.setPreferredSize(new Dimension(600,600));
        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttons[i].setFont(myFont);
            buttons[i].setFocusable(false);
            buttons[i].setBackground(Color.GRAY);
            buttons[i].setBorder(black);
            boardpanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        add(boardpanel,BorderLayout.CENTER);
        
        
        //score board implement
        
        scorepanel = new JPanel(new GridLayout(3,2,5,5));
        scorepanel.setPreferredSize(new Dimension(300,600));
        scorepanel.setSize(300,600);
        
        playername1 = new JLabel(name1);
        playername1.setHorizontalAlignment(JLabel.CENTER);
        playername1.setFont(myFont);
        playername1.setBorder(black);
        
        score1 = new JLabel();
        score1.setText("0");
        score1.setHorizontalAlignment(JLabel.CENTER);
        score1.setFont(new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,40));
        score1.setBorder(black);      
        
        playername2 = new JLabel(name2);
        playername2.setHorizontalAlignment(JLabel.CENTER);
        playername2.setFont(myFont);
        playername2.setBorder(black);
        
        score2= new JLabel("0");
        score2.setHorizontalAlignment(JLabel.CENTER);
        score2.setFont(new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,40));
        score2.setBorder(black);
        
        reset_btn = new JButton("RESET");
        reset_btn.addActionListener(this);
        reset_btn.setBorder(black);
        reset_btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,30));
        
        exit_btn = new JButton("EXIT");
        exit_btn.setBorder(black);
        exit_btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,30));
        
        scorepanel.add(playername1);
        scorepanel.add(score1);
        scorepanel.add(playername2);
        scorepanel.add(score2);
        scorepanel.add(reset_btn);
        scorepanel.add(exit_btn);
        
        add(scorepanel,BorderLayout.EAST);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i =0 ;i<9;i++){
            if(e.getSource() == buttons[i]){
                if(player1){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(20,100,20));
                        buttons[i].setText("X");
                        buttons[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,40));
                        player1 = false;
                        status.setText(name2+" turns (O)");
                        playername2.setBorder(red);
                        playername1.setBorder(black);
                        count+=1;
                        check();
                    }
                }
                else{
                        if(buttons[i].getText() == ""){
                                
                            buttons[i].setForeground(new Color(20,30,100));
                            buttons[i].setText("O");
                            buttons[i].setFont(new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,40));
                            player1 = true;
                            status.setText(name1+" turns (X)");
                            playername1.setBorder(red);
                            playername2.setBorder(black);
                            count +=1;
                            check();
                        }
                }
            }
        }
        if(e.getSource() == reset_btn){
            for(int i=0;i<9;i++){
                buttons[i].setText("");
            }
            for (int i=0;i<9;i++) {
                buttons[i].setEnabled(true);
                buttons[i].setBackground(Color.GRAY);
            }
            count=0;
            firstTurn();
        }
        //gfjhgh
    }
public void check(){
        
        //X wins
        if(buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
            xwins(0,1,2);
        }
        if(buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X") {
            xwins(3,4,5);
        }
        if(buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X") {
            xwins(6,7,8);
        }
        if(buttons[0].getText() == "X" && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
            xwins(0,4,8);
        }
        if(buttons[2].getText() == "X" && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
            xwins(2,4,6);
        }
        if(buttons[0].getText() == "X" && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
            xwins(0,3,6);
        }
        if(buttons[2].getText() == "X" && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
            xwins(2,5,8);
        }
        if(buttons[1].getText() == "X" && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
            xwins(1,4,7);
        }
        //O wins
        if(buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O") {
            owins(0,1,2);
        }
        if(buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O") {
            owins(3,4,5);
        }
        if(buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O") {
            owins(6,7,8);
        }
        if(buttons[0].getText() == "O" && buttons[4].getText() == "O" && buttons[8].getText() == "O") {
            owins(0,4,8);
        }
        if(buttons[2].getText() == "O" && buttons[4].getText() == "O" && buttons[6].getText() == "O") {
            owins(2,4,6);
        }
        if(buttons[0].getText() == "O" && buttons[3].getText() == "O" && buttons[6].getText() == "O") {
            owins(0,3,6);
        }
        if(buttons[2].getText() == "O" && buttons[5].getText() == "O" && buttons[8].getText() == "O") {
                owins(2,5,8);
        }
        if(buttons[1].getText() == "O" && buttons[4].getText() == "O" && buttons[7].getText() == "O") {
            owins(1,4,7);
        }
        else{
            for (int i =0;i<9;i++){
                if(buttons[i].getText() != ""){
                    draw = true;
                }
                else{
                    draw = false;
                }
            }
            if(count == 9){
            if(draw){
                matchdraw();
            }
            }
        }
        
    }

    public void firstTurn(){
        try{
            Thread.sleep(3000);
            
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        if(random.nextInt(2) ==0){
            player1 = true;
            status.setText(name1+" Turns (X)");
            playername1.setBorder(red);
            playername2.setBorder(black);
        }
        else{
            player1 = false;
            status.setText(name2+" turns (O)");
            playername2.setBorder(red);
            playername1.setBorder(black);
        }
    }
    public void xwins(int a,int b,int c) {
    	buttons[a].setBackground(Color.blue);
    	buttons[b].setBackground(Color.blue);
    	buttons[c].setBackground(Color.blue);
    	for (int i=0;i<9;i++) {
    		buttons[i].setEnabled(false);
    	}
    	status.setText(name1+"X Wins");
        score_x+=1;
        
        score1.setText(Integer.toString(score_x));
        score1.setFont(new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,40));
    }
	
    public void owins(int a ,int b,int c) {
    	buttons[a].setBackground(Color.blue);
    	buttons[b].setBackground(Color.blue);
    	buttons[c].setBackground(Color.blue);
    	for (int i=0;i<9;i++) {
    		buttons[i].setEnabled(false);
    	}
    	status.setText(name2+"O Wins");
        score_o+=1;
        score2.setText(Integer.toString(score_o));
        score2.setFont(new Font(Font.SANS_SERIF,Font.BOLD|Font.ITALIC,40));
          
    }
    public void matchdraw() {
        for (int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
	status.setText("Match Draw");
    }
}
