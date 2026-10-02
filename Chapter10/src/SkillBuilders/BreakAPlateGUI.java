package SkillBuilders;
import javax.swing.*;
import java.awt.event.*;

public class BreakAPlateGUI implements ActionListener {

    JFrame frame;
    JPanel contentPane;

    JLabel plates;
    JLabel prizeWon;

    JButton play;

    BreakAPlate breakAPlate;

    final String FIRST_PRIZE = "First Prize";
    final String CONSOLATION_PRIZE = "Consolation Prize";

    public BreakAPlateGUI() {

        /* Create the Break A Plate game */
        breakAPlate = new BreakAPlate();

        /* Create and set up the frame */
        frame = new JFrame("Break A Plate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane with a BoxLayout */
        contentPane = new JPanel();
        contentPane.setLayout(
            new BoxLayout(contentPane, BoxLayout.PAGE_AXIS)
        );

        /* Create a label that shows the start of the game */
        plates = new JLabel(new ImageIcon("plates.gif"));
        plates.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        plates.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 20, 10)
        );
        contentPane.add(plates);

        /* Create a Play button */
        play = new JButton("Play");
        play.setActionCommand("Play");
        play.setAlignmentX(JButton.CENTER_ALIGNMENT);
        play.addActionListener(this);
        contentPane.add(play);

        /* Create a label that will show prizes won */
        prizeWon = new JLabel(" ");
        prizeWon.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        prizeWon.setBorder(
            BorderFactory.createEmptyBorder(20, 0, 0, 0)
        );
        contentPane.add(prizeWon);

        /* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame */
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Handle the button click
     * pre: none
     * post: The appropriate image and message are displayed.
     */
    public void actionPerformed(ActionEvent event) {

        String eventName = event.getActionCommand();
        String prize;

        if (eventName.equals("Play")) {

            prize = breakAPlate.start();

            if (prize.equals(FIRST_PRIZE)) {

                plates.setIcon(
                    new ImageIcon("plates_all_broken.gif")
                );

            } else if (prize.equals(CONSOLATION_PRIZE)) {

                plates.setIcon(
                    new ImageIcon("plates_two_broken.gif")
                );
            }

            prizeWon.setText("You win: " + prize);

            play.setText("Play Again");
            play.setActionCommand("Play Again");

        } else if (eventName.equals("Play Again")) {

            plates.setIcon(
                new ImageIcon("plates.gif")
            );

            prizeWon.setText(" ");

            play.setText("Play");
            play.setActionCommand("Play");
        }
    }

    public static void main(String[] args) {

        new BreakAPlateGUI();
    }
}


/*
 * BreakAPlate game logic
 */
class BreakAPlate {

    public String start() {

        int number = (int)(Math.random() * 2);

        if (number == 0) {
            return "First Prize";
        } else {
            return "Consolation Prize";
       
         }
        
        
        
        
    }
}