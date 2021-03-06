var listaProvincias =["Limons", "Cartago", "San Jose", "Guanacaste", "Alajuela", "Heredia", "Puntarenas"];
var listaDistrito =["Siquirres", "Limón", "Occidente","HoneCreek", "Talamanca", "Cairo"];
var listaCanton=["Cocal", "Parismina", "Colon", "Siquirres", "Limon", "Guapiles", "Pococi"];
var listaLesion=["Herida grave", "Herida leve", "Contución"];
var listaEdad=["25-30", "30-35","35-40"];
var listaAnno=["2012", "2013", "2014", "2015"];

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

function crearListaProvincia(){
    var temp;
    for(let i = 0; i < listaProvincias.length; i++){
        temp = $("#provi1");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaProvincias[i]+ '</a>');
        temp = $("#provi2");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaProvincias[i]+ '</a>');
        temp = $("#provi3");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaProvincias[i]+ '</a>');
    }
}

function crearListaCanton(){
    var temp
    for(let i = 0; i < listaCanton.length; i++){
        temp = $("#can1");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaCanton[i]+ '</a>');
        temp = $("#can2");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaCanton[i]+ '</a>');
        temp = $("#can3");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaCanton[i]+ '</a>');
    }
}

function crearListaDistrito(){
    var temp;
    for(let i = 0; i < listaDistrito.length; i++){
        temp = $("#dis1");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaDistrito[i]+ '</a>');
        temp = $("#dis2");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaDistrito[i]+ '</a>');
        temp = $("#dis3");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaDistrito[i]+ '</a>');
    }
}

function crearListasLesiones(){
    var temp;
    for(let i = 0; i < listaLesion.length; i++){
        temp = $("#le1");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaLesion[i]+ '</a>');
        temp = $("#le2");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaLesion[i]+ '</a>');
        temp = $("#le3");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaLesion[i]+ '</a>');
    }
}

function crearListaEdades(){
    var temp;
    for(let i = 0; i < listaEdad.length; i++){
        temp = $("#edad1");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaEdad[i]+ '</a>');
        temp = $("#edad2");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaEdad[i]+ '</a>');
        temp = $("#edad3");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaEdad[i]+ '</a>');
    }
}

function crearListaAn(){
    var temp;
    for(let i = 0; i < listaAnno.length; i++){
        temp = $("#an1");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaAnno[i]+ '</a>');
        temp = $("#an2");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaAnno[i]+ '</a>');
        temp = $("#an3");
        temp.prepend('<a href="#" class="list-group-item list-group-item-action">' +listaAnno[i]+ '</a>');
    }
}


function mainCargador(){
    crearListaProvincia();
    crearListaCanton();
    crearListaDistrito();
    crearListasLesiones();
    crearListaEdades();
    crearListaAn();
}