import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
// import cors from 'cors';
import ListEmployeeComponent from './components/ListEmployeeComponent';
import HeaderComponent from './components/HeaderComponent.jsx';
import FooterComponent from './components/FooterComponent';
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';
import ViewEmployeeComponent from './components/ViewEmployeeComponent';
import ListUsers from './components/users/ListUsers';
import Signup from './components/users/Signup';
import Login from './components/users/Login';
import User from './components/users/User';
import Createproducts from './components/products/Createproducts'
import ListProducts from './components/products/ListProducts';
import Product from './components/products/Product';
import Cart from './components/Cart';
import Home from './components/Home';



function App() {
  return (
    <div>
        <Router>
              <HeaderComponent />
                <div className="container">
                    <Switch> 
                          <Route path = "/" exact component = {Home}></Route>
                          <Route path = "/employees" component = {ListEmployeeComponent}></Route>
                          <Route path = "/add-employee/:id" component = {CreateEmployeeComponent}></Route>
                          <Route path = "/view-employee/:id" component = {ViewEmployeeComponent}></Route>

                          <Route path = "/users" exact component = {ListUsers}></Route>
                          <Route path = "/user" exact component = {User}></Route>
                          <Route path = "/signup" exact component = {Signup}></Route>
                          <Route path = "/login" exact component = {Login}></Route>
                          <Route path = "/userservice" component = {ListEmployeeComponent}></Route>
                          
                          <Route path = "/products" component = {ListProducts}></Route>    
                          <Route path = "/product/:id" component = {Product}></Route>                          
                          <Route path = "/addproduct" component = {Createproducts}></Route>
                          <Route path = "/update-employee/:id" component = {UpdateEmployeeComponent}></Route>
                          
                          <Route path = "/cart" component = {Cart}></Route>
                    </Switch>
                </div>
              {/* <FooterComponent /> */}
        </Router>
    </div>
    
  );
}

export default App;
