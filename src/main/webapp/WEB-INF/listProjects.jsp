<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

  <style>
    body {
      margin: 0;
      padding: 0;
    }

    .container {
      width: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .wrapper {
      opacity: 0.5;
      width: 100%;
      display: flex;
      justify-content: space-evenly;
      align-items: center;
    }

    .wrapper-right {
      width: 87%;
      height: 98%;
      background-color: white;
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    .navbar {
      margin: 20px 0;
      width: 90%;
      height: 10%;
      background-color: #00008b;
      display: flex;
      flex-direction: row-reverse;
      justify-content: space-between;
    }

    .links {
      width: 60%;
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .links>ul {
      width: 100%;
      height: 100%;
      display: flex;
      flex-direction: row-reverse;
      justify-content: space-evenly;
      align-items: center;
    }

    .links>ul a {
      text-decoration: none;
      color: white;
    }

    .links>ul>li {
      list-style: none;
      padding: 5px 10px;
      border-bottom: 1px solid white;
    }

    .logo {
      margin-top: 5px;
      width: 20%;
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    .project-info {
      width: 90%;
      background-color: rgb(164, 236, 239);
      display: flex;
      justify-content: space-around;
      flex-wrap: wrap;
      overflow: scroll;
    }

    .card {
      background-color: blue;
      width: 413px;
      height: 200px;
      border-radius: 13px;
      display: flex;
      margin-left: 5px;
      margin-top: 8px;
    }

    .card_left {
      background-color: #00008b;
      width: 40%;
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: space-evenly;
      align-items: center;
    }

    #budget {
      color: green;
    }

    .card_right {
      background-color: white;
      width: 60%;
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: space-evenly;
      align-items: center;
    }

    .card_left>h1,
    span {
      color: white;
    }

    #p {
      margin-top: 8px;
      color: rgb(0, 0, 0);
      font-size: 11px;
      width: 90%;
      height: 60%;
      display: flex;
      overflow: hidden;
      justify-content: center;
      align-items: center;
      border-bottom: 2px solid #00008b;
    }

    .btn_all,
    .btn_edit,
    .btn_delete {
      color: white;
      padding: 5px 7px;
      border-radius: 5px;
      text-decoration: none;
    }

    .btn_all {
      background-color: #00008b;
    }

    .btn_edit {
      background-color: #097b11;
    }

    .btn_delete {
      background-color: #f00f0f;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="wrapper-right">
    <div class="navbar">
      <div class="links">
        <ul>
          <li><a href="http://localhost:8089/Construction_Service_war_exploded/">Home</a></li>
          <li><a href="http://localhost:8089/Construction_Service_war_exploded/listProject">List Project</a></li>
          <li><a href="http://localhost:8089/Construction_Service_war_exploded/addProject">Add project</a></li>
        </ul>
      </div>
      <div class="logo">
        <img id="img" src="ConstructionXpert.png" alt="this is logo" width="50px">
      </div>
    </div>

    <div class="project-info">
      <c:forEach var="project" items="${listProjects}">
        <div class="card">
          <div class="card_left">
            <h1>${project.name}</h1>
            <span>${project.startDate}</span>
            <span>${project.endDate}</span>
            <h3 id="budget">${project.budget} <span>$</span></h3>
          </div>
          <div class="card_right">
            <p id="p">${project.description}</p>
            <div>
              <a class="btn_all"
                 href="${pageContext.request.contextPath}/ListTasksServlet?projectId=${project.projectId}"
                 class="task-button">See All Tasks</a>
              <a class="btn_edit"
                 href="${pageContext.request.contextPath}/UpdateProjectServlet?projectId=${project.projectId}"
                 class="update-button">Update</a>
              <a class="btn_delete"
                 href="${pageContext.request.contextPath}/DeleteProjectServlet?projectId=${project.projectId}"
                 class="delete-button">Delete</a>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</div>
</body>
</html>
