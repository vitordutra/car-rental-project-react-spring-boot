import { useEffect, useState } from 'react'
import './styles.css';
import format from 'date-fns/format';
import { Link } from 'react-router-dom'
import api from "../../../services/api";
import DateRangeComp from '../../Calendar/DateRangeComp';

const BlocoPesquisa = ({handleFilter}) => {

    const [cidade, setCidade] = useState([]);


     
  useEffect(() => {
    callCidadesApi(); 
  }, []);
    
    
  async function callCidadesApi() {
    try {
      const response = await api.get("/cities");
      setCidade(response.data);
    }
    catch (error) { 

    }
    }
    
    async function callProductByCity(id) {
        try {
          const response = await api.get(`products?cityId=${id}`);
          handleFilter(response.data);
        }
        catch (error) { 
      
        }
      }


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
    }



        return (
            <>  
            <div>
                <div className="pesquisa-primeira-fileira">
                        <div className="pesquisa-itens-duplos">
                        <select className="select-BlocoPesquisa" name="cidade"  onChange={item => callProductByCity(item.target.value)}>
              <option  value="">Escolha a cidade</option>
              {cidade.map((item) => (
              <option value={item.id}>{item.nome}</option>
              ))}
            </select>
                        {/* <input
                            placeholder="Digite o local de retirada"
                            type="text"
                            id="pesquisa-retirar-local"
                            name="pesquisa-retirar-local"
                            className="pesquisa-inputs"
                        ></input> */}
                    </div>
                    <div className="pesquisa-itens-duplos">

                        <DateRangeComp callApiProductsDateRange={callApiProductsDateRange} cidadeEscolhida={1} />

                    </div>

                    < Link to="/Produtos" id="pesquisa-botao-buscar" class="pesquisa-botao-buscar" >Buscar</Link> 
                    {/* <input type="button" id="pesquisa-botao-buscar" name="pesquisa-botao-buscar" value="Buscar" />  */}
                </div>
            </div>
        </>

    )




}

export default BlocoPesquisa;
