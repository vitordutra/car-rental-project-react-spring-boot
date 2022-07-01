import axios from "axios";

const api = axios.create({
  //baseURL: "https://my-json-server.typicode.com/rows15/db-projetointegrador/",
  
    baseURL: "http://localhost:8080/",
  headers: {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Method": "*",
    "Access-Control-Allow-Headers": "*",
    "Access-Control-Allow-Credentials": true,
    "Access-Control-Expose-Headers": "Content-Range",
    "Access-Control-Expose-Headers": "X-Custom-Header",
  }

});

const signed = JSON.parse(localStorage.getItem('signed'));

if (signed) {
  const tokenJwt = signed.token.jwt;
  
  api.defaults.headers.common["Authorization"] = `Bearer ${tokenJwt}`;
}

export default api;
