console.log("10_SteamData");

function ready10(dataset) {

    const margin = { top: 80, right: 80, bottom: 40, left: 200 }
    const width = 1000 - margin.right - margin.left;
    const height = 1000 - margin.top - margin.bottom;

    dataset.sort(function (a, b) {
        return (b.positive - b.negative) - (a.positive - a.negative);
    });

    const svg = d3
        .select(".scatter-plot-2 .scatter-plot-container")
        .append('svg')
        .attr('width', width + margin.right + margin.left)
        .attr('height', height + margin.top + margin.bottom)
        .append('g')
        .attr('transform', `translate(${margin.left}, ${margin.top})`)

    const xScale = d3
        .scaleLog()
        .domain([
            d3.min(dataset, d => d.negative * 1),
            d3.max(dataset, d => d.positive * 1)
        ])
        .range([0, width]);

    const yScale = d3
        .scaleOrdinal()
        .domain(dataset.map(d => d.name))
        .range([height, 0]);

    var yTicks = d3.scalePoint()
        .domain(dataset.map(d => d.name))
        .range([0, height])

    //Draw x axis
    const xAxis = d3
        .axisBottom(xScale)
        .ticks(4)
        .tickFormat(d3.format(","))
        //.tickSizeInner(-height)
        .tickSizeOuter(0);

    const xAxisDraw = svg
        .append('g')
        .attr('class', 'x axis')
        .attr('transform', `translate(0, ${height})`)
        .call(xAxis)
        .call(addLabel, "Reviews", 45);

    xAxisDraw
        .selectAll("text")
        .attr('dy', '1em')

    // Draw Y Axis
    const yAxis = d3
        .axisLeft(yScale)
    //.ticks(5)
    //.tickSizeInner(-width)
    //.tickSizeOuter(0);

    var yAxisLeft = d3.axisLeft().scale(yTicks);
    const yAxisDraw = svg
        .append('g')
        .attr('class', 'y axis')
        .call(yAxisLeft)
    //   .on("mouseover", (d, i) => console.log(i))
    // .on("mouseout", (d, i) => console.log(d));
    //.call(addLabel, 'Game ID', 5);


    svg.selectAll(".y.axis .tick")
        .on("mouseover", (d, i) => {
            svg.selectAll(".scatter.idx-" + i)
                .attr('r', 4)

            // svg.selectAll(".scatter.idx-" + i + " .tooltip")
            //     .transition()		
            //     .duration(200)		
            //     .style("opacity", .9);		
            //     svg.selectAll(".scatter.idx-" + i + " .tooltip")
            //     .html(d + "<br/>"  + d.close)	
            //     .style("left", (d3.event.pageX) + "px")		
            //     .style("top", (d3.event.pageY - 28) + "px");	
            //   console.log(d3.event.pageX)
            //     div.transition()		
            //     .duration(200)		
            //     .style("opacity", .9);		
            // div	.html(d + "<br/>"  + d.close)	
            //     .style("left", (d3.event.pageX) + "px")		
            //     .style("top", (d3.event.pageY - 28) + "px");	
        })
        .on("mouseout", (d, i) => {
            svg.selectAll(".scatter.idx-" + i)
                .attr('fill-opacity', 1)
                .attr('r', 3)
        });

    var lineFunction = d3.line()
        .x(function (d) { return d.x; })
        .y(function (d) { return d.y; });

    svg
        .append('g')
        .attr('class', 'scatter-points')
        .selectAll(".scatter")
        .data(dataset)
        .enter()
        .append("circle")
        .attr('class', (d, i) => "idx-" + i + ' scatter negative')
        .attr('cx', d => xScale(d.negative))
        .attr('cy', d => yTicks(d.name))
        .attr('r', 3)
        .attr('fill', 'red')
        .attr('fill-opacity', 0.7)
        .attr('data-selector', d => d.negative)
    // .append("span")
    // .text(d => d.negative)
    // .attr("class", "popuptext show")
    // .attr("id", "myPopup")


    // <span class="popuptext show" id="myPopup">A Simple Popup!</span>
    svg
        .append('g')
        .attr('class', 'scatter-points')
        .selectAll(".scatter")
        .data(dataset)
        .enter()
        .append("circle")
        .attr('class', (d, i) => "idx-" + i + ' scatter positive')
        .attr('cx', d => xScale(d.positive))
        .attr('cy', d => yTicks(d.name))
        .attr('r', 3)
        .attr('fill', 'dodgerblue')
        .attr('fill-opacity', 0.7)
        .attr('data-selector', d => d.positive)
    // .append("span")
    // .text(d => d.positive)
    // .attr("class", "popuptext show")
    // .attr("id", "myPopup")

    // svg
    //     .append('g')
    //     .attr('class', 'connecting-path')
    //     .append("path")
    //     .attr("d", 'M 270.1145449219001 0 L 720 0')
    //     .attr("stroke", "blue")
    //     .attr("stroke-width", 0.5)
    //     .attr("fill", "none")
    //     .attr('fill-opacity', 0.7)

    document.querySelectorAll('.scatter-plot-2 .scatter.negative').forEach((e, i) => {

        const p = document.querySelector(".idx-" + i + '.scatter.positive');
        const n = document.querySelector("idx-" + i + ' scatter negative');

        svg
            .append('g')
            .attr('class', 'connecting-path')
            .append("path")
            .attr("id", "connecting-path-"+i) //Unique id of the path
            .attr("d", `M ${e.getAttribute('cx')} ${e.getAttribute('cy')} L ${p.getAttribute('cx')} ${p.getAttribute('cy')}`)
            .attr("stroke", "black")
            .attr("stroke-width", 0.5)
            .attr("fill", "none")
            .attr('fill-opacity', 0.7)

        svg
            .append('g')
            .attr('class', 'connecting-path')
            .append("text")
            .attr('transform' , "translate(0,-2)")
            .append("textPath") //append a textPath to the text element
            .attr("xlink:href", "#connecting-path-"+i) //place the ID of the path here
            .style("text-anchor", "middle") //place the text halfway on the arc
            .attr("startOffset", "50%")
            .text(p.getAttribute('data-selector') - e.getAttribute('data-selector'));
            
            
    });

    // Define the div for the tooltip
    var div = d3.select("body").append("div")
        .attr("class", "tooltip")
        .style("opacity", 0);


    const header = svg
        .append('g')
        .attr('class', 'header')
        .attr('transform', `translate(0,${-margin.top * 0.6})`)
        .append('text');

    header
        .append('tspan')
        .text("Postive vs. Negative reviews");

    header
        .append('tspan')
        .attr('x', 0)
        .attr('dy', '1.5em')
        .style('fill', "#555")
        .text('Compares the reviews of games published by Valve.')


    // //Create the SVG
    // var svg1 = d3.select("body").append("svg")
    //     .attr("width", 400)
    //     .attr("height", 120);

    // //Create an SVG path (based on bl.ocks.org/mbostock/2565344)
    // svg1.append("path")
    //     .attr("id", "wavy") //Unique id of the path
    //     .attr("d", "M 10,90 Q 100,15 200,70 Q 340,140 400,30") //SVG path
    //     .style("fill", "none")
    //     .style("stroke", "#AAAAAA");

    // //Create an SVG text element and append a textPath element
    // svg1.append("text")
    //     .append("textPath") //append a textPath to the text element
    //     .attr("xlink:href", "#wavy") //place the ID of the path here
    //     .style("text-anchor", "middle") //place the text halfway on the arc
    //     .attr("startOffset", "50%")
    //     .text("Yay, my text is on a wavy path");
}

function addLabel(axis, label, x) {
    axis
        .selectAll('.tick:last-of-type text')
        .clone()
        .attr('class', 'label')
        .text(label)
        .attr('x', x)
}


d3.json("./data/steamall.json", function (err, data) {
    if (err) {
        console.log(err);
    } else {
        console.log(data)
    }
    datatemp = []
    for (const [key, d] of Object.entries(data)) {
        //console.log(value);
        if (d.publisher == "Valve" && d.name != "Artifact")
            datatemp.push(d);
        //console.log(d.positive - d.negative)
    }
    console.log(datatemp[0]);
    //ready10(datatemp.slice(0,10));
    ready10(datatemp);
})