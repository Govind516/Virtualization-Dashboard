import React, { useState } from "react";
import Chart from "./Chart";
import Filter from "./Filter";

function Dashboard() {
  const [filters, setFilters] = useState({});

  const handleFilterChange = (newFilters) => {
    setFilters(newFilters);
  };

  return (
    <div className="dashboard">
      <h1>Data Visualization Dashboard</h1>
      <Filter onFilterChange={handleFilterChange} />
      <Chart filters={filters} />
    </div>
  );
}

export default Dashboard;
