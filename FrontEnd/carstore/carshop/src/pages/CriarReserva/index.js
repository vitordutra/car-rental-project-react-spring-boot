/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable no-unused-vars */
/* eslint-disable react-hooks/exhaustive-deps */
import {useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import api from "../../services/api";
import './styles.css';
import { DateRange } from 'react-date-range';
import { addDays, set } from 'date-fns'
import format from 'date-fns/format';

export default function CriarReserva() {

    const [produto, setProduto] = useState([]);
    const [cidades, setCidades] = useState([]);
    const [selectedCity, setSelectedCity] = useState("");
    const [userr,setUserr] = useState()

    const parametro = useParams();
    useEffect(() => {
        callApiDetails(parametro.idProduto);
        callCidadesApi()
        filterCity(1)
        setUserr(estaLogado())
        window.addEventListener('resize', handleResize);
        
        
        
        
        
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
        
        const roberto = cidades.filter( e => e.id === botaOId )
        
        return roberto[0].nome
      }catch{}}


      //PARTE DO CALENDARIO
        const diffDays = (date, otherDate) => Math.ceil(Math.abs(date - otherDate) / (1000 * 60 * 60 * 24)+1);

        const minDate = new Date( new Date().getFullYear(), new Date().getMonth(),new Date().getDate());
        const maxDate = new Date( new Date().getFullYear(), new Date().getMonth()+2,new Date().getDate());
        
        const [range, setRange] = useState([
        {
          startDate:  new Date(),
          endDate: addDays(new Date(), 1),
          key: 'selection'
        }
      ])
      //PEGAR ISSO DA API v
        const data1 : Date = new Date(2022,6,27);
        const data2 : Date = new Date(2022,6,28);
        const disabledDatesList=[]
        try {
          console.log(produto.datas_ocupadas)
          produto.datas_ocupadas.map(e =>  disabledDatesList.push(new Date(new Date(e.data).getFullYear(),new Date(e.data).getMonth(),new Date(e.data).getDate()+1) ))
        } catch (error) {
          
        }
        console.log("CALENDARIO")
        
        /* console.log(produto.datas_ocupadas) */
        
        //TODO: aumentar aumentar 1 dia
        
        
        console.log(disabledDatesList)
        // /\

        function estaLogado() {
          try {
            let user = JSON.parse(localStorage.getItem("user"));
            return user
      
          } catch (error) {
            
            return false
          }
        }

        const dadosPessoa = () => {
          try {
              return(
                <>
                
                
              <p>Nome: <input type="text" disabled="true" value={(userr.name+" "+userr.surname)} /> </p>
              <p>email: <input type="text" disabled="true" value={userr.email}/></p>
              <p>Data de Início:: <input type="text" disabled="true" value={format(range[0].startDate, "dd/MM/yyyy")}/></p>
              <p>Data de Devolução: <input type="text" disabled="true" value={format(range[0].endDate, "dd/MM/yyyy")}/></p>
              <p>Diárias:<input type="text" disabled="true" value={diffDays(range[0].startDate,range[0].endDate)}/></p>
              <p>Valor Total:</p>
              <p>R$ {produto.valor_diaria*diffDays(range[0].startDate,range[0].endDate)},00</p>
                
                
                </>
              )
          } catch (error) {
            
          }

        }

    return (
        <>
       
            <div className="flex-container-reserva">
              <div className="bloco-titulo-reserva">
                <h3>Nome do carro escolhido: {produto.title} / Categoria: {produto.qualificacao}</h3>
                
              </div>
              <h1>Confirme sua reserva:</h1>

            <div className="bloco-detalhes-reserva">
                <br />
                <h4 className="reserva-titulo-carro" >{produto.title}</h4>
                <div className="flex-container-reserva1">
                  <img className="imagem-reserva" src={produto.url_imagem} width="50%" />
                  <div className="detalhes-reserva-1">
                    <h4>Categoria: {produto.qualificacao}</h4>
                    <h4>Caracteristicas: {produto.title}</h4>
                    <h4>Localização do produto: {filterCity(produto.cityId)}</h4>
                    
                  </div>
                </div>
                <div className="flex-container-reserva2">
                  <div className="reserva-dados-pessoa">
                    {dadosPessoa()}
                  </div>
                
                  <DateRange 
                  
                  onChange={item => setRange([item.selection])}
                  minDate={minDate}
                  maxDate={maxDate} 
                  editableDateInputs={true} 
                  moveRangeOnFirstSelection={false}
                  ranges={range}
                  months={2}
                  disabledDates={disabledDatesList}
                  direction="horizontal"
                  className="date"                            
                  />
              
              </div>

                  
                  
                  
                            <Link to="/Sucesso"> <button className="button-reserva"> Reservar</button> </Link>
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