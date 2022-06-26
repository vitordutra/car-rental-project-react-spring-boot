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
        
        const roberto = cidades.filter( e => e.id === botaOId )
        
        return roberto[0].nome
      }catch{}}


      //PARTE DO CALENDARIO
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
                
                <p>Seus Dados: </p>
              <p>Nome:{userr.name} {userr.surname}</p>
              <p>email:{userr.email}</p>
                
                
                </>
              )
          } catch (error) {
            
          }

        }

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
            <h4>Caracteristicas: {produto.title}</h4>
            <h4>Localização do produto: {filterCity(produto.cityId)}</h4>
            <h4>Data de Aluguel desejada: {format(range[0].startDate, "dd/MM/yyyy")} até {format(range[0].endDate, "dd/MM/yyyy")}
            <br></br>
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
                        /></h4>
          {dadosPessoa()}


              
              
              
           <Link to="/Sucesso"> <button> Reservar</button> </Link>
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