//replace localhost with your ip address
function toDelete() {
    // Create a new div element to display the alert
    var alertDiv = document.createElement('div');
    alertDiv.setAttribute('id', 'alertDiv');
//    alertDiv.setAttribute('class', 'alertButton');
    alertDiv.innerHTML = 'Do you definitely want to delete?';

    // Create a new button element for "yes"
    var yesButton = document.createElement('button');
    yesButton.setAttribute('id', 'yesButton');
    yesButton.innerHTML = 'Yes';
    yesButton.onclick = function() {
        // Code to execute when "yes" is clicked
        var cookie = document.cookie;
                var cookiesList = cookie.split('; ');
                var username = null;
                for(var i = 0; i<cookiesList.length; i++){
                            if(cookiesList[i].split('=')[0] == 'username'){
                                username = cookiesList[i].split('=')[1];
                            }
                        }

                        alertDiv.style.display = 'none';

                        var xhr = new XMLHttpRequest();
                        xhr.open('POST', 'http://localhost:8080/back', true);
                        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

                        var data = JSON.stringify({
                            'type': '3',
                            'username': ''+username
                        });

                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4 && xhr.status === 200) {
                                var json = JSON.parse(xhr.responseText);
                                if(json.state == 200){
                                    window.open('http://localhost:8080/login', '_self');
                                }else{
                                    alert('some problem :(');
                                }
                            }
                        };

                        xhr.send(data);


        // Hide the alert div
        alertDiv.style.display = 'none';
    };

    // Create a new button element for "no"
    var noButton = document.createElement('button');
    noButton.setAttribute('id', 'noButton');
    noButton.innerHTML = 'Not';
    noButton.onclick = function() {
        // Code to execute when "no" is clicked
        console.log('You clicked no');

        // Hide the alert div
        alertDiv.style.display = 'none';
    };

    // Append the buttons to the alert div
    alertDiv.appendChild(yesButton);
    alertDiv.appendChild(noButton);

    document.body.appendChild(alertDiv);
}

function toChangeName(){
    var divInput = document.createElement('div');
    divInput.setAttribute('id', 'divName');

    var input = document.createElement('input');
    input.setAttribute('id', 'inputName');
    input.setAttribute('placeholder', 'input name');

    var changeBtn = document.createElement('button');
    changeBtn.setAttribute('id', 'changeName');
    changeBtn.setAttribute('class', 'inputButtonsName')
    changeBtn.innerHTML = 'Change';
    changeBtn.onclick = function(){
        var cookie = document.cookie;
        var cookiesList = cookie.split('; ');
        var username = null;
        for(var i = 0; i<cookiesList.length; i++){
                    if(cookiesList[i].split('=')[0] == 'username'){
                        username = cookiesList[i].split('=')[1];
                    }
                }

                divInput.style.display = 'none';

                var xhr = new XMLHttpRequest();
                xhr.open('POST', 'http://localhost:8080/back', true);
                xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

                var data = JSON.stringify({
                    'type': '4',
                    'username': ''+username,
                    'new-firstname': input.value+''
                });

                xhr.onreadystatechange = function () {
                    if (xhr.readyState === 4 && xhr.status === 200) {
                        var json = JSON.parse(xhr.responseText);
                        if(json.state == 200){
                            window.open('http://localhost:8080/settings', '_self');
                        }else{
                            alert('some problem :(');
                        }
                    }
                };

                xhr.send(data);


    };

    var notBtn = document.createElement('button');
    notBtn.setAttribute('id', 'notBtn');
    notBtn.setAttribute('class', 'inputButtonsName');
    notBtn.innerHTML = 'Not';
    notBtn.onclick = function(){
        divInput.style.display = 'none';
    };

    divInput.appendChild(input);
    divInput.appendChild(changeBtn);
    divInput.appendChild(notBtn);

    document.body.appendChild(divInput);
}

function toChangeLastname(){
    var divInput = document.createElement('div');
    divInput.setAttribute('id', 'divLastname');

    var input = document.createElement('input');
    input.setAttribute('id', 'inputLastname');
    input.setAttribute('placeholder', 'input lastname');

    var changeBtn = document.createElement('button');
    changeBtn.setAttribute('id', 'changeBtnLastname');
    changeBtn.setAttribute('class', 'inputButtonsLastname')
    changeBtn.innerHTML = 'Change';
    changeBtn.onclick = function(){
        var cookie = document.cookie;
                var cookiesList = cookie.split('; ');
                var username = null;
                for(var i = 0; i<cookiesList.length; i++){
                            if(cookiesList[i].split('=')[0] == 'username'){
                                username = cookiesList[i].split('=')[1];
                            }
                        }

                        divInput.style.display = 'none';

                        var xhr = new XMLHttpRequest();
                        xhr.open('POST', 'http://localhost:8080/back', true);
                        xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

                        var data = JSON.stringify({
                            'type': '5',
                            'username': ''+username,
                            'new-lastname': input.value+''
                        });

                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4 && xhr.status === 200) {
                                var json = JSON.parse(xhr.responseText);
                                if(json.state == 200){
                                    window.open('http://localhost:8080/settings', '_self');
                                }else{
                                    alert('some problem :(');
                                }
                            }
                        };

                        xhr.send(data);


    };

    var notBtn = document.createElement('button');
    notBtn.setAttribute('id', 'notBtn');
    notBtn.setAttribute('class', 'inputButtonsLastname');
    notBtn.innerHTML = 'Not';
    notBtn.onclick = function(){
        console.log('you click not');

        divInput.style.display = 'none';
    };

    divInput.appendChild(input);
    divInput.appendChild(changeBtn);
    divInput.appendChild(notBtn);

    document.body.appendChild(divInput);
}
function toOut(){
    window.open('http://localhost:8080/main', '_self');
}