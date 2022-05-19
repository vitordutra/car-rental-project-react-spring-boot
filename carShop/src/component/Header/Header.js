import React from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink
  } from 'reactstrap';

export default class Example extends React.Component {
  constructor(props) {
    super(props);

    this.toggle = this.toggle.bind(this);
    this.state = {
      isOpen: false
    };
  }
  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }
  render() {
    return (
      <div>
        <Navbar color="black" light expand="md">
          <NavbarBrand href="/">Igatu - Chapada Diamantina</NavbarBrand>
          <NavbarToggler onClick={this.toggle} />
          <Collapse isOpen={this.state.isOpen} navbar>
            <Nav className="ml-auto" navbar>

              <NavItem>
                <NavLink href="/alimentacao">Onde comer?</NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="/hospedagem">Onde dormir?</NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="/artesanatos">Artesanatos local</NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="/contato">Contatos aqui!</NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="https://github.com/reactstrap/reactstrap">Contrate um guia</NavLink>
              </NavItem>
              
            </Nav>
          </Collapse>
        </Navbar>
      </div>
    );
  }
}