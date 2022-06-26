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

    const login = (email, password) => { 
        console.log("login auth", { email, password });
        //quando eu recebir inf de email e password iria no servidor e a api criaría  uma seccion

        api.post('/authenticate', {
            email: email,
            password: password
        }).then((response) => {
            console.log('response', response);
            const userToken = response.data;
            console.log('userToken', userToken);
            api.get(`/user/email/${email}`)
            .then((response) => {
                console.log('response', response);
                const loggedUser = {
                id: response.data.id,
                name: response.data.name,
                lastName: response.data.lastName,
                email: response.data.email,
                role: response.data.roles[0]?.name,
                token: userToken
              };
              localStorage.setItem('signed', JSON.stringify(loggedUser));
              setUser(loggedUser)
            })
            // localStorage.setItem('signed', JSON.stringify([userData]));
            // setUser([userData])
            navigate("/");
        }).catch((error) => {
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

        const loggedUser = {
            id: "123",
            name:"Bethilda",
            email,
        };

        localStorage.setItem("user", JSON.stringify(loggedUser));

        if (password === "secret") {
            setUser(loggedUser);
            navigate("/userpanel");
        }
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
