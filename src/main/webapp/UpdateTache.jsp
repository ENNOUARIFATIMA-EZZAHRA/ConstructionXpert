<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Model.ProjetModel" %>
<%
    ProjetModel projet = (ProjetModel) request.getAttribute("projet");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier Tache</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-white text-gray-800">

<nav class="flex items-center justify-between p-4 shadow-md">
    <div class="text-2xl font-bold">ConstructionXpert</div>
    <div class="flex space-x-8 mt-4">
        <a href="/ConstructionXpertApp/home.jsp" class="hover:text-blue-500 text-md">Home</a>
        <a href="/ConstructionXpertApp/ListProjets" class="hover:text-blue-500 bold-100">Projets</a>
        <a href="/ConstructionXpertApp/ListTache" class="hover:text-blue-500 text-bold-500 ">Taches</a>
    </div>
</nav>

<div class="max-w-3xl mx-auto mt-10 p-6 bg-gray-100 rounded-lg shadow">
    <h1 class="text-2xl font-semibold mb-4">Modifier le<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <%@ page import="Model.TacheModel" %>
        <%@ page import="Model.TacheModel" %>
        <%
            TacheModel tache= (TacheModel) request.getAttribute("tache");
        %>
        <!DOCTYPE html>
        <html lang="fr">
        <head>
            <meta charset="UTF-8">
            <title>Modifier Tache</title>
            <script src="https://cdn.tailwindcss.com"></script>
        </head>
        <body class="bg-white text-gray-800">

        <nav class="flex items-center justify-between p-4 shadow-md">
            <div class="text-2xl font-bold">ConstructionXpert</div>
            <div class="flex space-x-8 mt-4">
                <a href="/ConstructionXpertApp/home.jsp" class="hover:text-blue-500 text-md">Home</a>
                <a href="/ConstructionXpertApp/ListProjets" class="hover:text-blue-500 bold-100">Projets</a>
                <a href="<%= request.getContextPath() %>/ListTaches" class="hover:text-blue-500 text-bold-500">Taches</a>
            </div>
        </nav>

        <div class="max-w-3xl mx-auto mt-10 p-6 bg-gray-100 rounded-lg shadow">
            <h1 class="text-2xl font-semibold mb-4">Modifier le Taches</h1>
            <form action="UpdateTache" method="post" class="space-y-4">
                <input type="hidden" name="id" value="<%= tache.getId() %>">

                <div>
                    <label>Nom :</label>
                    <input type="text" name="nom" value="<%= tache.getNom() %>" class="w-full px-4 py-2 border rounded">
                </div>
                <div>
                    <label>Description :</label>
                    <textarea name="description" class="w-full px-4 py-2 border rounded"><%= tache.getDescription() %></textarea>
                </div>
                <div>
                    <label>Date début :</label>
                    <input type="date" name="date_debut" value="<%= tache.getDate_debut() %>" class="w-full px-4 py-2 border rounded">
                </div>
                <div>
                    <label>Date fin :</label>
                    <input type="date" name="date_fin" value="<%= tache.getDate_fin() %>" class="w-full px-4 py-2 border rounded">
                </div>
                <div>
                    <label>Budget :</label>
                    <input type="number" step="0.01" name="budget" value="<%= tache.getBudget() %>" class="w-full px-4 py-2 border rounded">
                </div>

                <button type="submit" src="Listtache" class="bg-pink-500 text-white px-4 py-2 rounded hover:bg-pink-600">Enregistrer</button>
            </form>
        </div>

        </body>
        </html>
    </h1>
    <form action="updateTache" method="post" class="space-y-4">
        <input type="hidden" name="id" value="<%= tache.getId() %>">

        <div>
            <label>Nom :</label>
            <input type="text" name="nom" value="<%= tache.getNom() %>" class="w-full px-4 py-2 border rounded">
        </div>
        <div>
            <label>Description :</label>
            <textarea name="description" class="w-full px-4 py-2 border rounded"><%= tache.getDescription() %></textarea>
        </div>
        <div>
            <label>Date début :</label>
            <input type="date" name="date_debut" value="<%= tache.getDate_debut() %>" class="w-full px-4 py-2 border rounded">
        </div>
        <div>
            <label>Date fin :</label>
            <input type="date" name="date_fin" value="<%= tache.getDate_fin() %>" class="w-full px-4 py-2 border rounded">
        </div>
        <div>
            <label>Budget :</label>
            <input type="number" step="0.01" name="budget" value="<%= tache.getBudget() %>" class="w-full px-4 py-2 border rounded">
        </div>

        <button type="submit" src="ListTache" class="bg-pink-500 text-white px-4 py-2 rounded hover:bg-pink-600">Enregistrer</button>
    </form>
</div>

</body>
</html>
