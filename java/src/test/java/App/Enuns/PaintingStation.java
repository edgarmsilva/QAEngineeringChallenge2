package App.Enuns;

public enum PaintingStation {

    NAME("PaintingStation"),
    FLOWRATE("Flow Rate"),
    PRESSURE("Pressure"),
    COLORCONSISTENCY("Color Consistency"),
    NOZZLECONDITION("Nozzle Condition");

    private final String partName;

    PaintingStation(String partName) {
        this.partName = partName;
    }

    public String get() {
        return this.partName;
    }
}
