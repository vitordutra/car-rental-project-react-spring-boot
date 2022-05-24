import React, { useContext } from "react";

import { AuthContext } from "../../context/auth";

const HomeLogin = () => {
    const { authenticated, logout } = useContext (AuthContext);

    const handlelogout = () => {
        logout();
    };
    return (
        
   // eslint-disable-next-line no-unreachable
    <>
            <h1>HomeLogin</h1>;
            <p>{String(authenticated) }</p>
            <button onClick={handlelogout}>Logout</button>
    </>
       
    );  
};

export default HomeLogin;