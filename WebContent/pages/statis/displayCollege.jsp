<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../basic/base.jsp"%>
<!DOCTYPE html>

<html lang="zh-cn">

<head>
    <link rel="stylesheet" href="../../../css/pintuer.css">
    <link rel="stylesheet" href="../../../css/admin.css">
    <script src="../../../js/jquery.js"></script>
    <script src="../../../js/pintuer.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>Hello WOrld</title>
    <style>
        body {
            width: 100%;
        }

        * {
            padding: 0;
            margin: 0;
            list-style: none;
        }

        .wrapper {
            width: 95%;
            border: 1px solid #ccc;
            border-bottom: none;
            margin: 5px auto;
            padding-left: 0;
        }

        .item {
            display: flex;
            align-items: center;
            justify-content: space-around;
        }

        .wrapper .item {
            width: 100%;
            border-bottom: 1px solid #ccc;

        }

        .wrapper .deep {
            background-color: #eee;
        }

        .item div {
            width: 14%;
            border-right: 1px solid #ccc;
            text-align: center;
            margin: 10px 0 10px 0;
        }

        .item div:last-child {
            border-right: none;
        }

        .ct-button {
            width: 200px;
            height: 30px;
            text-align: center;
            line-height: 30px;
            margin: 20px auto;
            background-color: deepskyblue;
        }

        .ct-button:hover {
            cursor: pointer;
        }

        .item .unallocated {
            color: red;
        }
    </style>
</head>

<body>

    <div class="wrappter">
        <div class="head">
            <select name="" id="class">
                <option value=""></option>
            </select>
        </div>
    </div>

    <ul class="wrapper">
        <li class="item head">
            <div class="name">姓名</div>
            <div class="sex">性别</div>
            <div class="college">学院</div>
            <div class="ID">学号</div>
            <div class="class">班级</div>
            <div class="grade">年级</div>
            <div class="bedroom">宿舍</div>
        </li>

    </ul>

    <div class="ct-button">打印</div>

</body>
<script>
    var collegeId = sessionStorage.getItem('collegeId');

    if (collegeId) {
        $.ajax({
            type: "GET",
            url: "${ctx}/selectClass",
            data: {
                collegeId: collegeId
            },
            dataType: "json",
            success: function (data) {
                console.log(data);
                $("#class").empty();
                $("#class").append('<option>选择班级</option>');
                data.forEach((ele) => {
                    $("#class").append('<option value="' + ele.classId + '">' + ele.className +
                        '</option>');
                });
            },
            error: function () {
                alert("eeror json");
            }
        });
    }

    var select = document.getElementById('class');
    select.onchange = function () {
        var apmId = this.value;

        $.ajax({
            type: "GET",
            url: "${ctx}/selectStudents",
            data: {
                classId: apmId
            },
            dataType: "json",
            success: function (data) {

                console.log(data, 111);
                sessionStorage.setItem('students', JSON.stringify(data));
                parseStudent(data);
            },
            error: function () {
                console.log("eeror json");
            }
        });
    }
</script>

<script>
    function parseList(data) {
        var wrp = document.querySelector('.wrapper');
        for (let i = 0; i < data.length - 1; i++) {
            for (let j = i + 1; j < data.length; j++) {
                if (data[i].studentNo > data[j].studentNo) {
                    let temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        var str = '';
        var fragment = document.createDocumentFragment();
        data.forEach((ele, index) => {
            var li = document.createElement("li");
            li.setAttribute('class', 'item');
            var sex;
            if (ele.sex === "b") {
                sex = "男";
            } else {
                sex = "女";
            }
            let bedroomName, bedroomState;

            if (ele.bedroomName === "") {
                bedroomName = '未分配';
                bedroomState = 'unallocated';
            } else {
                bedroomName = ele.bedroomName;
                bedroomState = '';
            }

            var lineState;
            if (index % 2 == 0) {
                lineState = " deep";
            } else {
                lineState = "";
            }

            str =
                '<div class = "name" >' + ele.studentName +
                '</div> <div class = "sex" >' + sex +
                '</div> <div class = "college" > ' + ele.collegeName +
                '</div> <div class = "ID" > ' + ele.studentNo +
                '</div> <div class = "class" > ' + ele.className +
                '</div> <div class = "grade" > ' + ele.grade +
                '</div> <div class = "bedroom ' + bedroomState + '" > ' + bedroomName +
                '</div> ';
            li.innerHTML = str;
            console.log(li.className);
            li.className += lineState;

            fragment.appendChild(li);
        })

        wrp.appendChild(fragment);
    }

    function parseStudent(data) {
        var data = JSON.parse(sessionStorage.getItem('students'));
        var wrp = document.querySelector('.wrapper');

        if (data.length > 0) {
            parseList(data);
            var printBtn = document.querySelector('.ct-button');
            printBtn.onclick = function () {
                window.print();
            }
        } else {
            console.warn('lala');
            wrp.innerHTML =
                `<li class="item head">
                    <div class="name">姓名</div>
                    <div class="sex">性别</div>
                    <div class="college">学院</div>
                    <div class="ID">学号</div>
                    <div class="class">班级</div>
                    <div class="grade">年级</div>
                    <div class="bedroom">宿舍</div>
                </li>`;
        }
    }
</script>

</html>