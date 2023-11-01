function toOut(){
    window.open('http://localhost:8080/login', '_self');
}
function toSettings(){
    window.open('http://localhost:8080/settings', '_self');
}

function toSearch(){
    var search = document.getElementById('city-input').value;
    window.open('http://localhost:8080/main?city='+search, '_self');
}