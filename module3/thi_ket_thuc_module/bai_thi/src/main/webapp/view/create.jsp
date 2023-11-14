<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Them moi</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
          crossorigin="anonymous"></script>
</head>
<body>
<form method="post">
  <table class="table table-primary table-striped ">
    <caption>
      <h2>
        Thêm mới
      </h2>
    </caption>
    <tr>
      <th>Thêm :</th>
      <td>
        <select required name="?" id="?">

            <option value="? "> ?</option>

        </select>
      </td>
    </tr>
    <tr>
      <th>Thêm nhân viên:</th>
      <td>
        <select required name="employeeId" id="employeeId">

            <option value=" ?"> ?</option>

        </select>
      </td>
    </tr>
    <tr>
      <td>
        <input type="submit" value="Thêm mới"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
