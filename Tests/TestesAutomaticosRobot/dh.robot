#Francieli Celeghim

*** Settings ***
Library             SeleniumLibrary
Resource            dh.resource
Test Setup          Abrir o site
Test Teardown       Close Browser

*** Test Cases ***


Validação da reserva
    Clicar em “Criar Login”
    Preencher email
    Preencher senha
    Clicar em Entrar
    Clicar em “Conheça nosa Frota”
    Validação Caoa Chery iCar
    Clicar em "Mais Detalhes"
    Clicar em "Reserve Agora"
    Validar as datas de reserva
    #Clicar em "Reservar"
    #Validar "Muito obrigado!"
    #Validar "Sua reserva foi feita com sucesso."
    #Clicar em "Voltar"

