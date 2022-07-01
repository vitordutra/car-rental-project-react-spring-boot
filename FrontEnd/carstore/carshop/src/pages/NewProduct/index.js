
import { fetchUtils, Admin, Resource, Layout } from "react-admin";
import { ProductCreate, ProductEdit, ProductList } from "../../component/ProductsCrud";
import simpleRestProvider from "ra-data-simple-rest";


const fetchJson = (url, options = {}) => {
    if (!options.headers) {
        options.headers = new Headers({ Accept: 'application/json' });
    }
 // add your own headers here
 options.headers.set('X-Custom-Header', 'foobar');
 return fetchUtils.fetchJson(url, options);
}

const dataProvider = simpleRestProvider("http://localhost:8080/", fetchJson);


const CustomLayout = (props) => <Layout
    {...props}
    appBar={() => <div></div>}
/>;

const NewProduct = () => {

    return (
        <>
            <Admin basename="/administracao" layout={CustomLayout} dataProvider={dataProvider}>
                <Resource name="/api/v1/products" edit={ProductEdit} list={ProductList} create={ProductCreate} />
            </Admin>
        </>
    );
}

export default NewProduct;