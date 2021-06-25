/*
 * Copyright (C) 2017 Philippe GENOUD - Université Grenoble Alpes - Lab LIG-Steamer
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package m2cci.pi01.cybertheatre.ctrlers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatre.DAO.ProgrammationDAO;
import m2cci.pi01.cybertheatremodel.Representation;

/**
 * Fourni la liste des spectacles enregistrés dans la BD et redirige sur la vue
 * /WEB-INF/spectacles.jsp.
 *
 * L'url associée à cette servlet est "/listespectacles".
 *
 * C'est la page d'accueil du site (voir l'élément <welcome-file> dans le
 * fichier de déploiement de l'application défini dans WEB-INF/web.xml.
 *
 * <welcome-file-list>
 * <welcome-file>listespectacles</welcome-file>
 * </welcome-file-list>
 *
 * La servlet construit une liste de Spectacles placée en attribut de la requête
 * transmise à la vue. Les nom de cette liste est "spectacles"
 *
 * @author Emilie Sirot, Philémon Giraud
 */
@WebServlet(name = "ChoixPlacesCtrl", urlPatterns = {"/ChoixPlacesCtrl"})
public class ChoixPlacesCtrl extends HttpServlet {

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

//        String nomSpectacle = request.getParameter("spectacle");
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatHeure = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate date = LocalDate.parse(request.getParameter("date"), formatDate);
        LocalTime heure = LocalTime.parse(request.getParameter("heure"), formatHeure);

        try {
            Representation representation = ProgrammationDAO.getRepresentation(bdSQL, date, heure);
            
            // stocke la représentation en session pour qu'il puisse être utilisé lors des prochaines requêtes
            HttpSession session = request.getSession();
            session.setAttribute("representation", representation);
            
            request.setAttribute("representation", representation);
            request.getRequestDispatcher("/WEB-INF/choixPlaces.jsp").forward(request, response);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new ServletException(ex.getMessage(), ex);
        }
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
