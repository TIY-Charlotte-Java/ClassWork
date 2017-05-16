window.addEventListener('load', function () {
    let ccElements = document.querySelectorAll('.showCC');

    for (let i = 0; i < ccElements.length; i++) {
        ccElements[i].addEventListener('click', function () {
            ccElements[i].textContent = ccElements[i].dataset.ccnum;
        });
    }

//    $(".creditCard").on("click", function (ev) {


//        if (ev.target != ev.currentTarget) { return; }

//        let showCC = $(this).find(".showCC");
//
//        let visible = showCC.is(":visible");
//
//        $(".showCC").hide();
//
//        showCC.toggle(!visible);
//    });
});