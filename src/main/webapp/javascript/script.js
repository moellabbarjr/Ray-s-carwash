import * as data from "../json/login.json" assert {type: "json"}
const objPeople = data.default

document.getElementById("submit").addEventListener("click", function(event){
    event.preventDefault();
    getInfo();
});

function getInfo(){
    var email = document.getElementById("loginEmail").value
    var password = document.getElementById("loginPassword").value

    for(let i = 0; i < objPeople.length; i++){
        if(email == objPeople[i].email && password == objPeople[i].password){
            document.location.href = "../adminpanel/admin_index.html"
            // console.log(email,password)
            return
        }
    }
    console.log("email of wachtwoord komen niet overeen.")
}






