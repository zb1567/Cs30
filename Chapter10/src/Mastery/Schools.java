package Mastery;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Schools implements ActionListener{
    JFrame frame;
    JPanel panel;
    JTextField firstName,lastName;
    JComboBox<String> grade,school;
    JButton submit;
    JTextArea output;
    JLabel schoolImage;
    ImageIcon western=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\western.png");
    ImageIcon churchill=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\churchill.jpg");
    ImageIcon aberhart=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\aberhart.png");
    ImageIcon crescent=new ImageIcon("C:\\Users\\410015006\\git\\Cs30\\Chapter10\\src\\SkillBuilders\\crescent.png");
    public Schools(){
        frame=new JFrame("Schools");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel=new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(550,420));
        firstName=new JTextField("first name");
        firstName.setBounds(20,30,160,25);
        panel.add(firstName);
        lastName=new JTextField("last name");
        lastName.setBounds(190,30,160,25);
        panel.add(lastName);
        String[] grades={"10","11","12"};
        grade=new JComboBox<String>(grades);
        grade.setBounds(20,80,90,30);
        panel.add(grade);
        String[] schools={"Western","Churchill","William Aberhart","Crescent Heights"};
        school=new JComboBox<String>(schools);
        school.setBounds(190,80,160,30);
        panel.add(school);
        submit=new JButton("Submit");
        submit.setBounds(370,30,120,140);
        submit.addActionListener(this);
        panel.add(submit);
        output=new JTextArea();
        output.setBounds(20,140,330,70);
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setForeground(Color.BLUE);
        panel.add(output);
        schoolImage=new JLabel();
        schoolImage.setBounds(20,240,300,160);
        schoolImage.setHorizontalAlignment(JLabel.CENTER);
        panel.add(schoolImage);
        frame.setContentPane(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        String selectedSchool=(String)school.getSelectedItem();
        output.setText(firstName.getText().trim()+" "+lastName.getText().trim()+" is in grade: "+grade.getSelectedItem()+"\nand goes to "+selectedSchool+" high school.");
        ImageIcon selectedImage;
        if(selectedSchool.equals("Western")){
            selectedImage=western;
        }else if(selectedSchool.equals("Churchill")){
            selectedImage=churchill;
        }else if(selectedSchool.equals("William Aberhart")){
            selectedImage=aberhart;
        }else{
            selectedImage=crescent;
        }
        if(selectedImage.getIconWidth()>0){
            double scale=Math.min(250.0/selectedImage.getIconWidth(),160.0/selectedImage.getIconHeight());
            int width=(int)(selectedImage.getIconWidth()*scale);
            int height=(int)(selectedImage.getIconHeight()*scale);
            Image resized=selectedImage.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
            schoolImage.setText("");
            schoolImage.setIcon(new ImageIcon(resized));
        }else{
            schoolImage.setIcon(null);
            schoolImage.setText("Cannot load "+selectedSchool+" image.");
            JOptionPane.showMessageDialog(frame,"Check that this file exists and is a valid image:\n"+selectedImage.getDescription());
        }
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new Schools();
            }
        });
    }
}