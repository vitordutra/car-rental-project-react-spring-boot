*** Variables ***
# gerais
${URL}                      http://localhost:3000/
${NAVEGADOR}                Chrome      

${CLICAR_LOGIN}                     css=.header-rightLink:nth-child(3)
${PREENCHER_EMAIL_LOGIN}            id=email
${EMAIL_LOGIN}                      francieliceleghim2013@gmail.com
${PREENCHER_SENHA_LOGIN}            id=password
${SENHA_LOGIN}                      1234567
${CLICAR_ENTRAR_LOGIN}              css=button
${CLICAR_CONHEÇA_NOSSA_FROTA}       css=.header-rightLink > span
${TITULO_PRODUTO}                   xpath=(//div[@id='page-container']/ul/li/div/h3[2])[2]
${TEXTO_TITULO_PRODUTO}             Caoa Chery iCar
${CLICAR_MAIS_DETALHES}             xpath=(//div[@id='page-container']/ul/li/button)[2]
${CLICAR_RESERVE_AGORA}             css=.ButtonModal
${DATA_INICIO}                      xpath=//input[@placeholder='Early']
${VALOR_DATA_INICIO}                Jul 22, 2022
${DATA_FIM}                         css=p:nth-child(4) > input
${VALOR_DATA_FIM}                   Jul 20, 2022
${CLICAR_RESERVAR}                  xpath=//button[contains(.,'Reservar')]
${TITULO_MUITO_OBRIGADO}            xpath=//div[@id='confirmeReserva-card']/h3
${TEXTO_TITULO_MUITO_OBRIGADO}      Muito obrigado!
${TITULO_RESERVA_SUCESSO}           xpath=//div[@id='confirmeReserva-card']/h5
${TEXTO_TITULO_RESERVA_SUCESSO}     Sua reserva foi feita com sucesso.
${CLICAR_VOLTAR}                    css=.confirmeReservaBtn



*** Keywords ***
# primeiro caso de teste gerais
Abrir o site
    Open Browser                    ${URL}        ${NAVEGADOR}
    Maximize Browser Window
    Set Selenium Speed              0.5

# Segundo caso de teste "Login"
Clicar em “Criar Login”                 
    Wait and Click                  ${CLICAR_LOGIN}

Preencher email
    Wait and Input Text              ${PREENCHER_EMAIL_LOGIN}             ${EMAIL_LOGIN}

Preencher senha
    Wait and Input Text               ${PREENCHER_SENHA_LOGIN}             ${SENHA_LOGIN}

Clicar em Entrar
    Wait and Click                    ${CLICAR_ENTRAR_LOGIN}

# Terceiro caso de teste
Clicar em “Conheça nosa Frota”
    Wait and Click                    ${CLICAR_CONHEÇA_NOSSA_FROTA}

Validação Caoa Chery iCar
    Wait Until Element is Visible      ${TITULO_PRODUTO}
    Element Should Contain             ${TITULO_PRODUTO}                    ${TEXTO_TITULO_PRODUTO}

Clicar em "Mais Detalhes"
    Wait and Click                     ${CLICAR_MAIS_DETALHES}

Clicar em "Reserve Agora"
    Wait and Click                     ${CLICAR_RESERVE_AGORA}

Validar as datas de reserva
    Element Should Contain            ${DATA_INICIO}            ${VALOR_DATA_INICIO}
    Element Should Contain            ${DATA_FIM}               ${VALOR_DATA_FIM}

Clicar em "Reservar"
    Wait More and Click                     ${CLICAR_RESERVAR}
   
    

Validar "Muito obrigado!"
    Wait Until Element is Visible      ${TITULO_MUITO_OBRIGADO}
    Element Should Contain             ${TITULO_MUITO_OBRIGADO}             ${TEXTO_TITULO_MUITO_OBRIGADO}

Validar "Sua reserva foi feita com sucesso."
    Wait Until Element is Visible       ${TITULO_RESERVA_SUCESSO}
    Element Should Contain              ${TITULO_RESERVA_SUCESSO}           ${TEXTO_TITULO_RESERVA_SUCESSO}

Clicar em "Voltar"
    Wait and Click          ${CLICAR_VOLTAR}


Wait and Click
    [Arguments]                       ${ELEMENTO}
    Wait Until Element is Visible     ${ELEMENTO}
    Wait Until Element is Enabled     ${ELEMENTO}
    Scroll Element Into View          ${ELEMENTO}
    Click Element                     ${ELEMENTO}
    

Wait and Input Text
    [Arguments]                       ${ELEMENTO}     ${TEXTO}
    Wait Until Element is Visible     ${ELEMENTO}
    Wait Until Element is Enabled     ${ELEMENTO}
    Scroll Element Into View          ${ELEMENTO}
    Input Text                        ${ELEMENTO}     ${TEXTO}

Wait and Select From List
    [Arguments]                       ${ELEMENTO}     ${LABEL}
    Wait Until Element is Visible     ${ELEMENTO}
    Wait Until Element is Enabled     ${ELEMENTO}
    Scroll Element Into View          ${ELEMENTO}
    Select From List By Label         ${ELEMENTO}     ${LABEL}

Wait Clear and Input Text
    [Arguments]                       ${ELEMENTO}     ${TEXTO}
    Wait Until Element is Visible     ${ELEMENTO}
    Wait Until Element is Enabled     ${ELEMENTO}
    Scroll Element Into View          ${ELEMENTO}
    Clear Element Text                ${ELEMENTO}
    Input Text                        ${ELEMENTO}     ${TEXTO}

Wait More and Click
    [Arguments]                       ${ELEMENTO}
    Wait Until Element is Visible     ${ELEMENTO}
    Wait Until Element is Enabled     ${ELEMENTO}
    Scroll Element Into View          ${ELEMENTO}
    Sleep                             2s
    Click Element                     ${ELEMENTO}