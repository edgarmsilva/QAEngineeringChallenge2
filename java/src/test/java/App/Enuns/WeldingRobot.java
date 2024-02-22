package App.Enuns;

public enum WeldingRobot {

    NAME("Welding Robot"),
    ERRORRATE("Error Rate"),
    VIBRATIONLEVEL("Vibration Level"),
    ELECTRODEWEAR("Electrode Wear"),
    SHIELDINGPRESSURE("Shielding Pressure"),
    WIREFEEDRATE("Wire Feed Rate"),
    ARCSTABILITY("Arc Stability"),
    SEAMWIDTH("Seam Width"),
    COOLINGEFFICIENCY("Cooling Efficiency");

    private final String partName;

    WeldingRobot(String partName) {
        this.partName = partName;
    }

    public String get() {
        return this.partName;
    }
}
