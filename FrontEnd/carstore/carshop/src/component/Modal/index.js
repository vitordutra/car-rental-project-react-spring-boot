import React, { Link, useEffect, useState} from "react";
import api from "../../services/api";
import './styles.css';
import { useNavigate } from 'react-router';
import Details from "../../pages/Details";
import format from 'date-fns/format';
import parseJSON from 'date-fns/parseJSON'
import { DateRange } from 'react-date-range'



const  Modal = ({id = 'modal' , detalhes, onClose}) => { 

    
    

    const handleOutsideClick = (e) => {
        if (e.target.id === id) onClose();
    }; 
    const [characteristic, setCharacteristic] = useState([]);
    /* const [productDetails, setProductDetails] = useState([]); */
    const [listaParaMostrar, setListaParaMostrar] = useState([]);
    

    useEffect(() => {
        callProductDetailsApi();
        


      }, []);

      

    async function callProductDetailsApi(id) {
        try {
          const response = await api.get(`/productDetails`);
          console.log("productDetails Data")
          console.log(response.data)
          const productDetails = response.data;
          setListaParaMostrar(filterDetails(productDetails));
        }
        catch (error) {     
        }
    } 
   
    const navigate  = useNavigate()
    
    
    const handleBook = () =>{
        
        navigate(`/Reserva/${detalhes.id}/`);
  
  
      }



      
      const filterDetails = (productDetails) =>{
        try{
        
        const listaDeCaracs = []
        const listaDeCaracsFiltrada = []
        /* detalhes.caracteristicas.map(n => listaDeCaracs.push(productDetails.filter( e => e.id == n.id ))) */
        detalhes.caracteristicas.map(n => listaDeCaracs.push(n.id))
        
        console.log(detalhes.caracteristicas)
        console.log("Lista v")
        console.log(listaDeCaracs)
        console.log("Lista productdetails v")
        console.log(productDetails)
        listaDeCaracsFiltrada.push(productDetails.filter( e => listaDeCaracs.includes(e.id)))
        console.log("Lista v2")
        console.log(listaDeCaracsFiltrada)

        

        return listaDeCaracsFiltrada
        
      }catch(error){console.log("ERRORRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
    console.log(error)}}

      try {
        
      } catch (error) {
        
      }


      const soltarCaracs = (caracsInput) =>{
        
        if (!(caracsInput[0] === undefined)){
            return (
                <>
                
                <div>
                    {caracsInput[0].map(e => <><img src={e.icon_url} width="30px" height={"30px"}></img> <p>{e.characteristic}</p></>) }
    
    
                </div>
                
                
                </>
            )
        }


        
        



    }

//Parte do calendario
    console.log("CALENDARIO")
    console.log(detalhes)
    const disabledDatesList=[]
    //TODO: aumentar aumentar 1 dia
    
    detalhes.datas_ocupadas.map(e =>  disabledDatesList.push(new Date(new Date(e.data).getFullYear(),new Date(e.data).getMonth(),new Date(e.data).getDate()+1) ))
    console.log(disabledDatesList)
    const minDate: Date = new Date( new Date().getFullYear(), new Date().getMonth(),new Date().getDate());
    const maxDate: Date = new Date( new Date().getFullYear(), new Date().getMonth()+2,new Date().getDate());

    //PEGAR ISSO DA API v
   /*  const data1 : Date = new Date(2022,6,27);
    const data2 : Date = new Date(2022,6,28);
    const disabledDatesList = [data1,data2]; */
    // /\
      

    return (
        <>
            <div id={id} className="ProdutoModal" onClick={handleOutsideClick}>
                <div className="container2">
                    <button className="close" onClick={onClose}/>
                    <div className="flex-container">
                        <div className="flex-child-calendario">
                            <DateRange 
                                
                                minDate={minDate}
                                maxDate={maxDate}
                                
                                disabledDates={disabledDatesList}
                                editableDateInputs={false}
                                moveRangeOnFirstSelection={false}
                                
                                months={2}
                                direction="horizontal"
                                
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                            />
                        </div>
                        <div className="flex-child-resto">
                    <h2>{detalhes.title}</h2>
                    <p>{detalhes.descricao}</p>
                    <p>Valor da diária: R${detalhes.valor_diaria},00</p>
                    <img src={detalhes.url_imagem} width="20%" height="20%" alt="" />
                    
                    {/* {
                        
                       filterDetails().map(x => <><img src={x[0].icon_url} width="10px" height={"10px"}/> <div>{x[0].characteristic}</div></> )
                    } */}
                    {soltarCaracs(listaParaMostrar)}
                    <button onClick={handleBook} className="ButtonModal" >
                    Reserve Agora
                    </button>
                    </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default Modal;