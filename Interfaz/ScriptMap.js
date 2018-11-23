function marcador(lat, lng){
      
    var marker = new google.maps.Marker({
        position: {lat, lng},
        map: map,
    });
    
    var informacion = '<div id="content">'+ '<div id="siteNotice">'+'</div>'+
            '<h1 id="firstHeading" class="firstHeading" style="color:black;>Uluru</h1>'+
            '<div id="bodyContent">'+ '<h5 align=left style="color:black;"> El resultado de los accidentes es: '+
            'aqui va la variable con la cantidad de cosas' + '</h5></div>';
    
    var infowindow = new google.maps.InfoWindow({
          content: informacion
        });
    
    marker.addListener('click', function() {
        infowindow.open(map, marker);
    });

}

function CrearMarcadores(){
    var lat = 9.86444;
    var lng = -83.9194412;
    marcador(lat, lng);
    lat = 9.9907398;
    lng = -83.0359573;
    marcador (lat,lng);
}

function diagramas (){
    var ctx = $("#myChart");
    var myChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
        datasets: [{
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:true
                }
            }]
        }
    }
});
}