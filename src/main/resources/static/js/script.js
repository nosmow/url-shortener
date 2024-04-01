function copy() {
    var inputElement = document.getElementById("urlname");
    inputElement.select();
    document.execCommand("copy");

    //inputElement.setSelectionRange(0, 0);
}