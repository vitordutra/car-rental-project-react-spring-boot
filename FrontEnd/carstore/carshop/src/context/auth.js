import React, { useState, useEffect, createContext } from 'react';
import Swal from 'sweetalert2';

import { useNavigate } from 'react-router-dom';
import api from '../services/api';

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const navigate = useNavigate();
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const recoveredUser = localStorage.getItem('user');

        if (recoveredUser){
            setUser(JSON.parse(recoveredUser));
        }

        setLoading(false);
       
     }, []);

    const login = (email, senha) => { 
        console.log("login auth", { email, senha });
        //quando eu recebir inf de email e password iria no servidor e a api criaría  uma seccion

        api.post('/authenticate', {
            email: email,
            senha: senha
        })
        .then((responseJwt) => {
            console.log('responseJwt', responseJwt);
            const userToken = responseJwt.data;
            console.log('userToken', userToken);

            api.get(`/users/email/${email}`)
            .then((responseUser) => {
            console.log('responseUser', responseUser);
              const loggedUser = {
                id: responseUser.data.id,
                name: responseUser.data.name,
                lastName: responseUser.data.lastName,
                email: responseUser.data.email,
                role: responseUser.data.roles[0]?.name,
                token: userToken
              };

              localStorage.setItem('signed', JSON.stringify(loggedUser));
              setUser(loggedUser);
            })
            navigate("/userpanel");
        })
        .catch((error) => {
            console.error('error', error);
      
            Swal.fire({
              icon: 'error',
              title: 'Ops!',
              text: 'Por favor, tente novamente, suas credenciais são inválidas',
              confirmButtonColor: 'var(--primary-color)',
              imageWidth: 100,
              width: 350,
            })
        });
    };

    const logout = () => {
        console.log("logout");
        localStorage.removeItem("user");
        setUser(null);
        navigate("/");
    };
    return (
        <AuthContext.Provider
            // user =/= null
    // authenticated == true
    //ou
    //user == null
    //autenticated = false
    // !! (Boolean)
            value={{
                authenticated: !!user, user,loading, login,
                logout
            }}
        >
            {children}    
        </AuthContext.Provider>
    );
};
