*** Variables ***
# gerais
${URL}                      http://localhost:3000/
${NAVEGADOR}                Chrome      

${CRIAR_CONTA}              xpath=//span[contains(.,'Criar conta')]
${PREENCHER_NOME}           id=nome
${NOME}                     Francieli
${PREENCHER_SOBRENOME}      id=sobrenome
${SOBRENOME}                Celeghim
${PREENCHER_EMAIL}          id=email
${EMAIL}                    francieli1234@gmail.com
${PREENCHER_SENHA}          id=senha
${SENHA}                    123456789
${CLICAR_REGISTRAR}         css=.buttonForm
${TITULO}                   id=swal2-title
${TEXTO_TITULO}             Sucesso
${CLICAR_OK}                xpath=(//button[@type='button'])[2]
${CLICAR_LOGOUT}            xpath=//div[@id='root']/div/div[2]/button
${CLICAR_LOGIN}             css=.header-rightLink:nth-child(3)
${PREENCHER_EMAIL_LOGIN}    id=email
${EMAIL_LOGIN}              francieli1234@gmail.com
${PREENCHER_SENHA_LOGIN}    id=password
${SENHA_LOGIN}              123456789
${CLICAR_ENTRAR}            css=button
${CLICAR_OK}                xpath=//div[@id='root']/div[2]/button


*** Keywords ***
# gerais
Abrir o site
    Open Browser                    ${URL}        ${NAVEGADOR}
    Maximize Browser Window
    Set Selenium Speed              0.1

# primeiro caso de teste criar conta
Clicar em “Criar conta”
    Wait and Click          ${CRIAR_CONTA}

Preencher nome
    Wait and Input Text     ${PREENCHER_NOME}                         ${NOME}

Preencher sobrenome
    Wait and Input Text     ${PREENCHER_SOBRENOME}                    ${SOBRENOME}

Preencher email
    Wait and Input Text     ${PREENCHER_EMAIL}                        ${EMAIL}

Preencher senha
    Wait and Input Text     ${PREENCHER_SENHA}                        ${SENHA}

Clicar em registrar
    Wait and Click          ${CLICAR_REGISTRAR}                        

Validar Sucesso
    Wait Until Element is Visible   ${TITULO}
    Element Should Contain          ${TITULO}           ${TEXTO_TITULO}

Clicar em ok
    Wait and Click          ${CLICAR_OK}

Clicar em Logaut
    Wait and Click              ${CLICAR_LOGOUT}




# segundo caso de teste logar
Clicar em "Login"
    Wait and Click          ${CLICAR_LOGIN}

Preencher email login
    Wait and Input Text     ${PREENCHER_EMAIL_LOGIN}                     ${EMAIL_LOGIN}

Preencher senha login
    Wait and Input Text     ${PREENCHER_SENHA_LOGIN}                        ${SENHA_LOGIN}

Clicar em Entrar
    Wait and Click          ${CLICAR_ENTRAR}

Clicar em ok para deslogar
    Wait and Click          ${CLICAR_OK}




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