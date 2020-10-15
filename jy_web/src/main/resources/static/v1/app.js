var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#notice").html("");
}

function connect() {
	var from = $("#from").val();
	var socket = new SockJS('http://127.0.0.1:8080/jyinfo/endpoint-websocket', null, {timeout: 15000});
    stompClient = Stomp.over(socket);
    stompClient.connect({},
        (res) => {
            setConnected(true);
            console.log('Connected: ' + res);
            stompClient.subscribe('/chat/single/'+from, function (result) {
                showContent(JSON.parse(result.body));
            });
            alert("ok")
        },
        (error) => {
            console.log("error")
            console.log(error)
        }

    );
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
	
    stompClient.send("/jyinfo/app/v1/single/chat", {}, JSON.stringify({'content': $("#content").val(), 'to':$("#to").val(), 'from':$("#from").val()}));
    
    
}

function showContent(body) {
    $("#notice").append("<tr><td>" + body.form + ":" + body.content + "</td> <td>"+new Date(body.time).toLocaleString()+"</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
});

