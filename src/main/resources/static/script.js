
// window.addEventListener("load", function () {
//     //not jquery!
//     // Access the form element...
//     var form = document.getElementById("changeStudent");
//
//     // ...and take over its submit event.
//     form.addEventListener("submit", function (event) {
//         event.preventDefault(); // prevent form submission and reloading the page.
//
//         //your code to validate or do what you need with the form.
//     });
// });

$(document).ready(function() {
needUpdate = false;
    function update() {
        $.ajax({
            url: '/',
            method: 'GET',
            success: function (data) {
                // Заменяем содержимое текущей страницы на полученный HTML-код
                document.open();
                document.write(data);
                document.close();
            },
            error: function (error) {
                console.log('Ошибка при получении данных:', error);
            }
        });
    }

    $('#createStudent').submit(function(event) {
        event.preventDefault();
        var formData = {
            name: $('#nameFloatingInput1').val(),
            surname: $('#surnameFloatingInput1').val(),
            patronymic: $('#patronymicFloatingInput1').val(),
            variant: parseInt($('#variantFloatingInput1').val(), 10),
            rating: parseInt($('#ratingFloatingInput1').val(), 10),
            worksSubmitted: parseInt($('#worksFloatingInput1').val(), 10),
        };

        var jsonData = JSON.stringify(formData);
        console.log ("POSTED DATA")
        console.log(jsonData);
        $.ajax({
            url: '/students',
            method: 'POST',
            headers: {'X-XSRF-TOKEN': $("meta[name='_csrf']").attr("content")},
            contentType: 'application/json',
            data: jsonData,
            success: function(data) {
                update()
            },
            error: function(error) {
                console.log('������ ��� �������� ������:', error);
                Swal.fire({
                    icon: 'error',
                    title: 'Ошибка',
                    text: 'Произошла ошибка: ' + error.responseText // error.responseText содержит текст ошибки
                });
            }
        });
    });

    $('#changeStudent').submit(function(event) {
        event.preventDefault();
        var formData = {
            id: parseInt($('#idFloatingInput').val(), 10),
            variant: parseInt($('#variantFloatingInput2').val(), 10),
            rating: parseInt($('#ratingFloatingInput2').val(), 10),
            worksSubmitted: parseInt($('#worksFloatingInput2').val(), 10),
        };

        var jsonData = JSON.stringify(formData);
        console.log ("PUTTED DATA")
        console.log(jsonData);
        $.ajax({
            url: '/students/' + formData.id,
            method: 'PUT',
            headers: {'X-XSRF-TOKEN': $("meta[name='_csrf']").attr("content")},
            contentType: 'application/json',
            data: jsonData,
            success: function() {
                update();
            },
            error: function(error) {
                console.log('������ ��� �������� ������:', error);
                Swal.fire({
                    icon: 'error',
                    title: 'Ошибка',
                    text: 'Произошла ошибка: ' + error.responseText // error.responseText содержит текст ошибки
                });
            }
        });
    });

    $('#deleteStudent').submit(function(event) {
        event.preventDefault();
        var formData = {
            id: parseInt($('#idFloatingInput2').val(), 10),
        };

        $.ajax({
            url: '/students/' + formData.id,
            method: 'DELETE',
            headers: {'X-XSRF-TOKEN': $("meta[name='_csrf']").attr("content")},
            contentType: 'application/json',
            success: function() {
                update()
            },
            error: function(error) {
                Swal.fire({
                    icon: 'error',
                    title: 'Ошибка',
                    text: 'Произошла ошибка: ' + error.responseText // error.responseText содержит текст ошибки
                });
            }
        });
    });
    if (needUpdate) update()
});