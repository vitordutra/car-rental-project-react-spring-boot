import React, { useEffect, useState} from "react";
import api from "../../services/api";
import './styles.css';

export default function Modal({id = 'modal' ,onClose = () => { }, children }) { 
    const handleOutsideClick = (e) => {
        if (e.target.id === id) onClose();
    }; 
    const [characteristic, setCharacteristic] = useState([]);

    useEffect(() => {
        callProductDetailsApi();
      }, []);


    async function callProductDetailsApi() {
        try {
          const response = await api.get("/productDetails");
          setCharacteristic(response.data);
        }
        catch (error) {     
        }
    } 
   


    return (
        <>
            <div id={id} className="ProdutoModal" onClick={handleOutsideClick}>
                <div className="container2">
                    <button className="close" onClick={onClose}/>
                    
                    {characteristic.map((caract) => ( 
                        <div className="modalItem">
                            
                            <img className="ImgModal" src={caract.icon_url} />                        
                            <h3 className="H3Modal">{caract.characteristic}</h3>
                        </div>
                    ))}
                    <button className="ButtonModal" >
                        Reserve Agora
                    </button>
                </div>
            </div>
        </>
    );
}