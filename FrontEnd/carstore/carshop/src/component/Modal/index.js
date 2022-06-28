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
        window.addEventListener('resize', handleResize);
        /* window.removeEventListener('resize', handleResize); */
        


      }, []);

      //pegar width
      function getWindowDimensions() {
        const { innerWidth: width, innerHeight: height } = window;
        return {
          width,
          height
        };
      }
      const [windowDimensions, setWindowDimensions] = useState(getWindowDimensions());
      function handleResize() {
        setWindowDimensions(getWindowDimensions());
      }

      



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
                    {caracsInput[0].map(e => <  >
                    <div className="flex-container">
                    <img className="modal-atributo-imagem" key={e.characteristic} src={e.icon_url} width="30px" height={"30px"}></img> 
                    <p className="modal-atributo-texto" >{e.characteristic}</p>
                    </div>
                    </>) }
    
    
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
                    { /* Organização de pc ou pc pequeno : organização de cell */  }
                    
                    <div className="flex-container">
                        <div className="flex-child-calendario">
                        {(windowDimensions.width > 1300)? 2:1}
                            
                            <DateRange 
                                minDate={minDate}
                                maxDate={maxDate}
                                
                                disabledDates={disabledDatesList}
                                editableDateInputs={false}
                                moveRangeOnFirstSelection={false}
                                
                                months={(windowDimensions.width > 1300)? 2:1}
                                direction="horizontal"

                            />
                        </div>
                        <div className="flex-child-resto">
                            <h2>{detalhes.title}</h2>
                            
                            <img className="modal-imagem" src={detalhes.url_imagem} width="50%"  alt="" />
                            <div className="flex-container2">
                            <p className="modal-descricao" >{detalhes.descricao}</p>
                            
                            
                            
                            <div className="listaAtributosBox">{soltarCaracs(listaParaMostrar)}</div>
                            </div>

                            
                            <p>Valor da diária: R${detalhes.valor_diaria},00</p>
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