import axios from "axios";

const apiService = {
  fetchData: (params) => {
    return axios.get("http://localhost:8080/api/Data", { params });
  },
};

export default apiService;
