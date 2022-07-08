import { useEffect, useState, useRef } from 'react';
import './styles.css';
import format from 'date-fns/format';
import { Link } from 'react-router-dom';
import api from '../../../services/api';

import { DateRange } from 'react-date-range';

import { addDays, set } from 'date-fns';

import 'react-date-range/dist/styles.css';
import 'react-date-range/dist/theme/default.css';
import { useNavigate } from 'react-router';

const BlocoPesquisa = ({ handleFilter }) => {
  const [cidade, setCidade] = useState('');
  const [cidades, setCidades] = useState([]);
  const [inputValue, setInputValue] = useState('');
  const [stringTexto, setStringTexto] = useState('');
  const [openSugestions, setOpenSugestions] = useState(false);

  const onChange = event => {
    setOpenSugestions(true);
    handleShowSugestions(true);
    setInputValue(event.target.value);
  };
  async function callCidadesApi() {
    try {
      console.log('Entrou em BlocoPesquisa, Linha 29');
      const response = await api.get('/api/v1/cities');
      setCidades(response.data);
    } catch (error) {
      console.log(error);
    }
  }

  useEffect(() => {
    callCidadesApi();
  }, []);

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
      console.log('Entrou em BlocoPesquisa, Linha 29');
      const response = await api.get(`products/city/${id}`);
      handleFilter(response.data);
    } catch (error) {
      console.log(error);
    }
  }

  //Parte do calendário ###############################################################################################################
  const refOne = useRef(null);
  const minDate = new Date(
    new Date().getFullYear(),
    new Date().getMonth(),
    new Date().getDate()
  );
  const maxDate = new Date(
    new Date().getFullYear(),
    new Date().getMonth() + 2,
    new Date().getDate()
  );
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
    document.addEventListener('keydown', hideOnEscape, true);
  }, []);

  // hide dropdown on ESC press
  const hideOnEscape = e => {
    // console.log(e.key)
    if (e.key === 'Escape') {
      setOpen(false);
      setOpenSugestions(false);
    }
  };

  const [range, setRange] = useState([
    {
      startDate: new Date(),
      endDate: addDays(new Date(), 1),
      key: 'selection',
    },
  ]);
  const [open, setOpen] = useState(false);

  const navigate = useNavigate();

  const handleSearch = () => {
    /* navigate("/Produtos",{state: {range,cidade}}); */
    if (cidade !== '') {
      navigate(
        `/Produtos/${cidade}/${format(
          range[0].startDate,
          'yyyy-MM-dd'
        )}/${format(range[0].endDate, 'yyyy-MM-dd')}`
      );
    } else {
      navigate(
        `/Produtos/${format(range[0].startDate, 'yyyy-MM-dd')}/${format(
          range[0].endDate,
          'yyyy-MM-dd'
        )}`
      );
    }
  };

  const handleSelectCity = (value, text) => {
    setStringTexto(text.toString());

    document.getElementById('pesquisa-retirar-local').value = stringTexto;
    setCidade(value);
  };

  const handleShowSugestions = () => {
    const robson = document.getElementsByClassName('dropdown')[0];
    console.log('robson: ', robson);
    console.log('openSugestions: ', openSugestions);
    console.log('cidade: ', cidade);

    if (openSugestions) {
      robson.style.display = 'none';
      setOpenSugestions(!openSugestions);
    } else {
      robson.style.display = '';
      setOpenSugestions(!openSugestions);
    }
  };

  return (
    <>
      <div>
        <div className='pesquisa-primeira-fileira'>
          <div className='pesquisa-itens-duplos'>
            {/* <select className="select" name="cidade"  onChange={item => callProductByCity(item.target.value)}>
              <option  value="">Escolha a cidade</option>
              {cidade.map((item) => (
              <option value={item.id}>{item.nome}</option>
              ))}
            </select> */}

            <div className='search-container'>
              <div className='search-inner'>
                <input
                  placeholder='Digite o local de retirada'
                  type='text'
                  id='pesquisa-retirar-local'
                  name='pesquisa-retirar-local'
                  className='pesquisa-inputs'
                  value={inputValue}
                  onChange={onChange}
                  onClick={handleShowSugestions}

                  /* value={inputValue} */
                  /* onChange={item =>( setInputValue(item.target.text))} */
                />
              </div>

              <div className='dropdown'>
                {cidades
                  .filter(item => {
                    const searchTerm = inputValue.toString().toLowerCase();
                    const fullName = item.nome.toString().toLowerCase();

                    return fullName.includes(searchTerm);
                  })
                  .map(item => (
                    <div key={item.id} className='dropdown-row'>
                      <option
                        onClick={item =>
                          handleSelectCity(item.target.value, item.target.text)
                        }
                        value={item.id}>
                        {item.nome}, {item.estado}
                      </option>
                    </div>
                  ))}
              </div>
            </div>
          </div>

          <div className='pesquisa-itens-duplos'>
            <input
              value={`${format(range[0].startDate, 'dd/MM/yyyy')} to ${format(
                range[0].endDate,
                'dd/MM/yyyy'
              )}`}
              readOnly
              className='inputBox'
              onClick={() => setOpen(open => !open)}
            />
            <div className='calendarFrontPage'>
              {open && (
                <DateRange
                  onChange={item => setRange([item.selection])}
                  minDate={minDate}
                  maxDate={maxDate}
                  editableDateInputs={true}
                  moveRangeOnFirstSelection={false}
                  ranges={range}
                  className='date'
                />
              )}
            </div>
          </div>

          <input
            type='button'
            onClick={handleSearch}
            id='pesquisa-botao-buscar'
            name='pesquisa-botao-buscar'
            value='Buscar'
          />
        </div>
      </div>
    </>
  );
};

export default BlocoPesquisa;
