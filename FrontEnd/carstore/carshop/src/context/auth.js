import React, { useState, useEffect, createContext } from 'react';

import { useNavigate } from 'react-router-dom';
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

        const loggedUser = {
            id: "123",
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
        navigate("/login");
    };
    return (
        <AuthContext.Provider
            // user != null
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
