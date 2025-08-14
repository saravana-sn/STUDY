function temperature(){
    var c = document.getElementById("celsius").value;
    var f = (c * 9/5) + 32;
    document.getElementById("fahrenheit").value = f;
}

function weight(){
    var k = document.getElementById("kilo").value;
    var p = k * 2.2;
    document.getElementById("pounds").value = p;
}

function distance(){
    var k = document.getElementById("km").value;
    var m = k * 0.62137;
    document.getElementById("miles").value = m;
}