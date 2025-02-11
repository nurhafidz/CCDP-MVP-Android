package ac.id.unikom.challenge;

public class MainPresenter {
    private MainView view;
    private Meter model;

    public MainPresenter(MainView view, Meter model) {
        this.view = view;
        this.model = model;
    }

    public void calculateLength(String meterInput) {
        if (meterInput.isEmpty()) {
            meterInput = "0";
        }

        double parsedMeter = Double.parseDouble(meterInput);
        model.setMeter(parsedMeter);

        String kilometerValue = model.toKilometer();
        String centimeterValue = model.toCentimeter();

        view.showKilometer(kilometerValue);
        view.showCentimeter(centimeterValue);
    }
}
