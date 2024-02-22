package App.Enuns;

public enum AssemblyLine {

    NAME("Assembly Line"),
    ALIGNMENTACCURACY("Alignment Accuracy"),
    SPEED("Speed"),
    FITTINGTOLERANCE("Fitting Tolerance"),
    BELTSPEED("Belt Speed");

    private final String partName;

    AssemblyLine(String partName) {
        this.partName = partName;
    }

    public String get() {
        return this.partName;
    }
}
