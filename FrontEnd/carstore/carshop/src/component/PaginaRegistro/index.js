import React from "react";
import { Formik, Field, Form, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import api from '../../services/api';
import Swal from 'sweetalert2';
import { Link, useNavigate } from 'react-router-dom';

import './styles.css';

const PaginaRegistro = ({ onSubmit }) => {
  const sleep = ms => new Promise(r => setTimeout(r, ms));
  const handleSubmit = async (values, { setSubmitting }) => {
    setTimeout(() => {
      console.log('====aqui');
      api.post('/users', {
          nome: values.nome,
          sobrenome: values.sobrenome,
          email: values.email,
          senha: values.senha,
          roles: [
            { "id": 1 }
          ]
      }).catch((error) => {
        console.error(error);
        Swal.fire({
          title: "Infelizmente, você não pôde se registrar. Por favor, tente novamente mais tarde.",
          icon: 'error',
          text: error,
        })
      });
      setSubmitting(false);

    }, 400);
    await sleep(500);
  };

    return (
        <>

        <div class="container" >
          <a class="links" id="paracadastro"></a>
          <a class="links" id="paralogin"></a>
          
          <div class="content">      
          
            <div id="cadastro">

              <Formik
                initialValues={{ nome: '', sobrenome: '', email: '', senha: '' }}
                validationSchema={Yup.object({
                  nome: Yup.string()
                      .max(15, 'Deve conter no máximo 15 letras')
                      .required('Obrigatório'),
                  sobrenome: Yup.string()
                      .max(20, 'Deve conter no máximo 20 letras')
                      .required('Obrigatório'),
                  email: Yup.string().email('Email inválido').required('Obrigatório'),
                  senha: Yup.string()
                      .min(7, 'A senha deve ter no mínimo 7 caracteres')
                      .required('Obrigatório'),
                })}
                onSubmit={ handleSubmit }
              >

                <Form className="acessForm">
                  <h2 className="acessForm-h2">Crie sua conta</h2>

                  <p class="formField">
                    <div class="fieldHalf">
                      <label class="fieldHalf-label" for="nome">Nome</label>
                      <Field className="field" name="nome" type="text" id="nome"/>
                      <div className="errorMessage">
                        <ErrorMessage  name="nome">{msg => msg ? msg : ""}</ErrorMessage>
                      </div>
                    </div>

                    <div class="fieldHalf">
                      <label class="fieldHalf-label"for="sobrenome">Sobrenome</label>
                      <Field className="field" name="sobrenome" type="text" id="sobrenome"/>
                      <div className="errorMessage">
                        <ErrorMessage  name="sobrenome">{msg => msg ? msg : ""}</ErrorMessage>
                      </div>
                    </div>
                  </p>

                  <div class="clear"></div>
                  
                  <p class="formField"> 
                    <label class="fieldHalf-label" for="email">E-mail</label>
                    <Field className="field" name="email" type="text" id="email"/>
                    <div className="errorMessage">
                      <ErrorMessage  name="email">{msg => msg ? msg : ""}</ErrorMessage>
                    </div>
                  </p>
                  
                  <p class="formField">
                    <label class="fieldHalf-label" htmlFor="senha">Senha</label>
                    <Field className="field" name="senha" type="password" id="senha"/>  
                    <div className="errorMessage">
                        <ErrorMessage name="senha">{msg => msg ? msg : ""}</ErrorMessage>
                    </div>
                  </p>
                  
                  <button className="buttonForm" type="submit">Registrar</button>
                  
                  <p class="link">  
                    Já tem conta?
                    <a href="/login"> Ir para Login </a>
                    
                  </p>
                </Form>

              </Formik>

            </div>
          </div>
        </div> 

        </>
    )
}

export default PaginaRegistro; 
