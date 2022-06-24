import React, { Link, useEffect, useState} from "react";
import api from "../../services/api";
import './styles.css';
import { useNavigate } from 'react-router';
import Details from "../../pages/Details";



const  Modal = ({id = 'modal' , detalhes, onClose}) => { 

    console.log(detalhes);
    

    const handleOutsideClick = (e) => {
        if (e.target.id === id) onClose();
    }; 
    const [characteristic, setCharacteristic] = useState([]);
    const [productDetails, setProductDetails] = useState();

    useEffect(() => {
        callProductDetailsApi();
      }, []);


    async function callProductDetailsApi(id) {
        try {
          const response = await api.get(`/products?${id}`);
          productDetails(response.data);
        }
        catch (error) {     
        }
    } 
   
    const navigate  = useNavigate()
    
    
    const handleBook = () =>{
        
        navigate(`/Reserva/${detalhes.id}/`);
  
  
      }
      

    return (
        <>
            <div id={id} className="ProdutoModal" onClick={handleOutsideClick}>
                <div className="container2">
                    <button className="close" onClick={onClose}/>
                    <h2>{detalhes.title}</h2>
                    <p>{detalhes.descricao}</p>
                    <img src={detalhes.url_imagem} alt="" />
                    {characteristic.map((caract) => ( 
                        <div key={caract.characteristic} className="modalItem">
                            
                            <img className="ImgModal" src={caract.icon_url} />                        
                            <h3 className="H3Modal">{caract.characteristic}</h3>
                        </div>
                    ))}
                    <button onClick={handleBook} className="ButtonModal" >
                    Reserve Agora
                    </button>
                </div>
            </div>
        </>
    );
}

export default Modal;