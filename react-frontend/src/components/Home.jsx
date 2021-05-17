import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import './css/ListProducts.css'
import ProductService from '../services/ProductService'
import CartService from '../services/CartService';
import './css/Home.css'

class Home extends Component {
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
                 <h2 className="text-center">Our Products</h2>

                
           
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
                               {/* <p>{product.description}</p> */}
                               <button style={{bottom:"0px"}} onClick={()=> this.addtoCart(product.productid)}>Add to cart</button>
                           </div>
                       </div>
                   ))
               }
                </div>
            </div>

            {/* <ProductWrapper className="col-9 mx-auto col-md-6 col-lg-3 my-3">
                <div className="card">
                <ProductConsumer>
                    {value => {
                    return (
                        <div
                        className="img-container p-5"
                        onClick={() => value.handleDetail(id)}
                        >
                        <Link to="/details">
                            <img src={img} alt="" className="card-img-top" />
                        </Link>
                        <button
                            className="cart-btn"
                            disabled={inCart ? true : false}
                            onClick={() => {
                            value.addToCart(id);
                            value.openModal(id);
                            }}
                        >
                            {inCart ? (
                            <p className="text-capitalize mb-0" disabled>
                                in cart
                            </p>
                            ) : (
                            <i className="fas fa-cart-plus" />
                            )}
                        </button>
                        </div>
                    );
                    }}
                </ProductConsumer>
                <div className="card-footer d-flex justify-content-between">
                    <p className="align-self-center mb-0">{title}</p>
                    <h5 className="text-blue font-italic mb-0">
                    <span className="mr-1">$</span>
                    {price}
                    </h5>
                </div>
                </div>
            </ProductWrapper> */}

        </div>

        
            
        )
    }
}

export default Home
