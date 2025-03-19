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
import java.util.List;

@WebServlet("/ProjetServlet")
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

      request.getRequestDispatcher("/WEB-INF/CreateProjet.jsp").forward(request, response);

    }

    public void createProjet(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        Date date_debut = Date.valueOf(request.getParameter("date_debut"));
        Date date_fin = Date.valueOf(request.getParameter("date_fin"));
        double budget = Double.parseDouble(request.getParameter("budget"));

        ProjetModel project = new ProjetModel();

        project.setNom(nom);
        project.setDescription(description);
        project.setDate_debut(Date.valueOf(date_debut.toLocalDate()));
        project.setDate_fin(Date.valueOf(date_fin.toLocalDate()));
        project.setBudget((float) budget);

        ProjetDao.createProjet(project);
        response.sendRedirect("/WEB-INF/ListProjets.jsp");
    }
}