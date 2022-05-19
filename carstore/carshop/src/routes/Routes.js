import React from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';

import Home from '../pages/Home';
import SobreEmpresa from '../pages/SobreEmpresa';
import Contato from '../pages/Contato'

import Economicos from '../component/Economicos';
import Suvs from '../component/Suvs';
import Eletricos from '../component/Eletricos';
import Error from '../component/Error';
import Esportivos from '../component/Esportivos';




function Routess(){
    return(
        <BrowserRouter>
            
            <Routes>
                
                    <Route path="/" exact component={Home} />
                    <Route path="/sobre-empresa" component={SobreEmpresa} />
                    <Route path="/contato" component={Contato} /> 
                    <Route path="/economicos" component={Economicos} />
                    <Route path="/suvs" component={Suvs} />
                    <Route path="/eletricos" component={Eletricos} />
                    <Route path="/esportivos" component={Esportivos} />
                    <Route path="*" component={Error} />

               
            </Routes>
                   
        </BrowserRouter>
    );
};

export default Routess;