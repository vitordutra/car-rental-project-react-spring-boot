import React from 'react';
import {Nav,  Container, Navbar} from 'react-bootstrap';

const Header = () => {
  return (
    <header className="header"  >
      <Navbar bg="dark" variant="dark">
    <Container>
    <Navbar.Brand href="#home">Navbar</Navbar.Brand>
    <Nav className="me-auto">
      <Nav.Link href="#home">Home</Nav.Link>
      <Nav.Link href="#features">Features</Nav.Link>
      <Nav.Link href="#pricing">Pricing</Nav.Link>
    </Nav>
    </Container>
  </Navbar>
      
    </header>
  )
}

export default Header;