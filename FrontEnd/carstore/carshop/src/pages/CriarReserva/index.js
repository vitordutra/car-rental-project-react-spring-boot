/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable no-unused-vars */
/* eslint-disable react-hooks/exhaustive-deps */
import {useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import api from "../../services/api";
import './styles.css';

export default function CriarReserva() {

    const [produto, setProduto] = useState([]);



    const parametro = useParams();
    useEffect(() => {
        callApiDetails(parametro.idProduto);
    }, []);    
  



    
    
    console.log(produto);
   

    async function callApiDetails(x) {
        
        try {
          const response = await api.get(`/products/${x}`);
          setProduto(response.data);
        
        }
        catch (error) {      
        }
      } 
    return (
        <>
            <h1>Detalhes da reserva:</h1>
            <h3>Nome do carro escolhido: {produto.title}</h3>
            <h3>Categoria: {produto.qualificacao}</h3>
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