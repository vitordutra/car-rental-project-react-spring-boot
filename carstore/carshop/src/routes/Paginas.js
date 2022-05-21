import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Header from '../component/Header/Header';
import Home from '../pages/Home';
import SobreEmpresa from '../pages/SobreEmpresa';
import Contato from '../pages/Contato'
import Economicos from '../component/Economicos';
import Suvs from '../component/Suvs';
import Eletricos from '../component/Eletricos';
import Esportivos from '../component/Esportivos';
import Footer from '../component/Footer/Footer';
import Error from '../component/Error';


const Paginas = () => {
    return(
        <BrowserRouter>
            <Header />
            <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/sobre-empresa" element={<SobreEmpresa />} />
                    <Route path="/contato" element={<Contato />} /> 
                    <Route path="/economicos" element={<Economicos />} />
                    <Route path="/suvs" element={<Suvs />} />
                    <Route path="/eletricos" element={<Eletricos />} />
                    <Route path="/esportivos" element={<Esportivos />} />
                    <Route path="*"element={<Error />} />
   
            </Routes>
            <Footer />    
        </BrowserRouter>
    );
};

export default Paginas;