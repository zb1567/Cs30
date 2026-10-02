package Mastery;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BreakAPlateGUI implements ActionListener{
JFrame frame;
JPanel contentPane;
JLabel plateDisplay;
JLabel prizeWon;
JButton play;
BreakAPlate breakAPlate;
final String FIRST_PRIZE="First Prize";
final String CONSOLATION_PRIZE="Consolation Prize";
ImageIcon plates=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\plates.gif");
ImageIcon platesAllBroken=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\plates_all_broken.gif");
ImageIcon platesTwoBroken=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\plates_two_broken.gif");
ImageIcon tigerPlush=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\tiger_plush.gif");
ImageIcon sticker=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\sticker.gif");
ImageIcon placeholder=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\placeholder.gif");
public BreakAPlateGUI(){
breakAPlate=new BreakAPlate();
frame=new JFrame("Break A Plate");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
contentPane=new JPanel();
contentPane.setBackground(Color.WHITE);
contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
plateDisplay=new JLabel(plates);
plateDisplay.setAlignmentX(JLabel.CENTER_ALIGNMENT);
plateDisplay.setBorder(BorderFactory.createEmptyBorder(10,10,20,10));
contentPane.add(plateDisplay);
play=new JButton("Play");
play.setActionCommand("Play");
play.setAlignmentX(JButton.CENTER_ALIGNMENT);
play.addActionListener(this);
contentPane.add(play);
prizeWon=new JLabel(placeholder);
prizeWon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
prizeWon.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
contentPane.add(prizeWon);
frame.setContentPane(contentPane);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);
}
public void actionPerformed(ActionEvent event){
String eventName=event.getActionCommand();
String prize;
if(eventName.equals("Play")){
prize=breakAPlate.start();
if(prize.equals(FIRST_PRIZE)){
plateDisplay.setIcon(platesAllBroken);
prizeWon.setIcon(tigerPlush);
}else if(prize.equals(CONSOLATION_PRIZE)){
plateDisplay.setIcon(platesTwoBroken);
prizeWon.setIcon(sticker);
}
play.setText("Play Again");
play.setActionCommand("Play Again");
}else if(eventName.equals("Play Again")){
plateDisplay.setIcon(plates);
prizeWon.setIcon(placeholder);
play.setText("Play");
play.setActionCommand("Play");
}
}
private static void runGUI(){
JFrame.setDefaultLookAndFeelDecorated(true);
new BreakAPlateGUI();
}
public static void main(String[]args){
SwingUtilities.invokeLater(new Runnable(){
public void run(){
runGUI();
}
});
}
}
class BreakAPlate{
public String start(){
int number1=(int)(Math.random()*2);
int number2=(int)(Math.random()*2);
int number3=(int)(Math.random()*2);
if(number1==1&&number2==1&&number3==1){
return "First Prize";
}else{
return "Consolation Prize";
}
}
}