<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href=" https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css ">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <style>
        body {
            margin: 0;
            padding: 0;
        }

        .container{
            width: 100%;

            display: flex;
            justify-content: center;
            align-items: center;
        }
        .wrapper{


            opacity: 0.5;
            width: 100%;
            display: flex;
            justify-content: space-evenly;
            align-items: center;
        }

        /* .wrapper-left{
            background-color:   #00008b;
            border: 1px solid black;
            position:fixed;
            width: 5%;
            height: 545px;
            border-radius: 17px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        } */
        #icons_1{
            height: 27%;
            display: flex;
            flex-direction: column;
            justify-content: space-around;
            align-items: center;
        }
        #icons_2{
            height: 15%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;


        }

        .wrapper-right{
            width: 87%;
            height: 98%;
            background-color: white;
            display: flex;
            flex-direction: column;
            align-items: center;

        }
        .navbar{
            margin: 20px 0;
            width: 90%;
            height: 10%;
            /* position: fixed; */
            background-color: #00008b;
            display: flex;
            flex-direction: row-reverse;
            justify-content: space-between;
        }
        .links{
            width: 60%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .links>ul{
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: row-reverse;
            justify-content: space-evenly;
            align-items: center;
        }
        .links>ul a{
            text-decoration: none;
            color: white;
        }
        .links>ul>li{
            list-style: none;
            padding: 5px 10px;

            border-bottom: 1px solid white;
        }
        .links>ul>li :hover{
        }
        .logo{
            margin-top: 5px;
            width: 20%;
            height: 100%;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .info{
            width: 90%;
            height: 25%;
            background-color: rgb(164, 236, 239);
            display: flex;
            justify-content: space-evenly;
            align-items: center;
            border-radius: 17px;

        }
        /* .img_info{
            width: 56px;
            height: 56px;
        }
        .infop{
            width: 27%;
            height: 88%;
            background-color: rgba(94, 165, 232, 0.5);
            border-radius: 16px;
            display: flex;
            justify-content: space-evenly;
            align-items: center;
        } */

        .project-info{
            width: 90%;
            background-color: rgb(164, 236, 239);
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            overflow: scroll;


        }
        .card{
            background-color: blue;
            width: 200px;
            height: 313px;
            border-radius: 13px;
            display: flex;
            flex-direction: column;
            margin-left: 5px;
            margin-top: 8px;
        }
        .card_top{
            background-color: green;
            width: 100%;
            height: 45%;
            display: flex;
            flex-direction: column;
            justify-content: space-evenly;
            align-items: center;
        }
        #budget{
            color: green;
        }
        .card_buttom{
            background-color: white;
            width: 100%;
            height: 55%;
            display: flex;
            flex-direction: column;
            justify-content: space-evenly;
            align-items: center;

        }
        .card_left>h1 ,span{
            color: white;
        }

        #p{
            margin-top: 8px;
            color: rgb(0, 0, 0);
            font-size: 11px;
            width: 90%;
            height: 60%;
            display: flex;
            overflow: hidden;
            justify-content: center;
            align-items: center;
            border-bottom: 2px solid green;
        }
        .btn_all{
            color: white;
            background-color: #00008b;
            padding: 3px 5px;
            border-radius: 3px;
        }
        .btn_edit{
            color: white;
            background-color: #097b11;
            padding: 1px 5px;
            border-radius: 1px;
            text-decoration: none;


        }
        .btn_delete{
            color: white;
            background-color: #f00f0f;
            padding: 1px 5px;
            border-radius: 1px;
            text-decoration: none;

        }

        table{
            background-color: #fff;
            width: 100%;
            text-align:center;


        }
        table #tr  {
            background-color: #5f5e5e;


        }

        table tr td{
            background-color: skyblue;
            align-self: center;
        }
        #btn-show_more{
            background-color: rgb(38, 132, 214);
        }
        #btn-delete{
            background-color: rgb(0, 209, 59);

        }
        #btn-edit{
            background-color: rgb(38, 132, 214);

        }

    </style>
</head>
<body>
<div   class="container">
    <div  class="wrapper">

        <!-- <div class="wrapper-left">
                 <div id="icons_1">
                    <i class="fa-solid fa-plus fa-beat-fade" style="color: #ffffff"></i>
                    <i class="fa-solid fa-list fa-beat-fade" style="color: #ffffff"></i>
                 </div>
                 <div id="icons_2">
                    <i class="fa-solid fa-arrow-right-from-bracket fa-beat-fade" style="color: #ffffff"></i>
                 </div>

            </div> -->


        <div class="wrapper-right">

            <div class="navbar">

                <div class="links">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/listProject">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/listProject">List Project</a></li>
                        <li> <a href="${pageContext.request.contextPath}/AddResourceServlet?taskId=${taskId}">Add Resource</a></li>
                    </ul>

                </div>
                <div class="logo"><img id="img" src="ConstructionXpert.png" alt="this is logo " width="50px"></div>
            </div>



            <div class="project-info">

                <table>
                        <tr id="tr">
                            <th>Name</th>
                            <th>Type</th>
                            <th>Quantity</th>
                            <th>Provider</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    <c:forEach var="resource" items="${resources}">
                        <tr>
                            <td>${resource.name}</td>
                            <td>${resource.type}</td>
                            <td>${resource.quantity}</td>
                            <td>${resource.provider}</td>
                            <td> <a href="${pageContext.request.contextPath}/UpdateResourceServlet?resourceId=${resource.resourceId}&taskId=${resource.taskId}" class="btn_edit">Update</a>
                            </td>
                            <td>        <a href="${pageContext.request.contextPath}/DeleteResourceServlet?resourceId=${resource.resourceId}&taskId=${resource.taskId}" class="btn_delete">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>


















            </div>


        </div>

    </div>
</div>


</body>
</html>