    
var password = document.getElementById("pass");
var msg = document.getElementById("pmsg");
var str = document.getElementById("strength");

password.addEventListener("input", function(){
    if(password.value.length>0){
        msg.style.display = "block";
    }
    else{
        msg.style.display = "none";
    }
    if(password.value.length<4){
        str.innerHTML = "Week"
        str.style.color = "#ff5925"
        password.style.borderColor = "#ff5925"
    }
    else if(password.value.length>=4 && password.value.length<8){
        str.innerHTML = "Medium"
        str.style.color = "yellow";
        password.style.borderColor = "yellow"
    }
    else if(password.value.length>=9){
        str.innerHTML = "Strong"
        str.style.color = "green"
        password.style.borderColor = "green"
        // msg.style.display = "none";
    }
    
});