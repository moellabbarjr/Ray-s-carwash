import * as data from '../json/login.json' assert { type: "json"};
const objPeople = data.default
// export default objPeople

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
            return
        }
    }
    console.log("email of wachtwoord komen niet overeen.")
}



export default {
  data: () => ({
    isEditing: false
  }),

  beforeMount() {
    window.addEventListener("beforeunload", this.preventNav)
    this.$once("hook:beforeDestroy", () => {
      window.removeEventListener("beforeunload", this.preventNav);
    })
  },

  beforeRouteLeave(to, from, next) {
    if (this.isEditing) {
      if (!window.confirm("Leave without saving?")) {
        return;
      }
    }
    next();
  },

  methods: {
    preventNav(event) {
      if (!this.isEditing) return
      event.preventDefault()
      event.returnValue = ""
    },
  },
}




