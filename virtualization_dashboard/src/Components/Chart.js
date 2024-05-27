import React, { useEffect, useState } from "react";
import * as d3 from "d3";
import apiService from "./apiService";

function Chart({ filters }) {
  const [data, setData] = useState([]);

  useEffect(() => {
    apiService
      .fetchData(filters)
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.error("There was an error fetching the data!", error);
      });
  }, [filters]);

  useEffect(() => {
    if (data.length > 0) {
      drawChart();
    }
  }, [data]);

  const drawChart = () => {
    d3.select("#chart").selectAll("*").remove();

    const svg = d3
      .select("#chart")
      .append("svg")
      .attr("width", 800)
      .attr("height", 500)
      .style("margin-left", 100);

    const margin = { top: 20, right: 30, bottom: 40, left: 40 },
      width = +svg.attr("width") - margin.left - margin.right,
      height = +svg.attr("height") - margin.top - margin.bottom,
      g = svg
        .append("g")
        .attr("transform", `translate(${margin.left},${margin.top})`);

    const x0 = d3.scaleBand().rangeRound([0, width]).paddingInner(0.1);

    const x1 = d3.scaleBand().padding(0.05);

    const y = d3.scaleLinear().rangeRound([height, 0]);

    const z = d3.scaleOrdinal().range(["#98abc5", "#8a89a6", "#7b6888"]);

    const keys = ["intensity", "likelihood", "relevance"];

    x0.domain(data.map((d) => d.year));
    x1.domain(keys).rangeRound([0, x0.bandwidth()]);
    y.domain([0, d3.max(data, (d) => d3.max(keys, (key) => d[key]))]).nice();

    g.append("g")
      .selectAll("g")
      .data(data)
      .enter()
      .append("g")
      .attr("transform", (d) => `translate(${x0(d.year)},0)`)
      .selectAll("rect")
      .data((d) => keys.map((key) => ({ key, value: d[key] })))
      .enter()
      .append("rect")
      .attr("x", (d) => x1(d.key))
      .attr("y", (d) => y(d.value))
      .attr("width", x1.bandwidth())
      .attr("height", (d) => height - y(d.value))
      .attr("fill", (d) => z(d.key));

    g.append("g")
      .attr("class", "axis")
      .attr("transform", `translate(0,${height})`)
      .call(d3.axisBottom(x0));

    g.append("g")
      .attr("class", "axis")
      .call(d3.axisLeft(y))
      .append("text")
      .attr("x", 2)
      .attr("y", y(y.ticks().pop()) + 0.5)
      .attr("dy", "0.32em")
      .attr("fill", "#000")
      .attr("font-weight", "bold")
      .attr("text-anchor", "start");
  };

  return (
    <div className="App">
      <div id="chart"></div>
    </div>
  );
}

export default Chart;
