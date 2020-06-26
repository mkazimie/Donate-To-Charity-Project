document.addEventListener("DOMContentLoaded", function () {

    let categoryBtn = document.getElementById("categories-button");
    let quantityBtn = document.getElementById("quantity-button");
    let institutionBtn = document.getElementById("institution-button");
    let finalInfoBtn = document.getElementById("final-info-button");

    // let catValue = "";
    let catArray = [];

    categoryBtn.addEventListener("click", function () {
        let categoryElements = document.querySelectorAll("input[type=checkbox]:checked");
        categoryElements.forEach(function (element) {
            let categoryContent = element.parentElement.lastElementChild.innerText;
            catArray.push(categoryContent);
        })

    });

    quantityBtn.addEventListener("click", function () {
        let quantValue = document.getElementById("quantityInput").value;

        let donationResult = document.getElementById("summary-donation");
        donationResult.innerText = `Liczba worków: ${quantValue} | Zawartość: ${catArray}`;

    });

    institutionBtn.addEventListener("click", function () {
        let institutionElement = document.querySelector("input[type=radio]:checked");
        let institutionValue = institutionElement.parentElement.lastElementChild.firstElementChild.innerText;
        console.log(institutionElement);
        console.log(institutionValue);

        let institutionResult = document.getElementById("summary-institution");
        institutionResult.innerText = `Odbiorca: ${institutionValue}`;

    });


    finalInfoBtn.addEventListener("click", function () {


        let streetValue = document.getElementById("streetInput").value;
        let cityValue = document.getElementById("cityInput").value;
        let zipCodeValue = document.getElementById("zipCodeInput").value;
        let phoneValue = document.getElementById("phoneInput").value;
        let dateValue = document.getElementById("dateInput").value;
        let timeValue = document.getElementById("timeInput").value;
        let commentValue = document.getElementById("commentInput").value;


        let streetResult = document.getElementById("summary-street");
        streetResult.innerText = streetValue;

        let cityResult = document.getElementById("summary-city");
        cityResult.innerText = cityValue;

        let zipCodeResult = document.getElementById("summary-zipCode");
        zipCodeResult.innerText = zipCodeValue;

        let phoneResult = document.getElementById("summary-phone");
        phoneResult.innerText = phoneValue;

        let dateResult = document.getElementById("summary-date");
        dateResult.innerText = dateValue;

        let timeResult = document.getElementById("summary-time");
        timeResult.innerText = timeValue;

        let commentResult = document.getElementById("summary-comments");
        commentResult.innerText = commentValue;
        if (commentValue === "") {
            commentResult.innerText = `Brak uwag`;
        }

    });


});