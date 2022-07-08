/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable no-unused-vars */
/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from 'react';
import ProdCategory from '../../component/ProdCategory';
import Products from '../Products';
import api from '../../services/api';
import { useLocation, useParams } from 'react-router-dom';
import './styles.css';
import format from 'date-fns/format';

export default function ProductsCategory() {
  const [products, setProducts] = useState([]);
  /* const location = useLocation(); */
  const params = useParams();

  const [cidade, setCidade] = useState(params.cidade);
  const [startDate, setstartDate] = useState(params.startDate);
  const [endDate, setendDate] = useState(params.endDate);

  useEffect(() => {
    console.log('cidade: ', cidade);
    console.log('startDate: ', startDate);
    console.log('endDate: ', endDate);
    if (!!cidade !== false && !(startDate === undefined)) {
      //console.log("1+2")
      callApiProductsDateCity(cidade, startDate, endDate);
    } else {
      if (!(cidade === undefined)) {
        //console.log("1")
        callApiProductsCity(cidade);
      } else {
        if (!(startDate === undefined)) {
          //console.log("2")
          callApiProductsDate(startDate, endDate);
        } else {
          //console.log("0")
          callApiProducts();
        }
      }
    }
  }, []);

  async function callApiProductsCategory(categoryId) {
    try {
      const URL = `/category/${categoryId}`;
      const response = await api.get(URL);
      setProducts(response.data);
    } catch (error) {}
  }

  async function callApiProductsCity(cityId) {
    try {
      const URL = `products/city/${cityId}`;
      const response = await api.get(URL);
      setProducts(response.data);
    } catch (error) {}
  }

  async function callApiProducts() {
    try {
      //const URL = "categories"

      const URL = `/api/v1/products`;
      const response = await api.get(URL);
      setProducts(response.data);
    } catch (error) {}
  }

  async function callApiProductsDateCity(cidade, startDate, endDate) {
    try {
      console.log(
        'Entrou em ProductsCategory, callApiProductsDateCity, Linha 72'
      );
      const DataDeInicio = startDate;
      const DataDeTermino = endDate;

      console.log(DataDeInicio);
      console.log(DataDeTermino);
      const URL = `api/v1/products?cityId=${cidade}&dataInicio=${DataDeInicio}&dataTermino=${DataDeTermino}`; /* &data_inicial=${DataDeInicio}&data_final=${DataDeTermino}`; */
      console.log(URL);
      const response = await api.get(URL);
      console.log(response);
      setProducts(response.data);
    } catch (error) {
      console.log(error);
    }
  }

  async function callApiProductsDate(startDate, endDate) {
    try {
      console.log('Entrou em ProductsCategory, callApiProductsDate, Linha 92');
      const DataDeInicio = startDate;
      const DataDeTermino = endDate;

      console.log(DataDeInicio);
      console.log(DataDeTermino);
      const URL = `api/v1/products?dataInicio=${DataDeInicio}&dataTermino=${DataDeTermino}`;
      console.log(URL);
      const response = await api.get(URL);
      console.log(response);
      setProducts(response.data);
    } catch (error) {
      console.log(error);
    }
  }

  return (
    <>
      <div className='ProCategory-body'>
        <Products handleFilter={setProducts} />
        <h1 className='ProCategory-h1'></h1>
        <ul className='ProCategory-ul'>
          <li className='ProCategory-li'>
            {products.map(item => (
              <ProdCategory key={item.id} prmProduct={item} />
            ))}
          </li>
        </ul>
      </div>
    </>
  );
}
