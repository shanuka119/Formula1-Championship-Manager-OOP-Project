import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Random;



public class MainMenu implements ActionListener {



    //main menu of the graphical user interface
    //adding the buttons and the text fields to the frame and the jpanel
    JFrame frame = new JFrame();
    JButton button1 = new JButton("Ascending Order");
    JButton button2 = new JButton("Descending Order");
    JButton button3 = new JButton("Sort By Wins");
    JButton button4 = new JButton("Generate Race");
    JButton button5 = new JButton("Generate Probability Race");
    JButton button6 = new JButton("Search");
    JButton button7 = new JButton("Sort Dates");
    JTextField textField = new JTextField();
    JLabel label = new JLabel();

        //creating the panel
    JPanel panel = new JPanel();
    private int racePosition;


    MainMenu(){

        frame.setLayout(new BorderLayout());
        frame.setTitle("Formula 1 Championship");
        frame.add(panel, BorderLayout.NORTH);
        frame.getContentPane().setBackground(new Color(0Xff6f60));
        panel.setBackground(new Color(0Xff6f60));


        panel.add(textField);
        panel.add(button6);
        panel.add(label);


        textField.setPreferredSize(new Dimension(250, 40));
        label.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);

        frame.pack();


        frame.setSize(1000,1200);
        panel.setBounds(0,500,1000,100);

