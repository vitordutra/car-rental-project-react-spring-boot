/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable no-unused-vars */
/* eslint-disable react-hooks/exhaustive-deps */
import {useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import api from "../../services/api";
import './styles.css';

export default function CriarReserva() {

    const [produto, setProduto] = useState([]);
    const [cidades, setCidades] = useState([]);
    const [selectedCity, setSelectedCity] = useState("");


    const parametro = useParams();
    useEffect(() => {
        callApiDetails(parametro.idProduto);
        callCidadesApi()
        filterCity(1)
        
        
        
        
        
        
    }, []);    
  

   
    

   

    async function callApiDetails(x) {
        
        try {
          const response = await api.get(`/products/${x}`);
          setProduto(response.data);
        
        }
        catch (error) {      
        }
      } 

      async function callCidadesApi() {
        try {
          const response = await api.get("/cities");
          setCidades(response.data);
        }
        catch (error) { 
    
        }
      }
    
      function filterCity(botaOId){
        try{
        
        const roberto = cidades.filter( e => e.id == botaOId )
        
        return roberto[0].nome
      }catch{}}



    return (
        <>
       
            <div className="flex-container-reserva">
            <div className="bloco-titulo-reserva">
            <h3>Nome do carro escolhido: {produto.title}</h3>
            <h3>Categoria: {produto.qualificacao}</h3>
            </div>

            <div className="bloco-detalhes-reserva">
            <h1>Detalhes da reserva:</h1>
            <img src={produto.url_imagem} width="50%%" />
            <h4>Categoria: {produto.qualificacao}</h4>
            <h4>Nome do Veículo: {produto.title}</h4>
            <h4>Localizacao do produto: {filterCity(produto.cityId)}</h4>
            <h4>Data de Aluguel desejada</h4>
            <button> Reservar</button>
            </div>
            </div>
            <Link to="/Produtos"> <p>voltar aos produtos</p> </Link>
          
            
        </>
    );
}

















/* import api from "../../services/api";
import './styles.css';
import {useEffect, useState } from "react";
import { useParams } from "react-router-dom";


export default function CriarReserva() {






    const params = useParams();






    async function callApiDetails(id) {
        console.log("Calling Api")
        try {
          const response = await api.get(`/products/${id}`);
          console.log(response.data)
          setDetails(response.data);
        
        }
        catch (error) {      
        }
      }
      
    const [details,setDetails] = useState();

    


    useEffect(() => {
        callApiDetails(1);
    }, []); 

          





console.log(details);





return (
    <>
        Você está reservando o carro {params.idProduto}
        
        
        
      
        
    </>
);
} */