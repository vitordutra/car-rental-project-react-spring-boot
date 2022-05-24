import  React, { useContext } from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Header from '../component/Header/Header';
import HomePage from '../pages/HomePage';
import Login from '../pages/Login';
import SobreEmpresa from '../pages/SobreEmpresa';
import Contato from '../pages/Contato'
import Economicos from '../component/Economicos';
import Suvs from '../component/Suvs';
import Eletricos from '../component/Eletricos';
import Esportivos from '../component/Esportivos';
import Footer from '../component/Footer/Footer';
import Error from '../component/Error';

import { AuthProvider, AuthContext } from "../context/auth";




const Paginas = () => {   
    const Private = ({ children }) => {
        const { authenticated, loading } = useContext(AuthContext);

        if (loading) {
            return <div className="loading">Carregando...</div>;
        }

        if (!authenticated) {
            return <Navigate to="/login" />;
        }

        return children;

    };
    return(
        <BrowserRouter>
            <Header />
           <AuthProvider>
                    <Routes>
                        
                        <Route path="/login" element={<Login />} />
                        <Route
                        path="/"
                        element=
                        {
                            <Private>
                                <HomePage />
                            </Private>
                        }
                        />
                        <Route path="/sobre-empresa" element={<SobreEmpresa />} />
                        <Route path="/contato" element={<Contato />} /> 
                        <Route path="/economicos" element={<Economicos />} />
                        <Route path="/suvs" element={<Suvs />} />
                        <Route path="/eletricos" element={<Eletricos />} />
                        <Route path="/esportivos" element={<Esportivos />} />
                        <Route path="*"element={<Error />} />

                    </Routes>
           </AuthProvider>      
            <Footer />    
        </BrowserRouter>
    );
};

export default Paginas;