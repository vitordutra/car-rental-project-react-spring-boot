/* eslint-disable jsx-a11y/alt-text */
/* eslint-disable no-unused-vars */
/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from "react";
import ProdCategory from "../../component/ProdCategory";
import Products from "../Products";
import api from "../../services/api";
import { useLocation, useParams } from 'react-router-dom';
import './styles.css';
import format from 'date-fns/format';


export default function ProductsCategory() {


  
  const [products, setProducts] = useState([]);
  const location = useLocation();
  const [cidade, setCidade] = useState(location.state.cidade)
  const [range, setRange] = useState(location.state.range)
 

/*   if (!(location.state === null)){
    try{
  setCidade(location.state.cidade)
  setRange(location.state.range)
}catch{

} 
} */
  console.log("PRINTANDO LOCATION")
  console.log(location)


  useEffect(() =>{
    console.log("before")
    if (!(cidade === "") & !(range === undefined)) {
      console.log("1+2")
      callApiProductsDateCity(range,cidade);
      

    } else{
      if (!(cidade === "")){
        console.log("1")
        callApiProductsCity(cidade);
        
      }else{
        if (!(range === undefined)){
          console.log("2")
          callApiProductsDate(range);
        

        }else{
          console.log("0")
          callApiProducts();
          
        }
      }

    }
  
  
  
  
},[]);
  

  // Captura do id de categoria parâmetro passado para a página
  /* const {categoryId} = useParams("categoryId");

  useEffect(() => {
    if (categoryId === undefined) {
      callApiProducts();
    } else {
      callApiProductsCategory();
    
    
    }
    
  }, []); */

  async function callApiProductsCategory(categoryId) {

    try {
      //const URL = "categories"
    
      const URL = `products?categoryId=${categoryId}`
      const response = await api.get(URL);
      setProducts(response.data);
    }
    catch (error) {
    }
  }

  async function callApiProductsCity(cityId) {

    try {
      
    
      const URL = `products?cityId=${cityId}`
      const response = await api.get(URL);
      setProducts(response.data);
    }
    catch (error) {
    }
  }


  

  async function callApiProducts() {

    try {
      //const URL = "categories"
    
      const URL = `products`
      const response = await api.get(URL);
      setProducts(response.data);
    }
    catch (error) {
    }
  }

  async function callApiProductsDateCity(range, cidade) {

    try {
        const DataDeInicio = format(range[0].startDate, "MM-dd-yyyy")
        const DataDeTermino = format(range[0].endDate, "MM-dd-yyyy")
        
        console.log(DataDeInicio);
        console.log(DataDeTermino);
        const URL = `products?cityId=${cidade}`; /* &data_inicial=${DataDeInicio}&data_final=${DataDeTermino}`; */
        // console.log(URL);
        const response = await api.get(URL);
        console.log(response);
        setProducts(response.data);


    }
    catch (error) {
        console.log(error)
    }
}

async function callApiProductsDate(range) {

  try {
      const DataDeInicio = format(range[0].startDate, "MM-dd-yyyy")
      const DataDeTermino = format(range[0].endDate, "MM-dd-yyyy")
      
      console.log(DataDeInicio);
      console.log(DataDeTermino);
      const URL = `products?data_inicial=${DataDeInicio}&data_final=${DataDeTermino}`;
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
      <body className="ProCategory-body" >
        <Products handleFilter={setProducts}/>
      <h1 className="ProCategory-h1"></h1>
      <ul className="ProCategory-ul">
        <li className="ProCategory-li">
            {products.map((item) => (
          < ProdCategory prmProduct={item} />
          
        ))}
            
          </li>
        </ul>
        </body>
    </>
  );
}
