/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
*/

/*
Récupère les informations des spectacles pour utiliser les filtres
 */
package m2cci.pi01.cybertheatre.ctrlers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatre.DAO.ProgrammationDAO;
import m2cci.pi01.cybertheatremodel.Spectacle;


@WebServlet(name = "ProgrammationCtrl", urlPatterns = {"/ProgrammationCtrl"})
public class ProgrammationCtrl extends HttpServlet {

    @Resource(name = "jdbc/CyberTheatre")
    private DataSource bdSQL;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int prixMax;
        prixMax = 250;
        String typeSelectionne[] = request.getParameterValues("checkTypeSpectacle");
        String publicSelectionne[] = request.getParameterValues("checkPublicCible");
        String titre = request.getParameter("titreSpectacle");
        String premierJour = request.getParameter("premierJour");
        String dernierJour = request.getParameter("dernierJour");
        String prixMaxSelectionne = request.getParameter("prixChoisi");
        String plageHoraireString = request.getParameter("plageHoraire");
        String[] plageHoraireTableau = plageHoraireString.split(",");
        String trierPar = request.getParameter("buttonTri");
        if (titre.equals("")) {
            titre = null;
        } //pour éviter le conflit de titre null au début et chaine vide après le rechargement de la page
        if (prixMaxSelectionne != null) {
            prixMax = Integer.parseInt(prixMaxSelectionne);
        }

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH");
        LocalDate datePremierJour, dateDernierJour;
        if (premierJour == null || premierJour.equals("")) {
            datePremierJour = null;
        } else {
            datePremierJour = LocalDate.parse(premierJour, formatDate);
        }
        if (dernierJour == null || dernierJour.equals("")) {
            dateDernierJour = null;
        } else {
            dateDernierJour = LocalDate.parse(dernierJour, formatDate);
        }
        LocalTime heureDebut = LocalTime.parse(plageHoraireTableau[0], formatTime);
        LocalTime heureFin = LocalTime.parse(plageHoraireTableau[1], formatTime);
        List<Spectacle> programmation;
        try {
            programmation = ProgrammationDAO.getProgrammation(bdSQL, typeSelectionne, publicSelectionne, titre, prixMax, datePremierJour, dateDernierJour, heureDebut, heureFin,trierPar);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new ServletException(ex.getMessage(), ex);
        }
        request.setAttribute("programmation", programmation);
//        request.setAttribute("typeSpectacle", typeSelectionne);
//        request.setAttribute("publicCible", publicSelectionne);
//        request.setAttribute("titreSpectacle", titre);
//        request.setAttribute("prixDeBase", prixMax);
//        request.setAttribute("dateDebut", premierJour);
//        request.setAttribute("dateFin", dernierJour);
//        request.setAttribute("heureDebut", heureDebut);
//        request.setAttribute("heureFin", heureFin);
        request.getRequestDispatcher("/WEB-INF/programmation.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
