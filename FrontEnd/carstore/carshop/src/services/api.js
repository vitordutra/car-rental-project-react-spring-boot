import axios from "axios";

const api = axios.create({
  //baseURL: "https://my-json-server.typicode.com/rows15/db-projetointegrador/",
  
  baseURL: "http://localhost:8080/",
  headers: {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Method": "*",
    "Access-Control-Allow-Headers": "*",
    "Access-Control-Allow-Credentials": true
  }

});

export default api;
