console.log("10_SteamData");

function ready10(dataset) {

    const margin = { top: 80, right: 80, bottom: 40, left: 200 }
    const width = 1000 - margin.right - margin.left;
    const height = 1000 - margin.top - margin.bottom;

    dataset.sort(function(a, b){
    return (b.positive-b.negative)-(a.positive-a.negative);
});

    const svg = d3
        .select(".scatter-plot-2 .scatter-plot-container")
        .append('svg')
        .attr('width', width + margin.right + margin.left)
        .attr('height', height + margin.top + margin.bottom)
        .append('g')
        .attr('transform', `translate(${margin.left}, ${margin.top})`)

    const xScale = d3
        .scaleSqrt()
        .domain([
                    d3.min(dataset, d => d.negative * 1),
                    d3.max(dataset, d => d.positive * 1)
                ])
        .range([0, width]);

    const yScale = d3
        .scaleOrdinal()
        .domain(dataset.map( d => d.name))
        .range([height, 0]);

    var yTicks = d3.scalePoint()
			.domain(dataset.map( d => d.name))
			.range([0, height])

    //Draw x axis
    const xAxis = d3
        .axisBottom(xScale)
        //.ticks(5)
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
        //.call(addLabel, 'Game ID', 5);

    svg
        .append('g')
        .attr('class', 'scatter-points')
        .selectAll(".scatter")
        .data(dataset)
        .enter()
        .append("circle")
        .attr('class', 'scatter negative')
        .attr('cx', d => xScale(d.negative))
        .attr('cy', d => yTicks(d.name))
        .attr('r', 3)
        .attr('fill', 'red')
        .attr('fill-opacity', 0.7)

     svg
        .append('g')
        .attr('class', 'scatter-points')
        .selectAll(".scatter")
        .data(dataset)
        .enter()
        .append("circle")
        .attr('class', 'scatter positive')
        .attr('cx', d => xScale(d.positive))
        .attr('cy', d => yTicks(d.name))
        .attr('r', 3)
        .attr('fill', 'dodgerblue')
        .attr('fill-opacity', 0.7)


    const header = svg
        .append('g')
        .attr('class', 'header')
        .attr('transform', `translate(0,${-margin.top * 0.6})`)
        .append('text');
    
    header
    .append('tspan')
    .text("Budget vs. Revenue in $US");

    header
    .append('tspan')
    .attr('x',0)
    .attr('dy' , '1.5em')
    .style('fill', "#555")
    .text('Top Random Dots by Budget')

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
        if(d.publisher == "Valve")
            datatemp.push(d);
        //console.log(d.positive - d.negative)
    }
    console.log(datatemp[0]);
    //ready10(datatemp.slice(0,10));
    ready10(datatemp);
})