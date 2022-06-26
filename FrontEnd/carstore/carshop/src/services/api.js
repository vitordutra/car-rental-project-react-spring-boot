import axios from "axios";

const api = axios.create({
  baseURL: "https://my-json-server.typicode.com/rows15/db-projetointegrador/",
});

export default api;