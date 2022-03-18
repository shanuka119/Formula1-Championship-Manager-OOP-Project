import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        do {//Displaying the menu

            System.out.println(" ");
            System.out.println("        Welcome to the Formula 1 Championship ");
            System.out.println("                     Menu                  ");
            System.out.println("Choose from the following numbers/letters: ");
            System.out.println(" ");
            System.out.println("1: Create a new driver");
            System.out.println("2: Delete a Driver");
            System.out.println("3: Change the drivers team");
            System.out.println("4: Display the drivers stats");
            System.out.println("5: Display the Formula 1 Driver Table");
            System.out.println("6: New Race");
            System.out.println("7: Save to a File");
            System.out.println("8: Load data from File");
            System.out.println("9: Open GUI");

            System.out.println(" ");

            Scanner input = new Scanner(System.in);
            String press = input.next();


            switch (press) {
                case "1":
                    Formula1ChampionshipManager.addDriver();
                    break;

                case "2":
                    Formula1ChampionshipManager.removeDriver();
                    break;

                case "3":
                    Formula1ChampionshipManager.changeDriverTeam();
                    break;

                case "4":
                    Formula1ChampionshipManager.viewDriverStats();

                    break;


                case "5":
                    Formula1ChampionshipManager.sortDrivers();
                    break;

                case "6":
                    Formula1ChampionshipManager.newRace2();
                    break;
                case "7":
                    Formula1ChampionshipManager.storeDetails();
                    try {
                        Formula1ChampionshipManager.Save();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "8":
                    try {
                        Formula1ChampionshipManager.Load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case  "9":
                    MainMenu p1 = new MainMenu();


            }
        } while (true);


    }
}






    /*for (int i = 0; i < racersList.size(); i++){
        if (i == 1){
            System.out.println(racersList.get(i).getPoints());
        }
    }*/

                                                                                              /*  for (Formula1Driver formula1Driver : racersList) {
                                                                                                    System.out.println(formula1Driver);
                                                                                                    System.out.println("               Total Points: " + formula1Driver.getPoints());

                                                                                                    System.out.println(" ");
                                                                                                }
                                                                                                */

