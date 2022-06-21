import './styles.css';
import format from 'date-fns/format';
import api from "../../../services/api";
import DateRangeComp from '../../Calendar/DateRangeComp';

const BlocoPesquisa = () => {


     async function callApiProductsDateRange(range,cidadeEscolhida) {

        try {
          const DataDeInicio  = format(range[0].startDate, "yyyy-MM-dd")        
          const DataDeTermino = format(range[0].endDate, "yyyy-MM-dd")          
          const cidade = cidadeEscolhida;
    
          const URL = `products?cityId=${cidade}&dataInicio=${DataDeInicio}&dataTermino=${DataDeTermino}` ;
          console.log(URL);
          /* const response = await api.get(URL);
          console.log(response.data);
          handleFilter(response.data); */
    
          
        }
        catch (error) {
          console.log(error)
        }
      } 
      


    return(
        <>
            <div className="pesquisa-container">
                <div className="pesquisa-titulo">
                    {/* <h1 className="pesquisa-titulo-texto"> Alugue seu carro aqui</h1> */}
                </div>
                <div className="pesquisa-primeira-fileira">
                    <div className="pesquisa-itens-duplos">
                        <input
                            placeholder="Digite o local de retirada"
                            type="text"
                            id="pesquisa-retirar-local"
                            name="pesquisa-retirar-local"
                            className="pesquisa-inputs"
                        ></input>
                       
                        {/* <input placeholder="Onde quer devolver?" type="text" id="pesquisa-devolucao-local" name="pesquisa-devolucao-local" className="pesquisa-inputs"/> */}
                        </div>
                        <div className="pesquisa-itens-duplos">
                        
                        <DateRangeComp callApiProductsDateRange={callApiProductsDateRange} cidadeEscolhida={1} />
                        
                        </div>
                        
                        
                        {/* <input type="button" id="pesquisa-botao-buscar" name="pesquisa-botao-buscar" value="Buscar" />  */}


                </div>


            </div>
        </>

    )




}

export default BlocoPesquisa;