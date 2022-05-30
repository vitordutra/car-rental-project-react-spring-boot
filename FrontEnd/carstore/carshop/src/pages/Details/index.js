/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable no-unused-vars */
/* eslint-disable react-hooks/exhaustive-deps */
import {useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../../services/api";
import './styles.css';

export default function Details() {

    const [product, setProduct] = useState([]);
    useEffect(() => {
        callApiDetails();
    }, []);    
  
    const parametro = useParams();
    console.log(parametro.id);
   

    async function callApiDetails() {
        
        try {
          const response = await api.get(`/products/${parametro.id}`);
            setProduct(response.data);
        
        }
        catch (error) {      
        }
      } 
    return (
        <>
            
            <img src={product.url_imagem} />
            <h1>{product.title}</h1>
            <p>{product.descricao}</p>
            <h2>{product.localizacao}</h2>
            
        </>
    );
}
