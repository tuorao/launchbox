<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link rel="stylesheet" href="resources/css/admin.css">
    <script>
        //var serverUrl = "http://test.fallintrip.co.kr/launchbox/"
        var serverUrl = "";
        var orderIncome = 0;
        var knownOrder = 1;
        var printedOrder = 2;
        var cookingOrder = 3;
        var endCookOrder = 4;
        var userPushedOrder = 5;
        var endOrder = 6;
        function initOrderList(getDataUrl){
        	var changePhaseFlag = 1;
        	var thisPhase = 0;
        	 $.getJSON(getDataUrl, function (data) {
                 for (i = 0; i < data.length; i++) {
                	 thisPhase = data[i].order.phase;
                     if(thisPhase == 0){
                    	 changePhaseFlag = changePhase(knownOrder, data[i].order.srl);
                     }
                     if(changePhaseFlag != 2){
                    	 var nextPhageBtnImgSrc = "http://placehold.it/30x30";
                         var colorBar = $('<div class="colorBar"></div>');
                         var infoArea = $('<div class="infoArea"></div>');
                         var title = $('<div class="title"><nobr class="nobr"></nobr></div>');
                         var time = $('<div class="time"></div>');
                         var customer = $('<div class="customer"></div>');
                         var number = $('<div class="number"></div>');
                         var nextPhageBtn = $('<div class="nextStepBtn"><img src="' + nextPhageBtnImgSrc + '"></div>');
                         var lastPhageBtnWrap = $('<div class="orderFinalBtnWrap"><input type="button" value="알림" class="sendToCustomer"/><input type="button" value="결제완료" class="endOrder"/></div>');
                         var hideOption = $('<div class="hideOption" style="display:none;"></div>');
                         var orderSrl = $('<input type="hidden" class="orderSrl" value=""/>');
                         infoArea.append(title);
                         infoArea.append(time);
                         infoArea.append(customer);
                         infoArea.append(number);
                         infoArea.append(hideOption);
                         orderSrl.val(data[i].order.srl);
                         infoArea.children(".title").children(".nobr").text(data[i].order.srl+" 번주문");
                         infoArea.children(".time").text(data[i].order.startTime);
                         infoArea.children(".customer").text(data[i].user.name + " : " + data[i].user.phone);
                         infoArea.children(".number").text("수량 : " +  "개"); // 수량 추가 필요
                         infoArea.children(".hideOption").append(orderSrl);
                         for(z=0; z<data[i].item.length; z++){
                             var orderedMenuName = $('<input type="hidden" class="orderedMenuName" value=""/>');
                             var orderedMenuPrice = $('<input type="hidden" class="orderedMenuPrice" value=""/>');
                             orderedMenuName.val(data[i].item[z].title);
                             orderedMenuPrice.val(data[i].item[z].price);
                             infoArea.children(".hideOption").append(orderedMenuName);
                             infoArea.children(".hideOption").append(orderedMenuPrice);
                         }
                        
                         if (thisPhase < 3) {
                             var phageSet = $("<div class='step'></div>").addClass("step").append(colorBar).append(infoArea).append(nextPhageBtn);
                             phageSet.appendTo("#categorySet1");
                         }else if(thisPhase <  4){
                             var phageSet = $("<div class='step'></div>").addClass("step").append(colorBar).append(infoArea).append(nextPhageBtn);
                             phageSet.appendTo("#categorySet2");
                         }else{
                             var phageSet = $("<div class='step'></div>").addClass("step").append(colorBar).append(infoArea).append(lastPhageBtnWrap);
                             phageSet.appendTo("#categorySet3");
                         }
                     }
                 }
             });
        }
        function changePhase(phaseParam,orderSrlParam){
            $.get("/makeit/order/alterPhase",{"phase":phaseParam,"orderSrl":orderSrlParam}, function(dat) {
                return 0;
            })
                    .error(function() { return 2; })
                    .complete(function() { return 1; });
        }
        function initArea() {
           initOrderList("order/callOrderList");
        };
        function btnEvent(){
            $("body").on("click", ".nextStepBtn", function() {

                var thisIndex = $(this).parent(".step"); // 스텝 인덱스
                var thisParent = $(this).parents(".orderWrap").index();  // 페이즈 인덱스
                var lastPhageBtnWraps = $('<div class="orderFinalBtnWrap"><input type="button" value="알림" class="sendToCustomer"/><input type="button" value="결제완료" class="endOrder"/></div>');
                var thisOrderSrl = thisIndex.children(".infoArea").children(".hideOption").children(".orderSrl").val();
                var submitResults = 0;
                if(thisParent == 0){
                    // 첫번쩨 페이즈 일경우(주문)

                    submitResults = changePhase(cookingOrder,thisOrderSrl);
                    if(submitResults != 2){
                        thisIndex.clone().appendTo("#categorySet2");
                        thisIndex.remove();
                    }else{
                        alert("실패했습니다. 다시시도 해주세요");
                        alert(submitResults);
                    }


                }else{
                    submitResults = changePhase(endCookOrder,thisOrderSrl);
                    if(submitResults != 2){
                        thisIndex.children(".nextStepBtn").remove();
                        thisIndex.append(lastPhageBtnWraps);
                        // 두번쩨 페이즈 일경우(요리중)
                        thisIndex.clone().appendTo("#categorySet3");
                        thisIndex.remove();
                    }else{
                        alert("실패했습니다. 다시시도 해주세요");
                    }
                }
            });
            $("body").on("click", ".orderFinalBtnWrap input", function() {

                var thisIndex = $(this).parent(".step"); // 스텝 인덱스
                var thisParent = $(this).parents(".orderWrap").index();  // 페이즈 인덱스
                var lastPhageBtnWraps = $('<div class="orderFinalBtnWrap"><input type="button" value="알림" class="sendToCustomer"/><input type="button" value="결제완료" class="endOrder"/></div>');
                if(thisParent == 0){
                    // 첫번쩨 페이즈 일경우(주문)
                    thisIndex.clone().appendTo("#categorySet2");
                    thisIndex.remove();

                }else{
                    thisIndex.children(".nextStepBtn").remove();
                    thisIndex.append(lastPhageBtnWraps);
                    // 두번쩨 페이즈 일경우(요리중)
                    thisIndex.clone().appendTo("#categorySet3");
                    thisIndex.remove();
                }
            });
            $("body").on("click", ".infoArea", function() {
                var thisOption = $(this).children(".hideOption");
                $(".detailInfo").html("");
                var thisIndex = $(this).parent(".step").index();
                var itemName = $("<div class='detailItemName'></div>");
                var itemPrice = $("<div class='detailItemPrice'></div>");

                var i=0;
                var itemTable = $("<table></table>");
                var tableTitle = $("<tr><th>NO.</th><th>상품</th><th>가격</th></tr>")
                itemTable.append(tableTitle);
                $(".detailInfo").append(itemTable);
                while(thisOption.children(".orderedMenuName:eq("+i+")").val()!=null){
                    var addItem = $("<tr></tr>");
                    var nameTd = $("<td></td>").text(thisOption.children(".orderedMenuName:eq("+i+")").val());
                    var priceTd = $("<td></td>").text(thisOption.children(".orderedMenuPrice:eq("+i+")").val());
                    var numberTd = $("<td></td>").text(i);
                    addItem.append(numberTd).append(nameTd).append(priceTd);
                    itemTable.append(addItem);
                    $(".detailInfo").append(itemTable);
                    $(".showDetail").css("display","block");
                    i++;
                }
                var addItem = $("<tr></tr>");
                var nameTd = $("<td colspan='4' class='close'>닫기</td>");

                addItem.append(nameTd);
                itemTable.append(addItem);

                var thisOffset = $(this).parent(".step").offset();
                var thisHeight = $(this).parent(".step").height();
                $(".showDetail").css({"left":thisOffset.left-30,"top":thisOffset.top+thisHeight+20})
            });
            $("body").on("click", ".close", function() {
                $(".showDetail").fadeOut(500);
            });
            $("body").on("click", ".sendToCustomer", function() {
                // 고객에게 푸시알림 보내기
            	  $.get("order/pushInput",{"orderSrl":"77"}, function(dat) {
                      return 0;
                  })
                          .error(function() {a
                        	  lert("실패");
                          return 2; })
                          .complete(function() { 
							alert("메세지를 보냈습니다.")
                          });
            });
            $("body").on("click", ".endOrder", function() {
                // 결제완료
                var thisIndex = $(this).parents(".step"); // 스텝 인덱스
                var lastPhageBtnWraps = $('<div class="orderFinalBtnWrap"><input type="button" value="알림" class="sendToCustomer"/><input type="button" value="결제완료" class="endOrder"/></div>');
                var thisOrderSrl = thisIndex.children(".infoArea").children(".hideOption").children(".orderSrl").val();

                if (confirm("결제가 완료된 주문입니까??") == true){    //확인
                    submitResults = changePhase(endOrder,thisOrderSrl);
                    if(submitResults != 2){
                        thisIndex.remove();
                        alert("결제 완료 처리되었습니다.")
                    }else{
                        alert("실패했습니다. 다시시도 해주세요");
                    }
                }else{   //취소
                    return;
                }
            });
        }
        $(function (e) {
            initArea();
            btnEvent();
            $(".nextStepBtn").on("click",function(){
                alert(thisIndex);
            });
            setInterval(function(e){
            	var d = new Date();
            	
            	initOrderList("order/pullPhase?phase=0&date=",d.getDate());
            },5000)
        });
    </script>
</head>
<body>
<div id="adminTotalWrap">
    <div id="categorySet1" class="orderWrap">
        <div class="stepTitle">
            <h2>주문</h2>
        </div>
    </div>
    <div id="categorySet2" class="orderWrap">
        <div class="stepTitle">
            <h2>요리중</h2>
        </div>
    </div>
    <div id="categorySet3" class="orderWrap">
        <div class="stepTitle">
            <h2>결제대기</h2>
        </div>
        <div class="step">
            <div class="colorBar"></div>
            <div class="infoArea">
                <div class="title">
                    <nobr>어린이 도시락</nobr>
                </div>
                <div class="time">주문시간 : 12:30</div>
                <br>

                <div class="customer">김성겸 : 010 7757 193</div>
                <div class="number">수량: 12개</div>
            </div>
            <div class="orderFinalBtnWrap">
                <input type="button" value="알림" class="sendToCustomer"/>
                <input type="button" value="결제완료" class="endOrder"/>
            </div>
        </div>
    </div>
    <div class="clear"></div>
    <div class="showDetail">
        <div class="detailInfo"></div>
    </div>
</div>
</body>
</html>