

$("#formaFile").submit(function(e) {
    e.preventDefault();
    var formData = new FormData(this);

    $.ajax({
        url: $(this).attr('action'),
        type: 'POST',
        data: formData,
        success: function() {
            alert("File(s) successfully loaded !")
        },
        cache: false,
        contentType: false,
        processData: false
    });
});

$("#formaAir").submit(function(e) {
    e.preventDefault();
    var formData = new FormData(this);

    $.ajax({
        url: $(this).attr('action'),
        type: 'POST',
        data: formData,
        success: function() {
            alert("Data successfully loaded! Go to Step 3")
        },
        cache: false,
        contentType: false,
        processData: false
    });
});