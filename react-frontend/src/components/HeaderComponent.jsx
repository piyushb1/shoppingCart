import React, { Component } from 'react'
import { Navbar,Nav,NavDropdown,Form,FormControl,Button } from 'react-bootstrap'


class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
			isLoggedIn: false,
			isAdmin : false,
        }

        this.logout = this.logout.bind(this);
		this.cart = this.cart.bind(this);
		
    }

    logout(){
        localStorage.removeItem('jwtToken');
        localStorage.removeItem('role');
        localStorage.removeItem('userid');
    }

	cart(){
        // let userid=localStorage.getItem('userid');
		// this.props.history.push('/cart');
    }
	

    render() {
		if(localStorage.role=="[admin]"){
			this.isAdmin=true;
		}
		
		let isLoggedIn = this.state.isLoggedIn;	
		if(localStorage.jwtToken){
			isLoggedIn=true;
		}
		

		
        return (
            <div class="d-flex justify-content-center">
            <Navbar bg="dark" variant="dark" expand="lg" style={{ width: 1600 }}>
				<Navbar.Brand href="/">Store Bazaar</Navbar.Brand>
				<Navbar.Toggle aria-controls="basic-navbar-nav" />
				<Navbar.Collapse id="basic-navbar-nav">
					<Nav className="mr-auto">
						{/* <Nav.Link href="/">Mobile Store</Nav.Link> */}
						{/* <Nav.Link href="#link">Link</Nav.Link> */}
						{/* <NavDropdown title="Categories" id="basic-nav-dropdown">
							<NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
							<NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
							<NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
							<NavDropdown.Divider />
							<NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
						</NavDropdown> */}
						{/* <Form inline>
							<FormControl type="text" placeholder="Search" className="mr-sm-2" />
							<Button variant="outline-success">Search</Button>
					</Form> */}
					</Nav>
										
					{isLoggedIn ? 
					<Button className="btn" href="/cart">{isLoggedIn ? 'Cart' : ''}</Button > : 
						<Button className="btn btn-success" href="/login">{isLoggedIn ? '' : 'Login'}</Button >
					}					
					{isLoggedIn ? 
					<NavDropdown title="My Account" id="basic-nav-dropdown">
						<NavDropdown.Item href="#action/3.1">My Profile</NavDropdown.Item>
						<NavDropdown.Item href="#action/3.2">My Orders</NavDropdown.Item>
						{this.isAdmin ? 
							<NavDropdown.Item href="/products">All Products</NavDropdown.Item> : ' '
						}	
						{this.isAdmin ? 
							<NavDropdown.Item href="/users">All Users</NavDropdown.Item> : ' '
						}	
					<NavDropdown.Divider />
						<NavDropdown.Item href="/login"><button className="btn btn-danger" onClick={this.logout}>Logout</button></NavDropdown.Item>
					</NavDropdown>
					 : ''}
				</Navbar.Collapse>
			</Navbar>
            </div>
        )
    }
}

export default HeaderComponent
