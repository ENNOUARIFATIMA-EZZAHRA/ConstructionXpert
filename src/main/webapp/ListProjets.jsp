<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.ProjetModel" %>
<%@ page import="Controlleur.ProjetServlet" %>

<%
    // Empêcher la mise en cache du navigateur
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Projet</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body class="bg-white text-gray-800">
<nav class="flex items-center justify-between p-4 shadow-md">
    <div class="text-2xl font-bold">ConstructionXpert</div>
    <ul class="hidden space-x-4 md:flex">
        <li><a href="home.jsp" class="hover:text-pink-600">Home</a></li>
        <li><a href="ListProjets.jsp" class="hover:text-pink-600">Projets</a></li>
        <li><a href="Ressources.jsp" class="hover:text-pink-600">Resources</a></li>
    </ul>
    <a href="<%=request.getContextPath()%>/CreateProjet" class="hidden md:inline-block px-4 py-2 bg-pink-500 text-white rounded hover:bg-pink-600">Create projet</a>
</nav>

<main class="mx-auto max-w-7xl py-8 px-4">
    <h1 class="text-2xl font-semibold mb-8">Liste des Projets</h1>
    <div class="grid grid-cols-1 md:grid-cols-2 gap-4">
        <% List<ProjetModel> projets = (List<ProjetModel>) request.getAttribute("projets");

            if (projets != null) {
                for (ProjetModel projet : projets) { %>
        <div class="border border-gray-300 shadow-sm rounded-lg overflow-hidden">
            <div class="bg-gray-200 px-4 py-2 flex justify-between items-center">
                <h2 class="text-xl font-bold"><%= projet.getNom() %></h2>
                <div>
                    <a href="updateProjet?id=<%= projet.getId() %>" class="text-blue-500 hover:text-blue-700 mx-2">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a href="deleteProjet?id=<%= projet.getId() %>" class="text-red-500 hover:text-red-700">
                        <i class="fas fa-trash"></i>
                    </a>
                </div>
            </div>
            <div class="p-4 space-y-2">
                <h3 class="text-md font-semibold">Description</h3>
                <p class="text-sm text-gray-600"><%= projet.getDescription() %></p>
                <div class="text-sm mt-4">
                    <div>
                        <span class="font-semibold">Date début :</span>
                        <p><%= projet.getDate_debut() %></p>
                    </div>
                    <div class="mt-2">
                        <span class="font-semibold">Date fin :</span>
                        <p><%= projet.getDate_fin() %></p>
                    </div>
                </div>
                <div class="mt-2">
                    <span class="font-semibold">Budget :</span>
                    <p><%= projet.getBudget() %></p>
                </div>
            </div>
        </div>
        <% } } %>
    </div>
</main>
</body>
</html>
