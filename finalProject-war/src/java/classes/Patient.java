package classes;

import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Patient extends User {

    private List<Treatment> treatments = new LinkedList<Treatment>();

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public Patient() {
        super();
    }

    public Patient(String name, String password, int permission) {
        super(name, password, permission);
    }

    public void addTreatment(Treatment treatment) throws NotPaidException {
        int count = 0;
        for (Treatment t : treatments) {
            if (!t.isPaid()) {
                count++;
            }
            if (count == 2) {
                throw new NotPaidException();
            }
        }

        treatments.add(treatment);
    }

    public void setTreatment(int id, Treatment treatment) {
        for (Treatment t : treatments) {
            if (t.getId() == id) {
                t.setDate(treatment.getDate());
                t.setPaid(treatment.isPaid());
                t.setPrice(treatment.getPrice());
                t.setToothNumber(treatment.getToothNumber());
                t.setTreatmentType(treatment.getTreatmentType());
            }
        }
    }

}
