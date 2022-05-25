import  React, { useContext } from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Header from '../component/Header/Header';
import Panel from '../pages/Panel';
import Login from '../pages/Login';
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
                                <Panel />
                            </Private>
                        }
                        />
                        
                        <Route path="*"element={<Error />} />

                    </Routes>
           </AuthProvider>      
            <Footer />    
        </BrowserRouter>
    );
};

export default Paginas;