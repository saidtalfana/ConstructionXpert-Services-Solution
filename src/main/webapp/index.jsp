<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Complete Dashboard</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .sidebar {
            height: 100%;
            width: 250px;
            position: fixed;
            top: 0;
            left: 0;
            background-color: #333;
            padding-top: 20px;
        }
        .sidebar a {
            padding: 10px 25px;
            text-decoration: none;
            font-size: 18px;
            color: white;
            display: block;
        }
        .sidebar a:hover {
            background-color: #555;
        }
        .content {
            margin-left: 250px;
            padding: 20px;
        }
        .section {
            margin-bottom: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        canvas {
            max-width: 100%;
            height: auto;
        }
    </style>
</head>
<body>
<div class="sidebar">
    <h2>Dashboard</h2>
    <a href="#home">Home</a>
    <a href="#statistics">Statistics</a>
    <a href="#charts">Charts</a>
    <a href="#forms">Forms</a>
    <a href="#tables">Tables</a>
</div>

<div class="content">
    <div id="home" class="section">
        <h2>Home</h2>
        <p>Welcome to the dashboard!</p>
    </div>

    <div id="statistics" class="section">
        <h2>Statistics</h2>
        <p>Total Users: <%= 1234 %></p>
        <p>Total Sales: $<%= 56789 %></p>
    </div>

    <div id="charts" class="section">
        <h2>Charts</h2>
        <canvas id="myChart"></canvas>
    </div>

    <div id="forms" class="section">
        <h2>Forms</h2>
        <form action="submit-form.jsp" method="post">
            <label for="name">Name:</label><br>
            <input type="text" id="name" name="name"><br>
            <input type="submit" value="Submit">
        </form>
    </div>

    <div id="tables" class="section">
        <h2>Tables</h2>
        <table>
            <tr>
                <th>Name</th>
                <th>Email</th>
            </tr>
            <tr>
                <td>John Doe</td>
                <td>john@example.com</td>
            </tr>
            <tr>
                <td>Jane Smith</td>
                <td>jane@example.com</td>
            </tr>
        </table>
    </div>
</div>

<script>
    // JavaScript for chart
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['January', 'February', 'March', 'April', 'May', 'June'],
            datasets: [{
                label: 'Sales',
                data: [12, 19, 3, 5, 2, 3],
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>
</body>
</html>
