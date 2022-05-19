import React from 'react';
import {BrowserRouter, Switch, Route} from 'react-router-dom';

import Main from '../pages/Main';
import SobreEmpresa from '../pages/SobreEmpresa';
import Contato from '../pages/Contato'

import Economicos from '../component/Economicos';
import Suvs from '../component/Suvs';
import Eletricos from '../component/Eletricos';
import Error from '../component/Error';
import Esportivos from '../component/Esportivos';




function Routes(){
    return(
        <BrowserRouter>
            <Switch>
                
                    <Route path="/" exact component={Main} />
                    <Route path="/sobre-empresa" component={SobreEmpresa} />
                    <Route path="/contato" component={Contato} /> 
                    <Route path="/economicos" component={Economicos} />
                    <Route path="/suvs" component={Suvs} />
                    <Route path="/eletricos" component={Eletricos} />
                    <Route path="/esportivos" component={Esportivos} />
                    <Route path="*" component={Error} />

               
            </Switch>        
        </BrowserRouter>
    );
};

export default Routes;