<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add New Project</title>
    <style>
    </style>
</head>
<body>
<h1>Add New Project</h1>
<form action="${pageContext.request.contextPath}/AddProjectServlet" method="post">
    <div class="form-group">
        <label for="name">Project Name:</label>
        <input type="text" id="name" name="name" required>
    </div>
    <div class="form-group">
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea>
    </div>
    <div class="form-group">
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required>
    </div>
    <div class="form-group">
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required>
    </div>
    <div class="form-group">
        <label for="budget">Budget:</label>
        <input type="text" id="budget" name="budget"  required>
    </div>
    <input type="submit" value="Add Project">
</form>
</body>
</html>
