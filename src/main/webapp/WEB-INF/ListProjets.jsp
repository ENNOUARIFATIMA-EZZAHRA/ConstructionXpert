<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.TacheModel" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestion des Taches</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white text-gray-800">
<nav class="flex items-center justify-between p-4 shadow-md">
    <div class="text-2xl font-bold">ConstructionXpert</div>
    <ul class="hidden space-x-4 md:flex">
        <li><a href="#" class="hover:text-pink-600">Home</a></li>
        <li><a href="#" class="hover:text-pink-600">Projets</a></li>
        <li><a href="#" class="hover:text-pink-600">Resources</a></li>
    </ul>
    <a href="/WEB-INF/ListProjets.jsp" class="hidden md:inline-block px-4 py-2 bg-pink-500 text-white rounded hover:bg-pink-600">
        Charger les tâches
    </a>
</nav>

<main class="mx-auto max-w-7xl py-8 px-4">
    <h1 class="text-2xl font-semibold mb-8">Liste des taches</h1>

    <div class="flex flex-col md:flex-row md:space-x-4 space-y-4 md:space-y-0">
        <%
            List<TacheModel> taches = (List<TacheModel>) request.getAttribute("taches");
            if (taches != null) {
                for (TacheModel tache : taches) {
        %>
        <div class="w-full md:w-1/3 border border-gray-300 shadow-sm rounded-lg overflow-hidden">
            <div class="bg-gray-200 px-4 py-2">
                <h2 class="text-xl font-bold"><%= tache.getNom() %></h2>
            </div>
            <div class="p-4 space-y-2">
                <h3 class="text-md font-semibold">Description</h3>
                <p class="text-sm text-gray-600"><%= tache.getDescription() %></p>
                <div class="flex justify-between text-sm mt-4">
                    <div>
                        <span class="font-semibold">date_debut :</span>
                        <p><%= tache.getDateDebut() %></p>
                    </div>
                    <div>
                        <span class="font-semibold">date_fin :</span>
                        <p><%= tache.getDateFin() %></p>
                    </div>
                </div>
                <div class="mt-2">
                    <span class="font-semibold">budget :</span>
                    <p><%= tache.getBudget() %></p>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
</main>
</body>
</html>
