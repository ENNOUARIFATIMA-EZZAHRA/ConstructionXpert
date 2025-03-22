package Controlleur;

import Dao.TacheDao;
import Model.TacheModel;
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

@WebServlet({"/TacheServlet", "/CreateTache","/UpdateTache","/ListTaches","/updateTache","/insert"})
public class TacheServlet extends HttpServlet {
    public TacheDao TacheDao ;
    @Override
    public void init() throws ServletException {
        TacheDao= new TacheDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/insert":
                    createTache(request, response);
                    break;
                case "/updateTache":
                    updateTache(request, response);
                    break;
                case "/delete":
                    //deleteTache(request, response);
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
                case "/CreateTache":
                    showNewForm(request, response);
                    break;
                case "/updateTache":
                    showEditForm(request, response);
                    break;
                default:
                    listTaches(request, response);
                    break;

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("CreateTache.jsp");
        dispatcher.forward(request, response);
    }


    public void createTache(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        Date date_debut = Date.valueOf(request.getParameter("date_debut"));
        Date date_fin = Date.valueOf(request.getParameter("date_fin"));
        double budget = Double.parseDouble(request.getParameter("budget"));
        TacheModel Tache = new TacheModel();
        Tache.setNom(nom);
        Tache.setDescription(description);
        Tache.setDate_debut(Date.valueOf(date_debut.toLocalDate()));
        Tache.setDate_fin(Date.valueOf(date_fin.toLocalDate()));
        Tache.setBudget((float) budget);
        TacheDao.createTache(Tache);
        response.sendRedirect("ListTaches");
    }

    //affichage
    public void listTaches(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<TacheModel> Taches = TacheDao.getAllTaches();
        request.setAttribute("Taches", Taches);
        request.getRequestDispatcher("/ListTaches.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TacheModel Tache = new TacheModel();
        TacheModel existingTache =TacheDao.getTacheById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Update.jsp");
        request.setAttribute("Tache", existingTache);
        dispatcher.forward(request, response);

    }

    // Modifier une tache
    public void updateTache(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        Date date_debut = Date.valueOf(request.getParameter("date_debut"));
        Date date_fin = Date.valueOf(request.getParameter("date_fin"));
        float budget = (float) Double.parseDouble(request.getParameter("budget"));

        TacheModel Tache = new TacheModel(id,nom,description,date_debut,date_fin, (float) budget);
        TacheDao.updateTache(Tache);
        response.sendRedirect("ListTaches");
        System.out.println("Update Tache: " + id + " | " + nom);

    }
}


