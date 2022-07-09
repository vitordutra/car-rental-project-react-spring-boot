#Francieli Celeghim

*** Settings ***
Library             SeleniumLibrary
Resource            ./dh.resource
Test Setup          Abrir o site
Test Teardown       Close Browser

*** Test Cases ***
Validação cadastro de usuario
    Clicar em “Criar conta”
    Preencher nome
    Preencher sobrenome
    Preencher email
    Preencher senha
    Clicar em Registrar
    Validar Sucesso
    Clicar em ok
    Clicar em Logaut

Validação login
    Clicar em "Login"
    Preencher email login
    Preencher senha login
    Clicar em Entrar
    Clicar em ok para deslogar


