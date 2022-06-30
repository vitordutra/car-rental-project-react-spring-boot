
import { Admin, Resource, CustomRoutes, Layout } from "react-admin";
import jsonServerProvider from "ra-data-json-server";
import { ProductCreate, ProductEdit, ProductList } from "../../component/ProductsCrud";


const dataProvider = jsonServerProvider("http://localhost:3000");


const CustomLayout = (props) => <Layout
    {...props}
    appBar={() => <div></div>}
/>;

const NewProduct = () => {

    return (
    <>
        <Admin basename="/administracao" layout={CustomLayout} dataProvider={dataProvider}>
            <Resource name="products" edit={ProductEdit} list={ProductList} create={ProductCreate} />
        </Admin>
    </>
    );
}

    export default NewProduct;