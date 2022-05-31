import React, { Children } from "react";
import './styles.css';

export default function Modal({id = 'modal' ,onClose = () => { }, children }) { 
    const handleOutsideClick = (e) => {
        if (e.target.id === id) onClose();
    };      


    return (
        <>
            <div id={id} className="ProdutoModal" onClick={handleOutsideClick}>
                <div className="container">
                    <button className="close" onClick={onClose}/>
                    <div className="content">{children }</div>
                </div>
            </div>
        </>
    );
}