import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DescendingOrder implements ActionListener {
    //Creating the new GUI frame with descending order table


    static JPanel jPanel;
    static String[] col;
    JButton button1 = new JButton("Back");
    JFrame frame = new JFrame();


    DescendingOrder(){
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.setBackground(new Color(0Xffcccb));
        frame.setTitle("Descending Order Table");



        button1.setBackground(new Color(0Xee98fb));
        button1.setBorder(BorderFactory.createMatteBorder(1, 5, 2, 1, new Color(0Xc43e00)));

        button1.setSize(100,100);
        button1.setFont(new Font("Agency FB",Font.BOLD, 15));

        button1.setFocusable(false);

        JLabel label  = new JLabel("to Main Menu");


        frame.setSize(1000,500);
        frame.setLayout(null);
        frame.setVisible(true);


        frame.setLayout(new BorderLayout());
        frame.add(jPanel, BorderLayout.SOUTH);
        jPanel.add(button1);
        jPanel.add(label);


        button1.setFocusable(false);
        button1.addActionListener(this);
        //creating the table


        col = new String[]{"Name", "Team", "Location", "Races Participated ", "Points", "First Positions", "Second Positions", "Third Positions"};

        DefaultTableModel table = new DefaultTableModel(col, 0);
        JTable jTable = new JTable(table);
        for (Formula1Driver formula1Driver: Formula1ChampionshipManager.descendingOrderArrayList){
            Object[] rows = {formula1Driver.getDriversName(), formula1Driver.getDriversTeam(),formula1Driver.getDriversLocation() , formula1Driver.getRacesParticipated(),
                    formula1Driver.getPoints(), formula1Driver.getFirstPositions(), formula1Driver.getSecondPositions(), formula1Driver.getThirdPositions()};
            table.addRow(rows);

        }
        jTable.setFont(new Font("Arial",Font.PLAIN, 16));
        JTableHeader jTableHeader = jTable.getTableHeader();
        JScrollPane scrollPane = new JScrollPane(jTable);
        frame.add(scrollPane);
        frame.setVisible(true);









    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            MainMenu launchPage = new MainMenu();
            frame.dispose();

        }
    }
}
