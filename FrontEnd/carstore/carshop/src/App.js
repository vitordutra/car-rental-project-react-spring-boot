import Paginas from './routes';
import { Admin, Resource } from "react-admin";
import jsonServerProvider from "ra-data-json-server";
import {ProductList, ProductCreate, ProductEdit } from "../src/component/ProductsCrud";




const dataProvider = jsonServerProvider("http://localhost:3000");


const App = () => {
  return (
    
    <>
      
      <Paginas />
      
          <Admin dataProvider={dataProvider}>
        <Resource name="products" edit={ProductEdit } list={ ProductList} create={ProductCreate} />     
          </Admin>
       
    </>        
                
    
      
    
  );
}

export default App;
