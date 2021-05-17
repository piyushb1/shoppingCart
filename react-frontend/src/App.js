import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
// import cors from 'cors';
import HeaderComponent from './components/HeaderComponent.jsx';
import FooterComponent from './components/FooterComponent';
import ListUsers from './components/users/ListUsers';
import Signup from './components/users/Signup';
import Login from './components/users/Login';
import User from './components/users/User';
import Createproducts from './components/products/Createproducts'
import ListProducts from './components/products/ListProducts';
import Product from './components/products/Product';
import Cart from './components/orders/Cart';
import Home from './components/Home';
import Main from './components/Main';
import MyOrders from './components/orders/MyOrders';
import AllOrders from './components/orders/AllOrders';
import Order from './components/orders/Order';
import Address from './components/orders/Address';
import UpdateForm from './components/users/UpdateForm';
import LandingPage from './components/LandingPage';
import NotFound from './components/NotFound';


function App() {
  return (
    <div style={{backgroundColor: "#edf6f9" }}>
        <Router>
              <HeaderComponent />
                <div className="container" style={{backgroundColor: "#edf6f9" }} >
                    <Switch> 
                          <Route path = "/" exact component = {Main}></Route>
                          <Route path = "/home" exact component = {Home}></Route>
                          <Route path = "/users" exact component = {ListUsers}></Route>
                          <Route path = "/user" exact component = {User}></Route>
                          <Route path = "/signup" exact component = {Signup}></Route>
                          <Route path = "/update" exact component = {UpdateForm}></Route>
                          <Route path = "/login" exact component = {Login}></Route>
                          
                          <Route path = "/products" component = {ListProducts}></Route>    
                          <Route path = "/product/:id" component = {Product}></Route>                          
                          <Route path = "/addproduct" component = {Createproducts}></Route>                   
                          <Route path = "/landing" component = {LandingPage}></Route>
                          
                          <Route path = "/cart" component = {Cart}></Route>
                          <Route path = "/myorders" exact component = {MyOrders}></Route>                          
                          <Route path = "/order/:id" exact component = {Order}></Route>
                          <Route path = "/allorders" exact component = {AllOrders}></Route>
                          <Route path = "/address" exact component = {Address}></Route>

                          <Route component={NotFound} />
                    </Switch>
                </div>
              <FooterComponent />
        </Router>
    </div>
    
  );
}

export default App;
