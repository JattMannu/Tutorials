
var margin = {
    top: 36,
    right: 50,
    bottom: 20,
    left: 50
};
var width = 240 - margin.left - margin.right;
var height = 240 - margin.top - margin.bottom;
var labelMargin = 8;

var scale = d3.scale.linear()
    .domain([0, 4])
    .range([0, 100])

d3.csv('./data/whiskies.csv')
    .row(function (d) {
        d.Body = +d.Body;
        d.Sweetness = +d.Sweetness;
        d.Smoky = +d.Smoky;
        d.Medicinal = +d.Medicinal;
        d.Tobacco = +d.Tobacco;
        d.Honey = +d.Honey;
        d.Spicy = +d.Spicy;
        d.Winey = +d.Winey;
        d.Nutty = +d.Nutty;
        d.Malty = +d.Malty;
        d.Fruity = +d.Fruity;
        d.Floral = +d.Floral;
        return d;
    })
    .get(function (error, rows) {
        var star = d3.starPlot()
            .width(width)
            .accessors([
                function (d) { return scale(d.Body); },
                function (d) { return scale(d.Sweetness); },
                function (d) { return scale(d.Smoky); },
                function (d) { return scale(d.Honey); },
                function (d) { return scale(d.Spicy); },
                function (d) { return scale(d.Nutty); },
                function (d) { return scale(d.Malty); },
                function (d) { return scale(d.Fruity); },
                function (d) { return scale(d.Floral); },
            ])
            .labels([
                'Body',
                'Sweetness',
                'Smoky',
                'Honey',
                'Spicy',
                'Nutty',
                'Malty',
                'Fruity',
                'Floral',
            ])
            .title(function (d) { return d.Distillery; })
            .margin(margin)
            .labelMargin(labelMargin)

        rows.forEach(function (d, i) {
            star.includeLabels(i % 4 === 0 ? true : false);

            d3.select('#target').append('svg')
                .attr('class', 'chart')
                .attr('width', width + margin.left + margin.right)
                .attr('height', width + margin.top + margin.bottom)
                .append('g')
                .datum(d)
                .call(star)
        });
    });





d3.starPlot = function() {
    var width = 200,
        margin = {
          top: 0,
          right: 0,
          bottom: 0,
          left: 0
        },
        labelMargin = 20,
        includeGuidelines = true,
        includeLabels = true,
        accessors = [],
        labels = [],
        title = nop,
  
        g,
        datum,
        radius = width / 2,
        origin = [radius, radius],
        radii = accessors.length,
        radians = 2 * Math.PI / radii,
        scale = d3.scale.linear()
          .domain([0, 100])
          .range([0, radius])
  
    function chart(selection) {
      datum = selection.datum();
      g = selection
        .attr('transform', 'translate(' + margin.left + ',' + margin.top + ')')
  
      if (includeGuidelines) {
        drawGuidelines();
      }
      if (includeLabels) {
        drawLabels();
      }
  
      drawChart();
    }
  
    function drawGuidelines() {
      var r = 0;
      accessors.forEach(function(d, i) {
        var l, x, y;
  
        l = radius;
        x = l * Math.cos(r);
        y = l * Math.sin(r);
        g.append('line')
          .attr('class', 'star-axis')
          .attr('x1', origin[0])
          .attr('y1', origin[1])
          .attr('x2', origin[0] + x)
          .attr('y2', origin[1] + y)
  
        r += radians;
      })
    }
  
    function drawLabels() {
      var r = 0;
      accessors.forEach(function(d, i) {
        var l, x, y;
  
        l = radius;
        x = (l + labelMargin) * Math.cos(r);
        y = (l + labelMargin) * Math.sin(r);
        g.append('text')
          .attr('class', 'star-label')
          .attr('x', origin[0] + x)
          .attr('y', origin[1] + y)
          .text(labels[i])
          .style('text-anchor', 'middle')
          .style('dominant-baseline', 'central')
  
        r += radians;
      })
    }
  
    function drawChart() {
      g.append('circle')
        .attr('class', 'star-origin')
        .attr('cx', origin[0])
        .attr('cy', origin[1])
        .attr('r', 2)
  
      var path = d3.svg.line.radial()
  
      var pathData = [];
      var r = Math.PI / 2;
      accessors.forEach(function(d) {
        pathData.push([
          scale(d(datum)),
          r
        ])
        r += radians;
      });
  
      g.append('path')
        .attr('class', 'star-path')
        .attr('transform', 'translate(' + origin[0] + ',' + origin[1] + ')')
        .attr('d', path(pathData) + 'Z');
  
      g.append('text')
        .attr('class', 'star-title')
        .attr('x', origin[0])
        .attr('y', -(margin.top / 2))
        .text(title(datum))
        .style('text-anchor', 'middle')
    }
  
    function nop() {
      return;
    }
  
    chart.accessors = function(_) {
      if (!arguments.length) return accessors;
      accessors = _;
      radii = accessors.length;
      radians = 2 * Math.PI / radii;
      return chart;
    };
  
    chart.width = function(_) {
      if (!arguments.length) return width;
      width = _;
      radius = width / 2;
      origin = [radius, radius];
      scale.range([0, radius])
      return chart;
    };
  
    chart.margin = function(_) {
      if (!arguments.length) return margin;
      margin = _;
      origin = [radius, radius];
      return chart;
    };
  
    chart.labelMargin = function(_) {
      if (!arguments.length) return labelMargin;
      labelMargin = _;
      return chart;
    };
  
    chart.title = function(_) {
      if (!arguments.length) return title;
      title = _;
      return chart;
    };
  
    chart.labels = function(_) {
      if (!arguments.length) return labels;
      labels = _;
      return chart;
    };
  
    chart.includeGuidelines = function(_) {
      if (!arguments.length) return includeGuidelines;
      includeGuidelines = _;
      return chart;
    };
  
    chart.includeLabels = function(_) {
      if (!arguments.length) return includeLabels;
      includeLabels = _;
      return chart;
    };
  
    return chart;
  }