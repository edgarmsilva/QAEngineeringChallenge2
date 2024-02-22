package App.Enuns;

public enum QualityControlStation {

    NAME("Quality Control Station"),
    CAMERACALIBRATION("Camera Calibration"),
    LIGHTINTENSITY("Light Intensity"),
    SOFTWAREVERSION("Software Version"),
    CRITERIASETTINGS("Criteria Settings");

    private final String partName;

    QualityControlStation(String partName) {
        this.partName = partName;
    }

    public String get() {
        return this.partName;
    }
}
