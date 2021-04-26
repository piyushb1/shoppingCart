import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import './css/ListProducts.css'
import ProductService from '../services/ProductService'
import CartService from '../services/CartService';
import './css/Home.css'

class ListUsers extends Component {
    constructor(props) {
        super(props)

        this.state = {
            num:1,
            products: []
        }
        this.addtoCart = this.addtoCart.bind(this);
        this.viewProduct = this.viewProduct.bind(this);
    }

     viewProduct(productid){
        this.props.history.push(`/product/${productid}`);
    }

    componentDidMount(){
        ProductService.getProducts().then((res) => {
            this.setState({ products: res.data});   
        });
    }

    addtoCart(productid){
        let userid = localStorage.userid;
        CartService.addToCart(userid,productid);
    }

    render() {
        
        return (

            <div>
                 <h2 className="text-center">Welcome HomePage</h2>
           
            <div>
                 
                 <div id="product">
               {
                   this.state.products.map(product =>(this.state.num++,
                       <div className="card" key={product.productid}>
                           <Link onClick={ () => this.viewProduct(product.productid)}>
                            <img src={`images/${this.state.num}.png`} alt=""/>
                               
                           </Link>
                           <div className="content">
                               <h3>
                                   <Link onClick={ () => this.viewProduct(product.productid)}>{product.productName}</Link>
                               </h3>
                               <span>${product.price}</span>
                               <p>{product.description}</p>
                               <button style={{bottom:"0px"}} onClick={()=> this.addtoCart(product.productid)}>Add to cart</button>
                           </div>
                       </div>
                   ))
               }
            </div>
            </div>


            </div>
        )
    }
}

export default ListUsers
