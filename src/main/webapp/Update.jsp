<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Model.ProjetModel" %>
<%
    ProjetModel projet = (ProjetModel) request.getAttribute("projet");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier Projet</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white text-gray-800">

<nav class="flex items-center justify-between p-4 shadow-md">
    <div class="text-2xl font-bold">ConstructionXpert</div>
    <ul class="hidden space-x-4 md:flex">
        <li><a href="home.jsp" class="hover:text-pink-600">Home</a></li>
        <li><a href="ListProjets.jsp" class="hover:text-pink-600">Projets</a></li>
        <li><a href="Ressources.jsp" class="hover:text-pink-600">Resources</a></li>
    </ul>
</nav>

<div class="max-w-3xl mx-auto mt-10 p-6 bg-gray-100 rounded-lg shadow">
    <h1 class="text-2xl font-semibold mb-4">Modifier le Projet</h1>
    <form action="updateProjet" method="post" class="space-y-4">
        <input type="hidden" name="id" value="<%= projet.getId() %>">

        <div>
            <label>Nom :</label>
            <input type="text" name="nom" value="<%= projet.getNom() %>" class="w-full px-4 py-2 border rounded">
        </div>
        <div>
            <label>Description :</label>
            <textarea name="description" class="w-full px-4 py-2 border rounded"><%= projet.getDescription() %></textarea>
        </div>
        <div>
            <label>Date début :</label>
            <input type="date" name="date_debut" value="<%= projet.getDate_debut() %>" class="w-full px-4 py-2 border rounded">
        </div>
        <div>
            <label>Date fin :</label>
            <input type="date" name="date_fin" value="<%= projet.getDate_fin() %>" class="w-full px-4 py-2 border rounded">
        </div>
        <div>
            <label>Budget :</label>
            <input type="number" step="0.01" name="budget" value="<%= projet.getBudget() %>" class="w-full px-4 py-2 border rounded">
        </div>

        <button type="submit" src="ListProjet" class="bg-pink-500 text-white px-4 py-2 rounded hover:bg-pink-600">Enregistrer</button>
    </form>
</div>

</body>
</html>
