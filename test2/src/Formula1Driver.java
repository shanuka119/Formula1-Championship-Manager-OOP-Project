import java.util.ArrayList;
import java.util.Comparator;

public class Formula1Driver extends Driver implements Comparable<Formula1Driver> {
    private String driversTeam;
    private int firstPositions; //number of first positions
    private int secondPositions; //number of second positions
    private int thirdPositions; //number of third positions
    private int points; //number of points the driver  currently has
    private int racesParticipated; //number of races participated
    private int totalPoints;


    public int getFirstPositions() {
        return firstPositions;
    }//getting the number of first positions

    public int getSecondPositions() {
        return secondPositions;
    }//getting the number of second positions

    public int getThirdPositions() {
        return thirdPositions;
    }//getting the number of third positions

    public int getRacesParticipated() {//getting the number of races participated
        return racesParticipated;
    }

    public String toString() {  // converting formula 1 driver object in to strings
        return "" +
                "Drivers Name : " + getDriversName() +" "+ '\n' +

                "Drivers Team : " + driversTeam +" "+ '\n' +
                "Drivers Location =" + getDriversLocation() +" "+ '\n' +
                "Total Points : " + getTotalPoints() +" "+'\n' +
                "Races Participated : " + racesParticipated +" "+'\n' +
                "Total FirstPositions : " + firstPositions +" "+'\n' +
                "Total SecondPositions : " + secondPositions +" "+'\n' +
                "Total ThirdPositions : " + thirdPositions + "\n";
    }
    //setting the number of first/second/third positions
    public void setFirstPositions(int firstPositions) {
        this.firstPositions = firstPositions;
    }

    public void setSecondPositions(int secondPositions) {
        this.secondPositions = secondPositions;
    }

    public void setThirdPositions(int thirdPositions) {
        this.thirdPositions = thirdPositions;
    }

    public void setRacesParticipated(int racesParticipated) {
        this.racesParticipated = racesParticipated;
    }

    //getting drivers team
    public String getDriversTeam() {
        return driversTeam;
    }

    // creating the constructor with arguments
    public Formula1Driver(String driversName, String driversTeam, int racesParticipated, int currentPoints) {
        super(driversName);

        this.driversTeam = driversTeam;
        this.firstPositions = 0;
        this.secondPositions = 0;
        this.thirdPositions = 0;
        this.points = currentPoints;


        this.racesParticipated = racesParticipated;
    }

        //getting the race position and updating the number of first/Second/Third Positions in the tables
    public void positionAdder(int position) {
        if (position == 1) {

            firstPositions++;
            setFirstPositions(firstPositions);


        } else if (position == 2) {

            secondPositions++;
            setSecondPositions(secondPositions);
        } else if (position == 3) {

            thirdPositions++;
            setThirdPositions(thirdPositions);


        }

    }
    //getting the race position and updating the total points of the racer
    public void updatePoints(int position) {
        if (position == 1) {
            totalPoints = totalPoints + 25;


        } else if (position == 2) {

            totalPoints = totalPoints + 18;
        } else if (position == 3) {

            totalPoints = totalPoints + 15;
        } else if (position == 4) {
            totalPoints = totalPoints + 12;

        } else if (position == 5) {
            totalPoints = totalPoints + 10;

        } else if (position == 6) {
            totalPoints = totalPoints + 8;

        } else if (position == 7) {
            totalPoints = totalPoints + 6;

        } else if (position == 8) {
            totalPoints = totalPoints + 4;

        } else if (position == 9) {
            totalPoints = totalPoints + 2;

        } else if (position == 10) {
            totalPoints = totalPoints + 1;


        }
    }

    //updating the total races participated
    public void updateTotalRaces() {
        racesParticipated++;
    }

    //getting total points
    public int getPoints() {
        return totalPoints;
    }

    public void setDriversTeam(String driversTeam) {
        this.driversTeam = driversTeam;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    //comparator for comparing the table according to the points achieved so far
    @Override
    public int compareTo(Formula1Driver formula1Driver) {
        return Integer.compare(this.getPoints(), formula1Driver.getPoints());
    }
    //comparator for sorting the method according to the total first positions
    public static Comparator<Formula1Driver> sortByWins = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2) {
            int wins1 = d1.getFirstPositions();
            int wins2 = d2.getFirstPositions();

            return wins2-wins1;
        }
    };
    //comparator for sorting the method according to the ascending order of the points
    public static Comparator<Formula1Driver> sortByPointsAscOrder = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2) {
            int wins1 = d1.getTotalPoints();
            int wins2 = d2.getTotalPoints();

            return wins1-wins2;
        };


};

    //comparator for sorting the method according to the descending order of the points
    public static Comparator<Formula1Driver> sortByPointsDesOrder = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver d1, Formula1Driver d2) {
            int wins1 = d1.getTotalPoints();
            int wins2 = d2.getTotalPoints();

            return wins2-wins1;
        };


    };
}