        //adding the buttons to the frame

        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);




        button1.setBounds(400, 160, 200, 40);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setBackground(new Color(0Xffcccb));
        button1.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xc43e00)));
        button1.setFont(new Font("Agency FB",Font.BOLD, 15));

        button2.setBounds(400, 200,200, 40);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setBackground(new Color(0Xffcccb));
        button2.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xc43e00)));
        button2.setFont(new Font("Agency FB",Font.BOLD, 15));

        button3.setBounds(400, 240, 200, 40);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setBackground(new Color(0Xffcccb));
        button3.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xc43e00)));
        button3.setFont(new Font("Agency FB",Font.BOLD, 15));

        button4.setBounds(400, 280, 200, 40);
        button4.setFocusable(false);
        button4.addActionListener(this);
        button4.setBackground(new Color(0Xffcccb));
        button4.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xc43e00)));
        button4.setFont(new Font("Agency FB",Font.BOLD, 15));

        button5.setBounds(400, 320, 200, 40);
        button5.setFocusable(false);
        button5.addActionListener(this);
        button5.setBackground(new Color(0Xffcccb));
        button5.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xc43e00)));
        button5.setFont(new Font("Agency FB",Font.BOLD, 15));

        button7.setBounds(400, 360, 200, 40);
        button7.setFocusable(false);
        button7.addActionListener(this);
        button7.setBackground(new Color(0Xffcccb));
        button7.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xc43e00)));
        button7.setFont(new Font("Agency FB",Font.BOLD, 15));

        button6.setBounds(400, 400, 200, 40);
        button6.setFocusable(false);
        button6.addActionListener(this);
        button6.setBackground(new Color(0Xffcccb));
        button6.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xc43e00)));
        button6.setFont(new Font("Agency FB",Font.BOLD, 15));





    }
    //functioning the buttons according to the relevant methods

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){// Functioning the button for sort the table in ascending order
            AscendingOrder a1 = new AscendingOrder();
            frame.dispose();

        }

        if (e.getSource() == button2){// Functioning the button for sort the table in descending order
            DescendingOrder d1 = new DescendingOrder();

            frame.dispose();
        }

        if (e.getSource() == button3){// Functioning the button for sort the table according to the first position wins
            sortedByWins sortedByWins = new sortedByWins();
            frame.dispose();
        }
        if (e.getSource() == button4) { // Functioning the button for creating a random race
            System.out.println("Race Created");


            Random rand = new Random();

            String randomDate = null;
            for (int i = 0; i < Formula1ChampionshipManager.racersList.size(); i++) {

                //randomizing a int for the position
                int randomPosition = 1 + rand.nextInt(10);
                //creating a random date
                int y1 = 2;
                int y2 = 0;
                int y3 = rand.nextInt(3);
                int y4 = rand.nextInt(9);
                int m1 = rand.nextInt(12);
                int d1 = 1 + rand.nextInt(31);


                String name = Formula1ChampionshipManager.racersList.get(i).getDriversName();
                String team = Formula1ChampionshipManager.racersList.get(i).getDriversTeam();
                String Location = Formula1ChampionshipManager.racersList.get(i).getDriversLocation();
                randomDate = y1 + "" + y2 + "" + y3 + "" + y4 + "." + m1 + "." + d1;


                boolean isTrue = true;

                System.out.println("Racer no: " + (1 + i) + " Racer Name: " + name + " Position:" + randomPosition);


                for (Formula1Driver formula1Driver : Formula1ChampionshipManager.racersList) {
                    //updating the table with the random race

                    if (formula1Driver.getDriversName().equalsIgnoreCase(name) && formula1Driver.getDriversTeam().equalsIgnoreCase(team)) {
                        isTrue = false;


                        formula1Driver.updatePoints(randomPosition);
                        formula1Driver.updateTotalRaces();

                        formula1Driver.positionAdder(randomPosition);
                        Formula1ChampionshipManager.dates.add(randomDate);
                        Collections.sort(Formula1ChampionshipManager.dates);


                    }

                    Formula1ChampionshipManager.sortedByWinsArrayList.sort(Formula1Driver.sortByWins);
                }


            }
            System.out.println("Race Date:" + randomDate);
        }



        if (e.getSource() == button5) {
            System.out.println("Probability Race Created");



            Random rand = new Random();

            for (int i = 0; i < Formula1ChampionshipManager.racersList.size(); i++){

                int randomPosition = 1 + rand.nextInt(10);
                int y4 = 0;
                int y1 = 2;
                int y2 = 0;
                int y3 = 1+ rand.nextInt(1);
                if (y3 == 1){
                     y4 = 1 + rand.nextInt(9);

                }else if(y3 == 2){
                     y4 = rand.nextInt(3);
                }else if(y3 == 0){
                    y4 = 1 + rand.nextInt(9);

                }


                int m1 = 1+ rand.nextInt(11);
                int d1 = 1 + rand.nextInt(31);


                String name = Formula1ChampionshipManager.racersList.get(i).getDriversName();
                String team = Formula1ChampionshipManager.racersList.get(i).getDriversTeam();
                String Location = Formula1ChampionshipManager.racersList.get(i).getDriversLocation();

                String randomDate = y1+ y2+ y3+ y4+"."+m1+"."+d1;


                boolean isTrue = true;

                System.out.println("Racer no: "+ i + " Racer Name: "+name +" Position:"+ randomPosition);
                System.out.println("Race Date:" + randomDate );


                for (Formula1Driver formula1Driver : Formula1ChampionshipManager.racersList) {

                    if (formula1Driver.getDriversName().equalsIgnoreCase(name) && formula1Driver.getDriversTeam().equalsIgnoreCase(team)) {
                        isTrue = false;


                        formula1Driver.updatePoints(randomPosition);
                        formula1Driver.updateTotalRaces();

                        formula1Driver.positionAdder(randomPosition);
                        Formula1ChampionshipManager.dates.add(randomDate);




                    }

                    Formula1ChampionshipManager.sortedByWinsArrayList.sort(Formula1Driver.sortByWins);
                }


            }

        }
        if (e.getSource() == button6){ //Search Bar for viewing the driver details
            String dName = textField.getText();
            if (dName.equalsIgnoreCase(dName)){
                for (Formula1Driver formula1Driver : Formula1ChampionshipManager.racersList) {
                    if (formula1Driver.getDriversName().equalsIgnoreCase(dName)) {
                        label.setText(String.valueOf(formula1Driver));
                    }

                }


            }

        }
        if (e.getSource() == button7){ //displaying all the dates in the gui
            sortDates d1 = new sortDates();
            frame.dispose();

        }




        }









    public static void main(String[] args) {
        MainMenu p1 = new MainMenu();



    }

}
