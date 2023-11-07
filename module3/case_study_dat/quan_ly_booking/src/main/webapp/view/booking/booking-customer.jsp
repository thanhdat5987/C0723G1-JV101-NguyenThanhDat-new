<%--
  Created by IntelliJ IDEA.
  User: thaodao
  Date: 05/11/2023
  Time: 12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Order</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        .my_body {
            background-color: #efcfd4;
        }

        .row {

        }

    </style>
</head>
<body>
<div class="my_body">
    <div class="row" style="padding: 50px; text-align: center">
        <h1>
            Xin vui lòng đặt lịch
        </h1>
        <h3>
            Để chúng tôi có thể chăm sóc tốt nhất cho Thú cưng của bạn
        </h3>
    </div>
    <div class="row" style="align-items: center">
        <div class="col-12 col-md-6">
            <form class="row g-3" style=" padding-left: 100px; padding-right: 100px " method="post">
                <div class="col-md-6">
                    <label for="validationDefault04" class="form-label">Chọn thời gian dự kiến đến</label>
                    <input type="datetime-local" class="form-control" id="validationDefault04"
                           name="estimatedTimeOfArrival">
                </div>
                <div class="col-md-6">
                    <label for="validationDefault04" class="form-label">Chọn thú cưng của bạn</label><br>
                    <select required name="petId" id="petId">
                        <c:forEach var="pet" items="${petList}">
                            <option value="${pet.petId}">${pet.petName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-floating">
                    <textarea class="form-control" placeholder="" id="floatingTextarea"
                              style="height: 200px" name="customerComment"></textarea>
                    <label for="floatingTextarea">Vui lòng chú thích nếu bạn có yêu cầu khác</label>
                </div>
                <div class="col-12">
                    <button class="btn btn-primary" type="submit">Xác nhận</button>
                </div>
            </form>
        </div>
        <div class="col-12 col-md-6 p-5 ">
            <div><img style="border-radius: 50px"
                      src="https://lh3.googleusercontent.com/pw/ADCreHfpvwd7qnv0X5TxQONaIZLK_FVxI8kiHeztIkQDXAbMNsv38gq1YNlPl-BMO9IZGdiDfWJ2h1-KPwcKlG4mGq87ygesSOKOS0Ua8iHUBJY1LFSJhcAbthVDtxL9nx98eka61776nOJaGaflmugAipFa=w800-h600-s-no"
                      width="100%"/></div>
        </div>
    </div>
</div>
</body>
</html>