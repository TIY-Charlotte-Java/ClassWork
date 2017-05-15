// getFiles takes filedata
// and turns it into HTML.
function getFiles(filesData) {
    // for each file in the file data:
    for (var i in filesData) {
        // make a new anchor tag
        var elem = $("<img>");

        // set the anchor tag's href to files/ + this file's filename
        elem.attr("src", "files/" + filesData[i].filename);

        // set the text of the anchor to the original file name
        // e.g. (picture.png)
        // elem.text(filesData[i].originalFilename);

        // append the anchor to the file list in the page
        $("#fileList").append(elem);

        // make a new <br> element and append it to the page
        // <br> elements are used mostly to force the browser
        // to render a new line character
        var elem2 = $("<br>");
        $("#fileList").append(elem2);
    }
}

// issues a GET request to "/files", and when
// it completes, runs the "getFiles" method.
$.get("/files", getFiles);