import java.io.Serializable;

abstract class Driver implements Serializable {
    private String driversName;
    private String driversLocation;

    public Driver(String driversName) {
    }


    public String getDriversName() {
        return driversName;
    }

    public void setDriversName(String driversName) {
        this.driversName = driversName;
    }

    public String getDriversLocation() {
        return driversLocation;
    }

    public void setDriversLocation(String driversLocation) {
        this.driversLocation = driversLocation;
    }


}
