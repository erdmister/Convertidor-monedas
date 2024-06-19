import java.util.ArrayList;
import java.util.List;

public class HistorialDeConversion {
    private final List<String> conversionHistory = new ArrayList<>();

    public void addEntry(String entry) {
        conversionHistory.add(entry);
    }

    public void verHistorial() {
        System.out.println("----- HISTORIAL DE CONVERSIONES -----");
        if (conversionHistory.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            for (String entry : conversionHistory) {
                System.out.println(entry);
            }
        }
        System.out.println("--------------------------------------");
    }
}
