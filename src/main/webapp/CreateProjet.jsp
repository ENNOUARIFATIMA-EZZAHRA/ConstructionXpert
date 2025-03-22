<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConstructionXpertApp</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-cover bg-center h-screen" >

<!-- Navigation Bar -->
<nav class="flex justify-between items-start bg-white text-black p-4 border-b-2 border-gray-200">
    <div class="text-xl font-bold mt-2 ">ConstructionXpertApp</div>
    <div class="flex space-x-8 mt-4">
        <a href="/ConstructionXpertApp/home.jsp" class="hover:text-blue-500 text-md">Home</a>
        <a href="/ConstructionXpertApp/ListProjets" class="hover:text-blue-500 bold-100">Projets</a>
        <a href="<%= request.getContextPath() %>/ListTaches" class="hover:text-blue-500 text-bold-500">Taches</a>

    </div>
    <div class="flex space-x-10">
        <a href="Register.jsp" class="bg-pink-500 text-white ml-6 px-6 py-3 rounded hover:bg-red-600">Register</a>
        <a href="Login.jsp" class="bg-pink-500 text-white ml-6 px-6 py-3 rounded hover:bg-red-600">Login</a>
    </div>
</nav>

<div class="max-w-4xl mx-auto p-6 bg-white shadow-md rounded-md mt-8">
    <h1 class="text-2xl font-bold mb-6 text-center">Creer nouveaux Projet</h1>
    <form action="${pageContext.request.contextPath}/insertProjet" method="POST" class="space-y-4">
        <div>
            <label for="nom" class="block font-medium">Name Projet </label>
            <input type="text" id="nom" name="nom" placeholder="Project Name" required
                   class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500">
        </div>
        <div>
            <label for="description" class="block font-medium">Description</label>
            <textarea id="description" name="description" placeholder="Description"
                      class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500"></textarea>
        </div>
        <div>
            <label for="date_debut" class="block font-medium">Date Debut</label>
            <input type="date" id="date_debut" name="date_debut" required
                   class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500">
        </div>
        <div>
            <label for="endDate" class="block font-medium">Date Fin</label>
            <input type="date" id="endDate" name="date_fin" required
                   class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500">
        </div>
        <div>
            <label for="budget" class="block font-medium">Budget</label>
            <input type="number" id="budget" name="budget" placeholder="Budget" required
                   class="w-full border rounded-lg px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500">
        </div>
        <div class="flex justify-between items-center">
            <button type="submit"
                    src="CreatProjet.jsp"class="bg-blue-500 text-white px-4 py-2 rounded-lg hover:bg-blue-600">Creer Projet</button>
            <a href="ProjetServlet" class="text-blue-500 hover:underline">Retour a la List des Projet </a>
        </div>
    </form>
</div>
</body>
</html>