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