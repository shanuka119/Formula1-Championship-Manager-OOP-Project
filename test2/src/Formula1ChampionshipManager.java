
import java.io.*;


import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {

    public static ArrayList<Formula1Driver> racersList = new ArrayList<>(); //arrayList that carries all the formula1 driver objects

    //arrayLists for sorting the GUI table
    static ArrayList<Formula1Driver> ascendingOrderArrayList = new ArrayList<>(racersList);
    static ArrayList<Formula1Driver> descendingOrderArrayList = new ArrayList<>(racersList);
    static ArrayList<Formula1Driver> sortedByWinsArrayList = new ArrayList<>(racersList);
    //arrayList for sorting the dates
    static ArrayList<String> dates = new ArrayList<>();






    private static int totalDrivers;
    private static String date;




    public static void sortDrivers() { //method to sort all the tables and view the console table
        //LinkedLists for sorting the the console Table
        LinkedList<Formula1Driver> driversInOrderLinkedList = new LinkedList<>(racersList);
        //LinkedLists for sorting the GUI table
        LinkedList<Formula1Driver>  sortedByWinsLinkedList = new LinkedList<>(racersList);
        LinkedList<Formula1Driver>  sortedByPointsLinkedList = new LinkedList<>(racersList);


        //parsing all the sorted objects to the arrayLists
        sortedByWinsLinkedList.sort(Formula1Driver.sortByWins);
        sortedByWinsArrayList.addAll(sortedByWinsLinkedList);

        sortedByPointsLinkedList.sort(Formula1Driver.sortByPointsAscOrder);
        ascendingOrderArrayList.addAll(sortedByPointsLinkedList);

        sortedByPointsLinkedList.sort(Formula1Driver.sortByPointsDesOrder);
        descendingOrderArrayList.addAll(sortedByPointsLinkedList);


        //sorting the objects in the descending order
        driversInOrderLinkedList.sort(Collections.reverseOrder());


        //viewing the table
        if (driversInOrderLinkedList.size() == 0){
            System.err.println("********************   There are no Drivers Added   ********************");
        }
        else {
            if (!(driversInOrderLinkedList.size() == 1)) {
                for (int i = 0; true; i++) {//sorting the table in case 2 drivers have same points the driver with more wins will appear first
                        if (driversInOrderLinkedList.get(i).getPoints() == driversInOrderLinkedList.get(i + 1).getPoints()) {
                            for (int j = 0; j < driversInOrderLinkedList.size() - i -1; j++){
                                if (driversInOrderLinkedList.get(i).getFirstPositions() < driversInOrderLinkedList.get(i + 1).getFirstPositions()) {
                                    Collections.swap(driversInOrderLinkedList, i, (i + 1));
                                }
                            }




                        break;

                    }





                }

            }


                //Creating the table into a static format


            String leftAlignFormat = "|" + "     " + " %-11s |" + "     " + " %-11s |" + "     " + " %-11s " +
                    "|" + "         " + " %-11s |" + "        " + " %-8s |" + "        " + " %-9s |" + "        " + " %-9s |" + "        " + " %-9d |%n";


            System.out.format("|==================|==================|==================|======================|==================|===================|===================|===================|%n");
            System.out.format("|       Name       |       Team       |     Location     |  Races Participated  |       Points     |  First Positions  |  Second Positions |  Third Positions  |%n");
            System.out.format("|==================|==================|==================|======================|==================|===================|===================|===================|%n");
            for (Formula1Driver driverTable : driversInOrderLinkedList) {
                System.out.format(leftAlignFormat, driverTable.getDriversName(), driverTable.getDriversTeam(),
                        driverTable.getDriversLocation(), driverTable.getRacesParticipated(), driverTable.getPoints(),
                        driverTable.getFirstPositions(), driverTable.getSecondPositions(), driverTable.getThirdPositions());

            }

            //displaying the last updated date
            if (getDate() == null) {
                System.out.println(" ");
            } else {
                System.out.println(" ");
                System.out.println(" ");

                System.out.print("Last Updated: ");
                System.out.print(getDate());
                System.out.println(" ");
                System.out.println(" ");
            }

        }


    }


        //method of adding a new driver
    public static void addDriver() {
        Scanner input = new Scanner(System.in);


        System.out.println("Add Driver's Name");
        String dName = input.next();

        System.out.println("Add Driver's Team");
        String tName = input.next();
        System.out.println("Add Driver's Location");
        String dLocation = input.next();

        int points;
        while (true) {
            Scanner input2 = new Scanner(System.in);

            try {

                System.out.println("Enter existing Points ");
                points = input2.nextInt();
                break;
            } catch (Exception exception) {
                System.err.println("Invalid input. Please add an integer");
            }

        }

        int totRaces;
        while (true) {

            Scanner input2 = new Scanner(System.in);

            try {
                System.out.println("Number of Races Participated");
                totRaces = input2.nextInt();

                break;
            } catch (Exception exception) {
                System.err.println("Invalid input. Please add an integer");
            }

        }


        Formula1Driver f1 = new Formula1Driver(dName, tName, totRaces, points);
        f1.setDriversName(dName);
        f1.setTotalPoints(points);


        f1.setDriversLocation(dLocation);

        racersList.add(f1);
        totalDrivers++;


    }

    //method for viewing individual driver stats
    public static void viewDriverStats() {
        Scanner input = new Scanner(System.in);
        System.out.println("Add Driver's Name");
        String d2Name = input.next();
        for (Formula1Driver formula1Driver : racersList) {
            if (formula1Driver.getDriversName().equalsIgnoreCase(d2Name)) {
                System.out.println(formula1Driver);
            }

        }
    }
    //change the team of the driver
    public static void changeDriverTeam() {
        Scanner input = new Scanner(System.in);
        System.out.println("Add Driver's Name");
        String d3Name = input.next();
        System.out.println("Add the new Team");
        String teamName = input.next();
        for (Formula1Driver formula1Driver : racersList) {
            if (formula1Driver.getDriversName().equalsIgnoreCase(d3Name)) {
                formula1Driver.setDriversTeam(teamName);
            }
        }
    }
    //deleting the driver records
    public static void removeDriver() {
        Scanner input = new Scanner(System.in);
        System.out.println("Add Driver's Name");
        String d4Name = input.next();
        totalDrivers--;

        racersList.removeIf(formula1Driver -> formula1Driver.getDriversName().equalsIgnoreCase(d4Name));
    }


    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        Formula1ChampionshipManager.date = date;
    }
    //method for creating a new  race
    public static void newRace2() {
        System.out.println("Welcome to the Race");
        System.out.println(" ");

        System.out.println("Add Date");
        System.out.println("Date Format: " + "yyyy.mm.dd");
        System.out.println("");



            Scanner myScanner = new Scanner(System.in);

                String date = myScanner.next();








        setDate(date);
        dates.add(date);
        Collections.sort(dates);

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" ");



            System.out.println(" ");
            System.out.println("Press A Add a new Driver");
            System.out.println("Press Q to Exit");
            System.out.print("Enter your Request : ");
            String userInput = sc.nextLine();


            if (userInput.equalsIgnoreCase("a")) {


                newRace();
            } else if (userInput.equalsIgnoreCase("Q")) {
                System.out.println("Thank You for joining the race");
                break;
            } else {
                System.out.println("Invalid input Entered, Please try again");
            }


        }


    }

    //method for adding drivers to the new race
    public static void newRace() {

        Scanner input = new Scanner(System.in);
        System.out.println("Add Driver's Name");
        String dName = input.next();
        System.out.println("Add the Team");
        String teamName = input.next();
        boolean isTrue = true;
        for (Formula1Driver formula1Driver : racersList) {


            if (formula1Driver.getDriversName().equalsIgnoreCase(dName) && formula1Driver.getDriversTeam().equalsIgnoreCase(teamName)) {
                isTrue = false;
                System.out.println("Race Position");
                int newPos = input.nextInt();
                formula1Driver.updatePoints(newPos);
                formula1Driver.updateTotalRaces();
                formula1Driver.positionAdder(newPos);


            }
        }
        if (isTrue) {


            System.out.println("Add Driver's Location");
            String dLocation = input.next();

            System.out.println("Race Position");
            int position = input.nextInt();


            Formula1Driver f1 = new Formula1Driver(dName, teamName, 1, position);
            f1.setDriversName(dName);
            f1.updatePoints(position);
            f1.positionAdder(position);


            f1.setDriversLocation(dLocation);

            racersList.add(f1);
            totalDrivers++;
        }



    }

    //saving data to a serializable file
    public static void Save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("savedChampData.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for(Formula1Driver formula1Driver : racersList)
            objectOutputStream.writeObject(formula1Driver);
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Data Successfully Saved");

    }

    // loading data from the saved file

    public static void Load() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("savedChampData.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        do{
            try {
                Formula1Driver driver = (Formula1Driver) objectInputStream.readObject();
                racersList.add(driver);
            }catch(EOFException | ClassNotFoundException e){
                break;
            }
        }while (true);

            objectInputStream.close();
            fileInputStream.close();
            System.out.println("Data Successfully Loaded");


    }

    //saving data to a text file
    public static void storeDetails() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));


            for (Formula1Driver f1 : racersList) {


                bw.write("\nDriver's Name " + f1.getDriversName());

                bw.write("\nDriver's Team : " + f1.getDriversTeam());
                bw.write("\nTotal Points: " + f1.getPoints());
                bw.write("\nDriver's Location : " + f1.getDriversLocation());
                bw.write("\nRaces Participated: " + f1.getRacesParticipated());
                bw.write("\n");


            }


            bw.close();
            System.out.println("File Created");
        } catch (Exception ignored) {
        }
    }


}

