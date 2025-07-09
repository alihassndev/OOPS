package student;

interface ControllableDevice {
    void turnOn();
    void turnOff();
    String getStatus();
}

class SmartLight implements ControllableDevice {
    private String name;
    private boolean isOn;

    SmartLight(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " turned OFF");
    }

    public String getStatus() {
        return "Status: " + name + " is " + (isOn ? "ON" : "OFF");
    }
}

class SmartFan implements ControllableDevice {
    private String name;
    private boolean isOn;

    SmartFan(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " turned OFF");
    }

    public String getStatus() {
        return "Status: " + name + " is " + (isOn ? "ON" : "OFF");
    }
}

class SmartDoorLock implements ControllableDevice {
    private String name;
    private boolean isOn;

    SmartDoorLock(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " turned ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " turned OFF");
    }

    public String getStatus() {
        return "Status: " + name + " is " + (isOn ? "ON" : "OFF");
    }
}

public class LabTask4 {
    public static void main(String[] args) {
        ControllableDevice[] devices = {
                new SmartLight("Smart Light"),
                new SmartFan("Smart Fan"),
                new SmartDoorLock("Smart Door Lock")
        };

        // Turn on all devices
        for (ControllableDevice d : devices) {
            d.turnOn();
        }
        System.out.println("\n===================================\n");
        // Get status of all devices
        for (ControllableDevice d : devices) {
            System.out.println(d.getStatus());
        }
        System.out.println("\n===================================\n");
        // Turn off all devices
        for (ControllableDevice d : devices) {
            d.turnOff();
        }
    }
}