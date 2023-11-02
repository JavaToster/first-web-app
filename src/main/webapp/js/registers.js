function register(){
    var username = document.getElementById('username').value;
    var firstname = document.getElementById('firstname').value;
    var lastname = document.getElementById('lastname').value;
    var phone = document.getElementById('phone').value;
    var password = document.getElementById('password').value;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/back", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    var data = JSON.stringify({
        "username": ''+username,
        "password": ''+password,
        'firstname': ''+firstname,
        'lastname': ''+lastname,
        'phone': ''+phone,
        'type': '1'
    });

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            if(json.username == 'true'){
                let label = document.getElementById("message");
                label.textContent = 'nickname registered';
            }else{
                document.cookie = 'username='+username;
                window.open('http://localhost:8080/main', '_self');
            }
        }
    };

    xhr.send(data);
}

function openLoginWindow(){
    window.open('http://localhost:8080/login', '_self');
}
