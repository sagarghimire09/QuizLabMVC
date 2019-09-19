<%@ page import="edu.mum.cs.model.Quiz" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quiz Lab</title>
</head>
<body>
<h1>The Number Quiz</h1>
<p>Your current score is <% out.println(session.getAttribute("score")); %></p>
<p>Guess the next number in the sequence.</p>
<p>
    <% out.println((String)session.getAttribute("quiz")); %>
</p>
<form action="" method="post">
    <input type="number" name="answer"><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>