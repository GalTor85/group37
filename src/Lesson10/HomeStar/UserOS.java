package Lesson10.HomeStar;

public class UserOS implements Cloneable{
    private String operatingSystemName;


    public UserOS(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return operatingSystemName ;
    }


    public void setOperatingSystemName(String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }



}
