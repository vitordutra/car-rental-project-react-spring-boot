import { useEffect, useState, useRef } from 'react'
import './styles.css';
import format from 'date-fns/format';
import api from "../../../services/api";
import DateRangeComp from '../../Calendar/DateRangeComp';
import { DateRange } from 'react-date-range';

import { addDays } from 'date-fns'

import 'react-date-range/dist/styles.css'
import 'react-date-range/dist/theme/default.css'
import { useNavigate } from 'react-router';

const BlocoPesquisa = ({handleFilter}) => {

    const [cidade, setCidade] = useState("");


     
/*   useEffect(() => {
    callCidadesApi(); 
  }, []);
    
    
  async function callCidadesApi() {
    try {
      const response = await api.get("/cities");
      setCidade(response.data);
    }
    catch (error) { 

    }
    
    } */
    
    async function callProductByCity(id) {
        try {
          const response = await api.get(`products?cityId=${id}`);
          handleFilter(response.data);
        }
        catch (error) { 
      
        }
      }

    //Parte do calendário ###############################################################################################################
    const refOne = useRef(null)
/* 
    async function callApiProductsDateRange(range, cidadeEscolhida) {

        try {
            const DataDeInicio = format(range[0].startDate, "MM-dd-yyyy")
            const DataDeTermino = format(range[0].endDate, "MM-dd-yyyy")
            const cidade = cidadeEscolhida;
            console.log(DataDeInicio);
            console.log(DataDeTermino);
            const URL = `products?cityId=${cidade}&data_inicial=${DataDeInicio}&data_final=${DataDeTermino}`;
            // console.log(URL);
            const response = await api.get(URL);
            console.log(response);
            // handleFilter(response.data);


        }
        catch (error) {
            console.log(error)
        }
    } */


    useEffect(() => {
      // event listeners
      document.addEventListener("keydown", hideOnEscape, true)
      
    }, [])
  
    // hide dropdown on ESC press
    const hideOnEscape = (e) => {
      // console.log(e.key)
      if( e.key === "Escape" ) {
        setOpen(false)
      }
    }
  




    
    const [range, setRange] = useState([
      {
        startDate:  new Date(),
        endDate: addDays(new Date(), 1),
        key: 'selection'
      }
    ])
    const [open, setOpen] = useState(false)

    const navigate  = useNavigate()
    const handleSearch = () =>{
      /* navigate("/Produtos",{state: {range,cidade}}); */
      navigate(`/Produtos/${cidade}/${format(range[0].startDate, "MM-dd-yyyy")}/${format(range[0].endDate, "MM-dd-yyyy")}`);


    }

    



        return (
            <>  
            <div>
                <div className="pesquisa-primeira-fileira">
                        <div className="pesquisa-itens-duplos">
                        {/* <select className="select" name="cidade"  onChange={item => callProductByCity(item.target.value)}>
              <option  value="">Escolha a cidade</option>
              {cidade.map((item) => (
              <option value={item.id}>{item.nome}</option>
              ))}
            </select> */}
                          <input
                            placeholder="Digite o local de retirada"
                            type="text"
                            id="pesquisa-retirar-local"
                            name="pesquisa-retirar-local"
                            className="pesquisa-inputs"
                            onChange={item =>setCidade(item.target.value) }
                           /> 
                    </div>
                    <div className="pesquisa-itens-duplos">
                    <input
                        value={`${format(range[0].startDate, "dd/MM/yyyy")} to ${format(range[0].endDate, "dd/MM/yyyy")}`}
                        
                        readOnly
                        className="inputBox"
                        onClick={ () => setOpen(open => !open) }
                   />

                    {open && <DateRange 
                        
                        onChange={item => setRange([item.selection])}
                        editableDateInputs={true} 
                        moveRangeOnFirstSelection={false}
                        ranges={range}
                        className="date"                            
                        />}

                    </div>


                    <input type="button" onClick={handleSearch} id="pesquisa-botao-buscar" name="pesquisa-botao-buscar" value="Buscar" /> 
                </div>
            </div>
        </>

    )




}

export default BlocoPesquisa;