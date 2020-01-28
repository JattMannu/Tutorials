console.log("9_Scatter_plot");

function ready9(dataset) {

    const margin = { top: 80, right: 80, bottom: 40, left: 80 }
    const width = 500 - margin.right - margin.left;
    const height = 500 - margin.top - margin.bottom;

    const svg = d3
        .select(".scatter-plot-1 .scatter-plot-container")
        .append('svg')
        .attr('width', width + margin.right + margin.left)
        .attr('height', height + margin.top + margin.bottom)
        .append('g')
        .attr('transform', `translate(${margin.left}, ${margin.top})`)

    const xScale = d3
        .scaleLinear()
        .domain(d3.extent(dataset, d => d.x))
        .range([0, width]);

    const yScale = d3
        .scaleLinear()
        .domain(d3.extent(dataset, d => d.y))
        .range([height, 0]);


    //Draw x axis
    const xAxis = d3
        .axisBottom(xScale)
        .ticks(5)
        .tickFormat(d3.format("$,"))
        .tickSizeInner(-height)
        .tickSizeOuter(0);

    const xAxisDraw = svg
        .append('g')
        .attr('class', 'x axis')
        .attr('transform', `translate(0, ${height})`)
        .call(xAxis)
        .call(addLabel, "Budget", 15);

    xAxisDraw
        .selectAll("text")
        .attr('dy', '1em')

    // Draw Y Axis
    const yAxis = d3
        .axisLeft(yScale)
        .ticks(5)
        .tickFormat(d3.format("$,"))
        .tickSizeInner(-width)
        .tickSizeOuter(0);

    const yAxisDraw = svg
        .append('g')
        .attr('class', 'y axis')
        .call(yAxis)
        .call(addLabel, 'Revenue', 5);

    svg
        .append('g')
        .attr('class', 'scatter-points')
        .selectAll(".scatter")
        .data(dataset)
        .enter()
        .append("circle")
        .attr('class', 'scatter')
        .attr('cx', d => xScale(d.x))
        .attr('cy', d => yScale(d.y))
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


d3.json("./data/xy.json", function (err, data) {
    if (err) {
        console.log(err);
    } else {
        console.log(data)
    }
    ready9(data);
})