/* References
https://stackoverflow.com/questions/5367916/cant-serialize-an-arraylist
https://stackoverflow.com/questions/17293991/how-to-write-and-read-java-serialized-objects-into-a-file
https://mkyong.com/java/how-to-read-and-write-java-object-to-a-file/
https://www.geeksforgeeks.org/serialization-in-java/
https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
https://www.baeldung.com/java-comparator-comparable
https://www.javatpoint.com/java-swing



 */











        












        /*for (int i = 0; i < racersList.size(); i++){
            if (racersList.get(i).getDriversName().equalsIgnoreCase(dName)){


                System.out.println("Race Position");
                System.out.println(racersList.get(i).getDriversName());

                int newPos = input.nextInt();

                for (Formula1Driver formula1Driver : racersList) {

                    formula1Driver.updatePoints(newPos);
                    formula1Driver.updateTotalRaces();

                }


            }else {
                isOrdered = false;
                break;





            }

        }
        if (isOrdered){
            System.out.println("Add Driver's Location");
            String dLocation = input.next();

            System.out.println("Race Position");
            int pos = input.nextInt();

            System.out.println("Number of Races Participated");
            int totRaces = input.nextInt();

            Formula1Driver f1 = new Formula1Driver(dName, teamName, totRaces, pos);
            f1.setDriversName(dName);


            f1.setDriversLocation(dLocation);

            racersList.add(f1);
        }*/


















