package tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.util.Random;


public class Offline extends JFrame {
    
    
    private JPanel userdetails,submitpanel;
    private JLabel p1,p2;
    private JButton submit;
    private JTextArea name1,name2;
    private String player_name1;
    private String player_name2;
    
    
    public Offline(){
        
        setSize(500,500);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout(20,20));
        setResizable(false);
        
        intiate();
        
    }
    
    
    private void intiate(){
        
        userdetails = new JPanel(new GridLayout(2,2,15,25));
        userdetails.setPreferredSize(new Dimension(200,200));
        userdetails.setBackground(Color.BLACK);
        
        //userdetails player 1
        p1 = new JLabel();
        p1.setBackground(new Color(20,25,0));
        p1.setForeground(new Color(0,250,20));
        p1.setFont(new Font("vedana",Font.ITALIC,50));
        p1.setHorizontalAlignment(JLabel.CENTER);
        p1.setText("Player 1");
        p1.setOpaque(true);
        
        
        name1 = new JTextArea();
        name1.setFont(new Font("vedana",Font.ITALIC,50));
        
        
        userdetails.add(p1);
        userdetails.add(name1);
        //System.out.println(name1.getText());
        
        p2 = new JLabel();
        p2.setBackground(new Color(20,25,0));
        p2.setForeground(new Color(0,250,20));
        p2.setFont(new Font("vedana",Font.ITALIC,50));
        p2.setHorizontalAlignment(JLabel.CENTER);
        p2.setText("Player 1");
        p2.setOpaque(true);
        
        
        name2 = new JTextArea();
        name2.setFont(new Font("vedana",Font.ITALIC,50));
        
        userdetails.add(p2);
        userdetails.add(name2);
       
        submitpanel = new JPanel();
        submitpanel.setPreferredSize(new Dimension(200,200));
        submitpanel.setBackground(Color.BLACK);
        //submitpanel.setBounds(500,500,500,63);
        
        submit = new JButton();
        submit.setText("Submit");
        submit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                game_start(name1.getText(),name2.getText());
            }
        });

        submit.setSize(150,100);
        
        submitpanel.add(submit,BorderLayout.CENTER);
        
        add(userdetails,BorderLayout.NORTH);
        add(submitpanel,BorderLayout.SOUTH);
        
    }
    public void game_start(String player1,String player2){
        System.out.println(player1+" "+player2);
        player_name1 = player1;
        player_name2 = player2;
        userdetails.setVisible(false);
        submitpanel.setVisible(false);
        setVisible(false);
        new GameBoard(player_name1,player_name2).setVisible(true);
    }
}
class GameBoard extends JFrame implements ActionListener{
    
    
    private String player_name1;
    private String player_name2;
    private Random random;
    private JPanel title_panel,button_panel;
    private JButton[] buttons;
    private JLabel text;
    private boolean draw;
    private boolean player1;
    private int count=0;
    public GameBoard(String name1,String name2){
        player_name1 = name1;
        player_name2=name2;
        title_panel = new JPanel();
        button_panel = new JPanel();
        text = new JLabel();
        buttons = new JButton[9];
        random = new Random();
        setSize(500,500);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout(20,20));
        setResizable(false);
        text.setBackground(new Color(20,25,0));
	text.setForeground(new Color(0,250,20));
	text.setFont(new Font("vedana",Font.ITALIC,75));
	text.setHorizontalAlignment(JLabel.CENTER);
	text.setText("Tic-Tac-Toe");
	text.setOpaque(true);
	
	title_panel.setLayout(new BorderLayout());
	title_panel.setBounds(0,0,500,63);
		
	button_panel.setLayout(new GridLayout(3,3));
	button_panel.setBackground(new Color(25,30,30));
		
	for (int i=0;i<9;i++) {
		buttons[i] = new JButton();
		button_panel.add(buttons[i]);
		buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
		buttons[i].setFocusable(false);
		buttons[i].addActionListener(this);
	}
		
	title_panel.add(text);
	add(title_panel,BorderLayout.NORTH);
	add(button_panel);
        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i =0 ;i<9;i++){
            if(e.getSource() == buttons[i]){
                if(player1){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(20,100,20));
                        buttons[i].setText("X");
                        player1 = false;
                        text.setText(player_name2+" turns (O)");
                        count+=1;
                        check();
                    }
                }
                else{
                        if(buttons[i].getText() == ""){
                                
                            buttons[i].setForeground(new Color(20,30,100));
                            buttons[i].setText("O");
                            player1 = true;
                            text.setText(player_name1+" turns (X)");  
                            count +=1;
                            check();
                        }
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
            text.setText(player_name1+" Turns (X)");
        }
        else{
            player1 = false;
            text.setText(player_name2+" turns (O)");
        }
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
    public void xwins(int a,int b,int c) {
    	buttons[a].setBackground(Color.green);
    	buttons[b].setBackground(Color.green);
    	buttons[c].setBackground(Color.green);
    	for (int i=0;i<9;i++) {
    		buttons[i].setEnabled(false);
    	}
    	text.setText("X Wins");
        
    }
	
    public void owins(int a ,int b,int c) {
    	buttons[a].setBackground(Color.green);
    	buttons[b].setBackground(Color.green);
    	buttons[c].setBackground(Color.green);
    	for (int i=0;i<9;i++) {
    		buttons[i].setEnabled(false);
    	}
    	text.setText("O Wins");
          
    }
    public void matchdraw() {
        for (int i=0;i<9;i++) {
            buttons[i].setEnabled(false);
        }
	text.setText("Match Draw");
    }
}//end of class
