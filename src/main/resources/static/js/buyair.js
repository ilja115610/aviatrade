



function loadAircraft() {
    var form = $('#hm_search');
    form.onsubmit = function (event) {
        event.preventDefault();}
    var formData = new FormData(document.getElementById("hm_search"));
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            var aircrafts = JSON.parse(this.responseText);
            var html = '<tr>\n' +
                '<th> Picture</th>\n' +
                '        <th>Id</th>\n' +
                '        <th>Manufacturer/model</th>\n' +
                '        <th>Year</th>\n' +
                '        <th>Location</th>\n' +
                '        <th>S/N</th>\n' +
                '        <th>TTAF</th>\n' +
                '<th>Reg Nr.</th>\n' +
                '        <th>Owner</th>\n' +
                '<th>Price $</th>'+
                '<th>More info</th>'+
                '    </tr>';
            for (var i = 0; i < aircrafts.length; i++) {
                var planes = aircrafts[i];
                console.log(planes);
                html = html + '<tr><td><img src="/img/' + planes.img + '" alt="pic" /></td>' +
                    '<td>' + planes.aircraftId + '</td>\n' +
                    '        <td>' + planes.name + '</td>\n' +
                    '        <td>' + planes.manufacture + '</td>\n' +
                    '        <td style="text-transform: capitalize">' + planes.location + '</td>' +
                    '        <td>' + planes.sn + '</td>' +
                    '    <td>' + planes.ttaf + '</td>' +
                    '<td style="text-transform: uppercase">' + planes.reg + '</td>' +
                    '        <td>' + planes.owner.name + " "+planes.owner.surname+ '</td>'+
                    '<td>' + planes.price + '</td>' +
                    '<td> <a href=""> More Info </a> <p> <a href=""> Contact now </a></p>  </td></tr>';
                // '<td> <a href="">Contact now</a> </td></tr>';
            }
            document.getElementById("usersList").innerHTML = html;
        }
    };
    xhttp.open("POST", "http://localhost:8080/api/aircrafts", true);

    xhttp.send(formData);

}

$(function() {
    $("#goButton").click(function(e) {
        e.preventDefault();

        loadAircraft();
    })
});

$(function() {
    $("#fetchAll").click(function(e) {
        e.preventDefault();

        loadAircraft();
    })
});