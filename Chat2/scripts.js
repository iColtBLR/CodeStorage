window.onload = variables();

function set_name() {
    var Name = document.getElementById("Name");
    if(Name.style.visibility=="hidden") {
        var InName = document.getElementById("inputName");
        if(InName.value.trim()) {
            var SelEct = document.getElementById("select");
            Name.textContent = InName.value;
            InName.value="";
            InName.disabled = true;
            InName.style.visibility = "hidden";
            SelEct.style.visibility = "hidden";
            Name.style.visibility="visible";
            var tArea = document.getElementById("textInp");
            tArea.readOnly = false;
        }
    }
    return;
}

function send_mess() {
    var a = document.getElementById("textInp");
    var b = document.createElement("div");

    b.textContent = a.value;
    b.style.backgroundColor = "#bef";
    b.style.textAlign = "left";
    b.style.fontFamily = "Times New Roman";
    b.style.fontWeight = "bold";
    b.style.color = "#777";
    b.style.margin = "18px";
    var c = document.getElementById("textHist");
    c.appendChild(b);
    return;
}
function myFunction() {
    
    var c = document.getElementById("history");
    var textArea = document.createElement('div');
     
    textArea.id = 'sent-message-area';
    var text = document.getElementById('textInp');
    textArea.innerHTML =  text.value;
    c.appendChild(textArea);
    text.value = '';
    //NewTeg();
}
