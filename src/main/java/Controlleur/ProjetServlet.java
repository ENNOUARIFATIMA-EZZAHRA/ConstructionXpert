package Controlleur;

import Dao.ProjetDao;
import Model.ProjetModel;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet({"/ProjetServlet", "/CreateProjet","/UpdateProjet","/ListProjets","/updateProjet","/insertProjet"})
public class ProjetServlet extends HttpServlet {
        public  ProjetDao projectDao ;
    @Override
    public void init() throws ServletException {
       projectDao= new ProjetDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/insertProjet":
                    createProjet(request, response);
                    break;
                case "/updateProjet":
                    updateProjet(request, response);
                    break;
                case "/delete":
                    //deleteProjet(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();
        try {
            switch (action) {
                case "/CreateProjet":
                    showNewForm(request, response);
                    break;
                case "/updateProjet":
                    showEditForm(request, response);
                    break;
                default:
                    listProjets(request, response);
                    break;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CreateProjet.jsp");
        dispatcher.forward(request, response);
    }


    public void createProjet(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        Date date_debut = Date.valueOf(request.getParameter("date_debut"));
        Date date_fin = Date.valueOf(request.getParameter("date_fin"));
        double budget = Double.parseDouble(request.getParameter("budget"));
        ProjetModel projet = new ProjetModel();
        projet.setNom(nom);
        projet.setDescription(description);
        projet.setDate_debut(Date.valueOf(date_debut.toLocalDate()));
        projet.setDate_fin(Date.valueOf(date_fin.toLocalDate()));
        projet.setBudget((float) budget);
        ProjetDao.createProjet(projet);
        response.sendRedirect("ListProjets");
    }

//affichage
    public void listProjets(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ProjetModel> projets = ProjetDao.getAllProjets();
        request.setAttribute("projets", projets);
        request.getRequestDispatcher("/ListProjets.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProjetModel projet = new ProjetModel();
        ProjetModel existingProjet =projectDao.getProjetById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Update.jsp");
        request.setAttribute("projet", existingProjet);
        dispatcher.forward(request, response);

    }

    // Modifier une projet
    public void updateProjet(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        Date date_debut = Date.valueOf(request.getParameter("date_debut"));
        Date date_fin = Date.valueOf(request.getParameter("date_fin"));
        float budget = (float) Double.parseDouble(request.getParameter("budget"));

        ProjetModel projet = new ProjetModel(id,nom,description,date_debut,date_fin, (float) budget);
//        projet.setId(id);
//        projet.setNom(nom);
//        projet.setDescription(description);
//        projet.setDate_debut(Date.valueOf(date_debut.toLocalDate()));
//        projet.setDate_fin(Date.valueOf(date_fin.toLocalDate()));
//        projet.setBudget((float) budget);
        ProjetDao.updateProjet(projet);
        response.sendRedirect("ListProjets");
        System.out.println("Update projet: " + id + " | " + nom);

    }
}


