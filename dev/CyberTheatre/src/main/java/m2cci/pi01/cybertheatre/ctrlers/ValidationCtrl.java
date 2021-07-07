
/*
 Affiche le récapitulatif de la commande avant de procéder à la pré-réservation ou au paiement direct
Author     : M2CCI 2021 projet d'intégration groupe 01
 */
package m2cci.pi01.cybertheatre.ctrlers;

import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatremodel.Representation;
import m2cci.pi01.cybertheatremodel.Sieges.Categorie;
import m2cci.pi01.cybertheatremodel.Sieges.Siege;
import m2cci.pi01.cybertheatremodel.Sieges.Zone;


@WebServlet(name = "ValidationCtrl", urlPatterns = {"/ValidationCtrl"})
public class ValidationCtrl extends HttpServlet {

    @Resource(name = "jdbc/MyTheatre")
    DataSource bdSQL;

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

        HttpSession session = request.getSession();
        Representation representation = (Representation) session.getAttribute("representation");
//        String tarifEtudiant = request.getParameter("tarifEtudiant");;

        String[] stringSieges = request.getParameterValues("siege");
        ArrayList<Siege> siegesSelectionnes = new ArrayList<>();
        ArrayList<Zone> listeZones = new ArrayList<>();

        for (String jsonID : stringSieges) {
            // NumeroZone pas importable
//            int numeroZone = Siege.numeroZoneFromJsonId(jsonID);
//            Zone zone = new Zone(numeroZone, Siege.categorieFromJsonId(jsonID));
            Zone zone = new Zone(0, Siege.categorieFromJsonId(jsonID));
            int rangSiege = Siege.rangSiegeFromJsonId(jsonID);
            int numeroSiege = Siege.numeroSiegeFromJsonId(jsonID);
            Siege siege = new Siege(numeroSiege, rangSiege, zone);

            siegesSelectionnes.add(siege);
        }

        //Conserve les sieges selectionnés pour réutilisation après validation
        session.setAttribute("siegesSelectionnes", siegesSelectionnes);

        request.setAttribute("representation", representation);
        request.setAttribute("siegesSelectionnes", siegesSelectionnes);
//        request.setAttribute("tarifEtudiant", tarifEtudiant);
        request.getRequestDispatcher("/WEB-INF/validation.jsp").forward(request, response);
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
