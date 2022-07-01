function ValidateEmail(emailId)
    {
        var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        if(emailId.value.match(mailformat))
    {
        document.getElementById('password').focus();
        return true;
    }
        else
    {
        document.getElementById('emailId').focus();
        return false;
    }
}

function spamChk() {
    var ent1 = document.form-horizontal.Email.value
    var str1 = ent1.toLowerCase();
    if (str1.includes("noreply")) {
    document.form-horizontal.reset();
    }
}
