package servlets;

import classes.Treatment;
import classes.Patient;
import classes.Doctor;
import classes.Clinic;
import classes.TreatmentType;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Action
 */
@WebServlet("/Action")
public class Action extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String ADD_PATIENT = "addPatient";
    private static final String DELETE_PATIENT = "deletePatient";
    private static final String ADD_TREATMENT = "addTreatment";
    private static final String SET_TREATMENT = "setTreatment";
    private static final String TREATMENTSREPORT = "treatmentsReport";
    private static final String SHOW_PATIENTS = "showPatients";

    Clinic clinic = Clinic.getInstance();

    Patient patient;
    Doctor doctor;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Action() {
        super();
        // TODO Auto-generated constructor stub
        //doctor = (Doctor) clinic.getUser("a", "a");

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
        } catch (Exception e) {
            e.getMessage();
        }

        //שליפת סוג הפעולה שנלחצה מה- URL
        String action = request.getParameter("action");
        //שליפת המשתמש הנוכחי מהcontext
        doctor = (Doctor) request.getServletContext().getAttribute("doctor");
        patient = (Patient) request.getServletContext().getAttribute("patient");
        String feedback = "";
        //נשלח לפעולה המתאימה לפי סוג הפעולה
        switch (action) {
            case ADD_PATIENT:
                addNewPatient(request, response);
                feedback = "The patient be added successfully";
                break;
            case DELETE_PATIENT:
                deletePatient(request, response);
                feedback = "The patient be erased successfully";
                break;
            case ADD_TREATMENT:
                addTreatment(request, response);
                feedback = "The treatment be added successfully";
                break;
            case SET_TREATMENT:
                setTreatment(request, response);
                feedback = "The treatment be updated successfully";
                break;
            case TREATMENTSREPORT:
                treatmentsReport(request, response);
                break;
            case SHOW_PATIENTS:
                showPatients();
                feedback = "The report was successfully generated";
                break;
        }

        response.getWriter().write(feedback);
        if (patient != null) {
            request.getServletContext().getRequestDispatcher("/WelcomeUser.jsp").include(request, response);
        } else {
            request.getServletContext().getRequestDispatcher("/WelcomeDoctor.jsp").include(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void addNewPatient(HttpServletRequest request, HttpServletResponse response) {
        String PatientName = request.getParameter("addName");
        String PatientPassword = request.getParameter("addPassword");
        doctor.addPatient((Patient) clinic.addUser(PatientName, PatientPassword, 1));
        System.out.println("addNewPatient: name: " + PatientName + " password: " + PatientPassword);
        System.out.println("Patient successfully added");
    }

    public void deletePatient(HttpServletRequest request, HttpServletResponse response) {
        int PatientId = Integer.parseInt(request.getParameter("deleteId"));
        doctor.deletePatient(PatientId);
        System.out.println("deletePatient: ID: " + PatientId);
        System.out.println("Patient deleted successfully");
    }

    public void addTreatment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Date addDate = new Date(request.getParameter("addDate"));
        int addToothNumber = Integer.parseInt(request.getParameter("addToothNumber"));
        TreatmentType addTreatmentType = TreatmentType.valueOf(request.getParameter("addTreatmentType"));
        double addPrice = Double.parseDouble(request.getParameter("addPrice"));
        boolean addPaid;
        String s = request.getParameter("addPaid");
        if ("on".equals(s)) {
            addPaid = true;
        } else {
            addPaid = false;
        }
        if (patient != null) {
            try {
                patient.addTreatment(new Treatment(addDate, addTreatmentType, addToothNumber, addPrice, addPaid));
            } catch (Exception ex) {
                Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
                response.getWriter().write(ex.getMessage());
            }

        }

        System.out.println("addTreatmentTo: name: " + patient.getName() + " Treament: in: " + addDate + " Type: " + addTreatmentType + " Price: " + addPrice);
        System.out.println("Treatment successfully added");
    }

    private void setTreatment(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Date setDate = new Date(request.getParameter("setDate"));
        int setToothNumber = Integer.parseInt(request.getParameter("setToothNumber"));
        TreatmentType setTreatmentType = TreatmentType.valueOf(request.getParameter("setTreatmentType"));
        double setPrice = Double.parseDouble(request.getParameter("setPrice"));
        boolean setPaid;
        String s = request.getParameter("setPaid");
        if ("on".equals(s)) {
            setPaid = true;
        } else {
            setPaid = false;
        }
        patient.setTreatment(id, new Treatment(setDate, setTreatmentType, setToothNumber, setPrice, setPaid));
        System.out.println("updatedTreatmentTo: name: " + patient.getName() + " Treament: in: " + setDate + " Type: " + setTreatmentType + " Price: " + setPrice);
        System.out.println("Treatment successfully updated");
    }

    private void treatmentsReport(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/ShowData.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showPatients() {
        doctor.showPatients();
    }

}
