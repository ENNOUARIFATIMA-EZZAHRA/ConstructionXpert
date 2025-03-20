package Controlleur;

import Dao.ProjetDao;
import Model.ProjetModel;
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

@WebServlet({"/ProjetServlet", "/CreateProjet","/ListProjets","/updateProjet"})
public class ProjetServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ProjetDao projectDao;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            createProjet(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    request.getRequestDispatcher("CreateProjet.jsp").forward(request, response);


        listProjets(request, response);


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
        response.sendRedirect("ListProjets.jsp");
    }

//affichage


    public void listProjets(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<ProjetModel> projets = ProjetDao.getAllProjets();
        request.setAttribute("projets", projets);
        request.getRequestDispatcher("/ListProjets.jsp").forward(request, response);
    }

    // Modifier une projet
    private void updateProjet(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        Date date_debut = Date.valueOf(request.getParameter("date_debut"));
        Date date_fin = Date.valueOf(request.getParameter("date_fin"));
        float budget = Float.parseFloat(request.getParameter("budget"));

        ProjetModel projet = new ProjetModel(id, nom, description, date_debut, date_fin, budget);

        boolean success = ProjetDao.updateProjet(projet);

        if (success) {
            response.sendRedirect("update.jsp?success=update");
        } else {
            response.sendRedirect("delete.jsp?error=update");
        }
    }

}