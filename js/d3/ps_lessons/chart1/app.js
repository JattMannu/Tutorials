
var fontSize = 13;

function zoomed() {
    t = d3
        .event
        .transform

    //    if(t.k <= 1 || t.k > 13){
    //        return;
    //    } 

    countriesGroup
        .attr("transform", "translate(" + [t.x, t.y] + ")scale(" + t.k + ")");

    countryLabels
        .style("font-size", fontSize - t.k);

}

d3.json(
    "./data/50.geo.json",
    function (json) {
        d3.csv("./data/wuhan.csv", function (error, wuhan) {
            var dims = {
                width: $("#map-holder").width(),
                height: 500,
                svg_dx: 100,
                svg_dy: 100
            };

            var projection = d3
                .geoEquirectangular();

            var path = d3
                .geoPath()
                .projection(projection);

            var zoom = d3.zoom()
                .extent([[dims.svg_dx, dims.svg_dy], [dims.width - (dims.svg_dx * 2), dims.height - dims.svg_dy]])
                .scaleExtent([1, 10])
                .translateExtent([[dims.svg_dx, dims.svg_dy], [dims.width - (dims.svg_dx * 2), dims.height - dims.svg_dy]])
                .on('zoom', zoomed);

                d3
                .select("#map-holder")
                .append("h3")
                .text("Countries affected by Wuhan virus")
                .attr("width", "100%")
                
            var svg = d3
                .select("#map-holder")
                .append("svg")
                .attr("width", dims.width)
                .attr("height", dims.height)
                .call(zoom);

            let infectedCountries = wuhan.map(e => e.Country)

            countriesGroup = svg.append("g").attr("id", "map");

            countries = countriesGroup
                .selectAll("path")
                .data(json.features)
                .enter()
                .append("path")
                .attr("d", path)
                .attr("id", function (d, i) {
                    return "country" + d.properties.iso_a3;
                })
                .attr("class", "country")
                .style("fill", (d) => {
                    if (infectedCountries.includes(d.properties.name)) {
                        return 'rgb(255, 100, 100)';
                    }
                    return "rgb(168, 168, 168)"
                })
                .on("mouseover", function (d) {
                    //console.log("just had a mouseover", d.properties.name , wuhan)

                })
                .on("mouseout", function (d) {
                    // console.log("just had a mouseout", d.properties.name,infectedCountries)
                })

            countryLabels = countriesGroup
                .selectAll("g")
                .data(json.features)
                .enter()
                .append("g")
                .attr("class", "countryLabel")
                .attr("id", function (d) {
                    return "countryLabel" + d.properties.iso_a3;
                })
                .attr("transform", function (d) {
                    return (
                        "translate(" + path.centroid(d)[0] + "," + path.centroid(d)[1] + ")"
                    );
                })
                .style("display", "block")
                .style("font-size", fontSize)
                .style("color", "black")
                .style("display", (d) => {
                    if (infectedCountries.includes(d.properties.name)) {
                        return 'block';
                    }
                    return 'none';
                })



            countryLabels
                .append("text")
                .attr("class", "countryName")
                .style("text-anchor", "middle")
                .attr("dx", 0)
                .attr("dy", 0)
                .text(function (d) {
                    return d.properties.name;
                })
                .style("fill", "#000")

        }
        );

    }
);
