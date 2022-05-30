import React, { useContext } from "react";
import { AuthContext } from "../../../context/auth";


const ButtonSair = () => {
    const { logout } = useContext (AuthContext);
    
    const handlelogout = () => {
        logout();
    };
    return (
        
   
    <>
          
            <button onClick={handlelogout}>Sair</button>
    </>
       
    );  
};

export default ButtonSair;