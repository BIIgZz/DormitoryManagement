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

        .ct-dormitory #dormitory {
            width: 200px;
            height: 30px;
            text-align: center;
            line-height: 30px;
            padding-left: 80px;
            margin: 30px;
        }

        .wrapper {
            width: 95%;
            border: 1px solid #ccc;
            margin: 5px auto;
        }

        .wrapper .item {
            display: flex;
            width: 100%;
            height: 40px;
            justify-content: space-around;
            align-items: center;
            border-bottom: 1px solid #ccc;
        }

        .wrapper .item:last-child {
            border-bottom: none;
        }

        .wrapper .item div {
            text-align: center;
            width: 25%;
            font-size: 18px;
            border-right: 1px solid #ccc;
        }
        
        .wrapper .item .showRed{
        	color: red;
        }
        

        .wrapper .item .clickMe:hover {
            cursor: pointer;
            color: deepskyblue;
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
    </style>
</head>

<body>

    <div class="ct-dormitory">
        <select id="dormitory" class="" name="dormitoryID">
            <option value="">选择</option>
        </select>
    </div>


    <ul class="wrapper">
        <li class="head item">
            <div class="dormitoryID">宿舍号</div>
            <div class="floor">楼层</div>
            <div class="state">满员</div>
            <div class="residue">空床</div>
        </li>
    </ul>





    <div class="ct-button">打印</div>

</body>
<script>
	
    var regionId = sessionStorage.getItem('regionId');
    console.log('regionId', regionId);
    if(JSON.parse(regionId)) {
    	$.ajax({
            type: "POST",
            url: "${ctx}/selectApartment",
            dataType: "json",
            data:{
            	regionId: regionId
            },
            success: function (data) {
            	console.log(data, 1314);
            	data = [
            		{"apartmentId": 1, apartmentName: "1栋"},
            		{"apartmentId": 2, apartmentName: "2栋"},
            		{"apartmentId": 3, apartmentName: "3栋"},
            		{"apartmentId": 4, apartmentName: "4栋"},
            		{"apartmentId": 5, apartmentName: "5栋"},
            		{"apartmentId": 6, apartmentName: "6栋"},
            		{"apartmentId": 7, apartmentName: "7栋"},
            		{"apartmentId": 8, apartmentName: "8栋"},
            		{"apartmentId": 9, apartmentName: "9栋"},
            		{"apartmentId": 10, apartmentName: "10栋"}];
            	
            	
            	$("#dormitory").empty();
         		$("#dormitory").append('<option>选择</option>');
             	 $.each(data,function(index,item){
             		console.log(item);
             		$("#dormitory").append('<option value="'+item["apartmentId"]+'">'+item["apartmentName"]+'</option>');
             	});
         		//$("#dormitory").append('<option value="'+data["apartmentId"]+'">'+item["apartmentIdName"]+'</option>');
             	
            },
            
            error: function () {
                console.log('err....');
            }
        })
        
    	
    }
    dormitory.onchange = function (e) {
        var id = this.value;
        $.ajax({
            type: "GET",
            url: "${ctx}/selectBedRoom",
            dataType: "json",
            data:{
            	apmId: id
            },
            success: function (data) {
				console.log(data);
				
                parseList(data);
            },
            error: function () {
                console.log('err....');
            }
        })
    }


    function parseList(data) {
        var wrp = document.querySelector('.wrapper');
        wrp.innerHTML = '';
        
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
        var oLi = document.createElement('li');
        oLi.className = "head item";
       	oLi.innerHTML = `<li class="head item">
            <div class="dormitoryID">宿舍号</div>
            <div class="floor">楼层</div>
            <div class="state">满员</div>
            <div class="residue">人数</div>
        		</li>`;
        fragment.appendChild(oLi);
        /* <li class="item">
            <div class="dormitoryID clickMe">322</div>
            <div class="floor">3</div>
            <div class="state">是</div>
            <div class="residue">0</div>
        </li> */
        data.forEach((ele, index) => {
            var li = document.createElement("li");
            li.setAttribute('class', 'item');
            var floor;

            // 获取楼层
            var a = ele.bedroomName.split('-');
            var bedName = '';
            if (a.length > 1) {
                floor = a[1].split('')[0];
                bedName = a[1];
            } else {
                floor = a[0].split('')[0];
                bedName = a[0];
            }
            
            

            var state = '';
            var showRed = '';
            if (ele.totalBed == 4) {
                state = '已满';
                showRed = '';
            } else {
                state = '没住满';
                showRed = 'showRed';
            }

            str =
                '<div class="dormitoryID clickMe">' + bedName +
                '</div>\
                <div class="floor">' + floor +
                '</div>\
                <div class="state '+ showRed +'">' + state +
                '</div>\
                <div class="residue '+ showRed +'">' + ele.totalBed + '</div>';

            li.innerHTML = str;

            fragment.appendChild(li);
        })

        wrp.appendChild(fragment);
        
        wrp.onclick = function (e){
        	showDormitory(e);
        }
    }
    
    // 显示宿舍详细信息
    function showDormitory(e) {
    	var target = e.target;
    	
    	console.log(target);
    	if(target.className.includes('clickMe')) {
    		var dormitoryID = parseInt(target.innerText);


    		$.ajax({
                type: "POST",
                url: "${ctx}/selectApartment",
                dataType: "json",
                data:{
                	regionId: regionId
                },
                success: function (data) {
             
             		$("#dormitory").append('<option>选择</option>');
                 	 $.each(data,function(index,item){
                 		console.log(item);
                 		$("#dormitory").append('<option value="'+item["apartmentId"]+'">'+item["apartmentName"]+'</option>');
                 	});
             		//$("#dormitory").append('<option value="'+data["apartmentId"]+'">'+item["apartmentIdName"]+'</option>');
                 	
                },
                
                error: function () {
                    console.log('err....');
                }
            })
    	}
    	
    }
    
    var printBtn = document.querySelector('.ct-button');
    printBtn.onclick = function () {
        window.print();
    }

</script>


</html>