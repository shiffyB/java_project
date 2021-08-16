package classes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Doctor extends User {

    private List<Patient> patients = new LinkedList<Patient>();

    public Doctor() {
        super();
    }

    public Doctor(String name, String password, int permission) {
        super(name, password, permission);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void deletePatient(int id) {
        patients.removeIf(p -> p.getId() == id);
    }

    public Patient getPatient(int id) {
        for (Patient p : patients) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public void showPatients() {
        PrintWriter fw;
        try {
            fw = new PrintWriter(new FileOutputStream("C:\\Users\\76599\\Documents\\Patients.txt", true));
            for (Patient p : patients) {
                fw.write("Name: " + p.getName() +" ID: "+p.getId()+ " password: " + p.getPassword()+"\n");
            }
            fw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
