<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ConstructionXpertApp</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-cover bg-center h-screen" style="background-image: url('images/background.jpg');">

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

<!-- Welcome Section -->
<div class="text-center mt-10">
    <h1 class="text-4xl font-bold text-gray-800">Welcome to ConstructionXpertApp</h1>
    <p class="text-lg text-gray-600 mt-4">
        Cette application web permettra à l'équipe de construction de créer et de gérer des projets
        de construction, d'assigner des tâches aux membres de l'équipe, de gérer les ressources nécessaires
        et de suivre les détails des projets et des tâches.
    </p>
</div>


<div class="text-center mt-16">
    <a href="CreateProjet.jsp" class="bg-blue-500 text-white px-6 py-3 rounded hover:bg-blue-600">
        Creer Projet
    </a>
</div>

<

</body>
</html>
