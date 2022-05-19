
import React from 'react'

const Contato = (props) => {
  

  
  
  return (
    <>
     <div>
      <div id='contato'>
        <div className='container'>
          <div className='col-md-8'>
            <div className='row'>
              <div className='section-title'>
                
                <h2>CONTATE-NOS !</h2>
                <p>
                Por favor, preencha o formulário me enviar um e-mail e retorno o mais rápido possível.
                </p>
             
              </div>
                       {/* FORMULÁRIO DE ENVIO */}
             
              <form name='sentMessage' validate onSubmit={handleSubmit}>
               
                <div className='row'>
                  <div className='col-md-6'>
                    
                    <div className='form-group'>
                     
                      <input type='text' id='name'  name='name' className='form-control' placeholder='Nome' required onChange={handleChange} />  
                      <p className='help-block text-danger'></p>
                   
                    </div>
                  </div>
                 
                  <div className='col-md-6'>
                    <div className='form-group'>
                     
                      <input type='email' id='email' name='email' className='form-control' placeholder='Email' required onChange={handleChange} />
                      <p className='help-block text-danger'></p>
                    
                    </div>
                  </div>
               
                </div>
                <div className='form-group'>
                 
                  <textarea name='message' id='message' className='form-control'rows='4' placeholder='Mensagem' required onChange={handleChange}>

                  </textarea>
                  <p className='help-block text-danger'></p>
               
                </div>
                <div id='success'>

                <button onClick={handleSubmit} type='submit' className='btn btn-custom btn-lg'>
                  Enviar mensagem
                </button>
                
               </div>
              </form>
            </div>
          </div>

                   {/* ENDEREÇO PARA CONTATO */}
         
          <div className='col-md-3 col-md-offset-1 contato-info'>
            <div className='contato-item'>
              <h3>Informações de contato</h3>
              <p>
                <span>
                  <i className='fa fa-map-marker'></i> Endereço
                </span>{' '}
                {props.data ? props.data.endereco: 'loading'}
              </p>
            </div>
            <div className='contato-item'>
              <p>
                <span>
                  <i className='fa fa-phone'></i> Telefone
                </span>{' '}
                {props.data ? props.data.telefone : 'loading'}
              </p>
            </div>
            <div className='contato-item'>
              <p>
                <span>
                  <i className='fa fa-envelope-o'></i> Email
                </span>{' '}
                {props.data ? props.data.email : 'loading'}
              </p>
            </div>
          </div>


                     {/*LINK PARA APLICATIVOS */}
                    
  
   <div className='col-md-12'>
            <div className='row'>
              <div className='social'>
                <ul>
                  <li>
                    <a href={props.data ? props.data.facebook : '/'}>
                      <i className='fa fa-facebook'></i>
                    </a>
                  </li>
                  <li>
                    <a href={props.data ? props.data.instagram : '/'}>
                      <i className='fa fa-instagram'></i>
                    </a>
                  </li>
                  <li>
                    <a href={props.data ? props.data.github : '/'}>
                      <i className='fa fa-github'></i>
                    </a>
                  </li>
                  <li>
                    <a href={props.data ? props.data.linkedin : '/'}>
                      <i className='fa fa-linkedin'></i>
                    </a>
                  </li>
                 
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div> 
    </> 
  )

  }
export default Contato;