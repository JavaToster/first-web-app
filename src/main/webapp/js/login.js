function openRegisterWindow(){
    window.open('http://localhost:8080/register', '_self');
}

function login(){
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    document.cookie = 'username='+username

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/back", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    var data = JSON.stringify({
    "username": ''+username,
    "password": ''+password,
    "type": '2'
    });

    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var json = JSON.parse(xhr.responseText);
            if(json.username == 'true' &&  json.password == 'true'){
                window.open('http://localhost:8080/main', '_self');
            }else{
                let label = document.getElementById('message');
                label.textContent = 'incorrect login or password';
            }
        }
    };

    xhr.send(data);
}

//89172825928