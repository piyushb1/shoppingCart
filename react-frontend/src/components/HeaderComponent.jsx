import React, { Component } from 'react'
import { Navbar,Nav,NavDropdown,Form,FormControl,Button } from 'react-bootstrap'
import { Link } from "react-router-dom";

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
            <div class="d-flex justify-content-center" style={{backgroundColor: "#84a98c" }}>
            <Navbar expand="lg" style={{ width: 1600 }}>
				<Navbar.Brand href="/home">Store Bazaar</Navbar.Brand>
				<Navbar.Toggle aria-controls="basic-navbar-nav" />
				<Navbar.Collapse id="basic-navbar-nav">
					<Nav className="mr-auto">
					
					</Nav>
										
					{isLoggedIn ? 
					 <Link to="/cart" className="ml-auto">
					 <Button>
					   <span className="mr-2">
						 <i className="fas fa-cart-plus " />
					   </span>
					   my cart
					 </Button>
				   </Link> : 
						<Button className="btn btn-success" href="/login">{isLoggedIn ? '' : 'Login'}</Button >
					}					
					{isLoggedIn ? 
					<NavDropdown title="My Account" id="basic-nav-dropdown">
						<NavDropdown.Item href="/user">My Profile</NavDropdown.Item>
						<NavDropdown.Item href="/myorders">My Orders</NavDropdown.Item>
						{this.isAdmin ? 
							<NavDropdown.Item href="/allorders">All Orders</NavDropdown.Item> : ' '
						}	
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



			<div>

				
			</div>
			
            </div>
        )
    }
}

export default HeaderComponent
