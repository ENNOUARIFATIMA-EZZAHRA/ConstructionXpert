<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.ProjetModel" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Projets</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body class="bg-white text-gray-800">

<!-- Barre de navigation -->
<nav class="flex items-center justify-between p-4 shadow-md">
    <div class="text-2xl font-bold">ConstructionXpert</div>
    <ul class="hidden space-x-4 md:flex">
        <li><a href="home.jsp" class="hover:text-pink-600">Home</a></li>
        <li><a href="ListProjets.jsp" class="hover:text-pink-600">Projets</a></li>
        <li><a href="Ressources.jsp" class="hover:text-pink-600">Resources</a></li>
    </ul>
    <a href="createprojet.jsp" class="hidden md:inline-block px-4 py-2 bg-pink-500 text-white rounded hover:bg-pink-600">
        Créer un projet
    </a>
</nav>

<!-- Contenu principal -->
    <% for (ProjetModel projet : projets) { %>
<div class="border border-gray-300 shadow-sm rounded-lg overflow-hidden">
    <div class="bg-gray-200 px-4 py-2 flex justify-between items-center">
        <h2 class="text-xl font-bold"><%= projet.getNom() %></h2>
        <div class="flex space-x-2">
            <!-- Formulaire Modifier -->
            <form method="get" action="update.jsp" class="inline">
                <input type="hidden" name="id" value="<%= projet.getId() %>">
                <input type="hidden" name="nom" value="<%= projet.getNom() %>">
                <input type="hidden" name="Description" value="<%= projet.getDescription() %>">
                <input type="hidden" name="Date_debut" value="<%= projet.getDate_debut() %>">
                <input type="hidden" name="Date_fin" value="<%= projet.getDate_fin() %>">
                <input type="hidden" name="Budget" value="<%= projet.getBudget() %>">
                <button type="submit" class="text-blue-500 hover:text-blue-700">
                    <i class="fas fa-edit"></i>
                </button>
            </form>
        </div>
    </div>
</div>
    <% } %>

<% } else { %>
<p class="text-center text-gray-600 text-lg">Aucun projet disponible.</p>
<% } %>

</main>
</body>
</html>
