
import { Admin, Resource, Layout } from "react-admin";
import { ProductCreate, ProductEdit, ProductList } from "../../component/ProductsCrud";
import simpleRestProvider from "ra-data-simple-rest";
import { stringfy } from "query-string";
import DataProvider from "./DataProvider";



// const dataProvider = simpleRestProvider("http://localhost:8080/");

const dataProvider = DataProvider("http://localhost:8080");

const CustomLayout = (props) => <Layout
    {...props}
    appBar={() => <div></div>}
/>;

const NewProduct = () => {

    return (
        <>
            <Admin basename="/administracao" layout={CustomLayout} dataProvider={dataProvider} >
                <Resource name="api/v1/products" edit={ProductEdit} list={ProductList} create={ProductCreate} />
            </Admin>
        </>
    );
}

export default NewProduct;