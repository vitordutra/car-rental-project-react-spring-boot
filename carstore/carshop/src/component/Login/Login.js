import React from 'react';
import {useState} from 'react';


const Login = () => {

      const [login,setLogin] = useState({
          username:"",
          password:""
        })
        
        const {username,password} = login;
        
        const changeHandler = e => {
          setLogin({...login,[e.target.name]:[e.target.value]});
        }
        
        const submitHandler = e => {
          e.preventDefault();
          console.log(login);
        }

    return (
    
            <div className='login'>
              <center className='login-centro'>
              <form onSubmit={submitHandler}>
              <input type="text" name="username" value={username} onChange={changeHandler}/><br/>
              <input type="password" name="password" value={password} onChange={changeHandler}/><br/>
              <input type="submit" name="submit"/>
              </form>
              </center>
            </div>
 
    );
  }

  export default Login;